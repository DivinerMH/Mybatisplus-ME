package com.tsy.repository.listener;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsy.common.core.constant.CommonConstants;
import com.tsy.repository.api.dto.GroovyParamsDTO;
import com.tsy.repository.api.dto.TempConfigValueDTO;
import com.tsy.repository.api.entity.CalculateParams;
import com.tsy.repository.api.vo.CalculateCurrencyVO;
import com.tsy.repository.api.vo.CalculateParamsVO;
import com.tsy.repository.mapper.CalculateParamsMapper;
import com.tsy.repository.service.ICalculateCurrencyService;
import com.tsy.repository.service.ITempConfigValueService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class CalculateListener {

    private ObjectMapper objectMapper;

    private KafkaTemplate<String,String> kafkaTemplate;

    private ICalculateCurrencyService iCalculateCurrencyService;

    private CalculateParamsMapper calculateParamsMapper;

    private ITempConfigValueService iTempConfigValueService;

    @KafkaListener(topics = {"${input-topic}"},groupId = "${group-id}",id = "calculate")
    public void inference(ConsumerRecord<?,String> consumerRecord){
        log.info("接收到kafka消息：{}",consumerRecord);
        String value = consumerRecord.value();
        log.info("正在解析kafka消息...");
        Map<Object,Object> dataMap;
        try {
            dataMap = objectMapper.readValue(value, Map.class);
        } catch (JsonProcessingException e) {
            log.error("解析失败..");
            e.printStackTrace();
            return;
        }
        log.info("解析成功,计算引擎数据:{}",dataMap);
        if(dataMap == null){
            log.info("计算引擎数据错误...");
            return;
        }

        List<Map<Object,Object>> list = (List<Map<Object,Object>>) dataMap.get("data");
        //从环境变量中获取计算引擎id
        Integer calculateId = Integer.parseInt(System.getenv("calculate-engine"));

        // 参数拼接过程
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            if( i > 0){
                stringBuilder.append(",");
            }
            stringBuilder.append(list.get(i).get("paramValue"));
        }

        // 参数处理
        GroovyParamsDTO groovyParamsDTO = new GroovyParamsDTO();
        groovyParamsDTO.setParams(stringBuilder.toString());
        groovyParamsDTO.setId(calculateId);
        String s = iCalculateCurrencyService.calculateCurrencyExecute(groovyParamsDTO);

        // TODO 计算引擎出参转换
        LambdaQueryWrapper<CalculateParams> eq = Wrappers.<CalculateParams>lambdaQuery()
                .eq(CalculateParams::getCalculateType,"0")
                .eq(CalculateParams::getCalculateId, calculateId)
                .eq(CalculateParams::getParamType,"1");
        List<CalculateParams> calculateParams = calculateParamsMapper.selectList(eq);

        Map<String,Object> map = new HashMap<>();
        map.put("paramSource",dataMap.get("paramSource"));

        List<Map<String,Object>> mapList = new LinkedList<>();
        for (CalculateParams calculateParam : calculateParams) {
            Map<String,Object> outMap = new HashMap<>();
            // 只要出参
            if(CommonConstants.TYPE_ONE.equals(calculateParam.getParamType())){
                outMap.put("paramId",calculateParam.getParamKey());
                outMap.put("paramValue",s);
                mapList.add(outMap);
            }
        }
        map.put("data",mapList);

        // 发送到kafka队列中
        try {
            log.info("消息推送开始...通用计算引擎推送数据:{}",map);
            kafkaTemplate.send(System.getenv("output-topic"),objectMapper.writeValueAsString(map)).get();
        } catch (JsonProcessingException | InterruptedException | ExecutionException e) {
            log.error("发送失败...");
            e.printStackTrace();
        }

        // 结果数据实例化至
        try {
            TempConfigValueDTO tempConfigValueDTO = new TempConfigValueDTO();
            tempConfigValueDTO.setTempId(Integer.parseInt(System.getenv("template-id")));
            tempConfigValueDTO.setConfigId(Integer.parseInt(System.getenv("template-config-id")));
            tempConfigValueDTO.setCalculateType(System.getenv("calculate-type"));
            tempConfigValueDTO.setCalculateId(Integer.parseInt(System.getenv("calculate-engine")));
            // tempConfigValueDTO.setDateSourceType(System.getenv("date-source-type"));
            // tempConfigValueDTO.setDateSourceId(System.getenv("date-source-id"));
            // 数据源类型（存在同一容器，监听多个感应器的数据，故需要动态传递，有数据源传递过来）
            if(StringUtils.isNotBlank(dataMap.get("paramSource").toString())){
                tempConfigValueDTO.setDateSourceType("6");
                tempConfigValueDTO.setDateSourceId(dataMap.get("paramSource").toString());
            }
            tempConfigValueDTO.setIdentification(System.getenv("identification"));
            // 查询所得参数
            if(CommonConstants.TYPE_ONE.equals(System.getenv("calculate-type"))){
                CalculateCurrencyVO calculateCurrencyVO = iCalculateCurrencyService.queryCalculateCurrencyDetail(Integer.parseInt(System.getenv("calculate-engine")));
                if(null != calculateCurrencyVO){
                    List<CalculateParamsVO> calculateParamsVOList = calculateCurrencyVO.getCalculateParamsVOList();
                    List<CalculateParamsVO> collect = calculateParamsVOList.stream()
                            .filter(e -> CommonConstants.TYPE_ONE.equals(e.getParamType()))
                            .collect(Collectors.toList());
                    if(null != collect.get(0).getParamKey()){
                        tempConfigValueDTO.setParamKey(collect.get(0).getParamKey());
                    }
                }
            }
            tempConfigValueDTO.setValue(s);
            iTempConfigValueService.saveTempConfigValue(tempConfigValueDTO);
        }catch (Exception e) {
            log.error("结果数据实例化失败...");
            e.printStackTrace();
        }
    }

    // ME:calculate_output_topic
    // 推送对应的值：calculate_output_topic
    /*@KafkaListener(topics = {"calculate_output_topic"},groupId = "calculate",id = "calculate-out")
    public void test(ConsumerRecord<?,String> consumerRecord){
        log.info("收到kafka消息:{}",consumerRecord);
        String value = consumerRecord.value();
        log.info("输出参数:{}",value);
    }*/



}
