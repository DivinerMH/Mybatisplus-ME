package com.tsy.repository.listener;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsy.common.data.kafka.InputParam;
import com.tsy.repository.api.dto.GroovyParamsDTO;
import com.tsy.repository.api.entity.CalculateParams;
import com.tsy.repository.api.entity.DisasterGrade;
import com.tsy.repository.mapper.CalculateParamsMapper;
import com.tsy.repository.mapper.DisasterGradeMapper;
import com.tsy.repository.service.ICalculateCurrencyService;
import com.tsy.repository.utils.RomeToArabic;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
@AllArgsConstructor
@Slf4j
public class CalculateRedisListener {

    private ObjectMapper objectMapper;

    private KafkaTemplate<String,String> kafkaTemplate;

    private ICalculateCurrencyService iCalculateCurrencyService;

    private CalculateParamsMapper calculateParamsMapper;

    private DisasterGradeMapper disasterGradeMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @KafkaListener(topics = {"output-topic999"},groupId = "redis",id = "redis")
    public void inference(ConsumerRecord<?,String> consumerRecord){
        log.info("接收到kafka消息：{}",consumerRecord);
        String value = consumerRecord.value();
        log.info("正在解析kafka消息...");
        List<Map<Object,Object>> list;
        try {
            list = objectMapper.readValue(value, List.class);
        } catch (JsonProcessingException e) {
            log.error("解析失败..");
            e.printStackTrace();
            return;
        }
        log.info("解析成功,计算引擎数据:{}",list);
        if(list == null){
            log.info("计算引擎数据错误..");
            return;
        }
        //从环境变量中获取计算引擎id
        // Integer calculateId = Integer.parseInt(System.getenv("calculate-engine"));
        Integer calculateId = 26;
        Object maxValue = redisTemplate.opsForHash().get("calculateCurrency",calculateId.toString());
        // 参数拼接过程
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            if( i > 0){
                stringBuilder.append(",");
            }
            /* 注意：灾害等级判定，从规则引擎哪里获取的值只是等级id，非等级具体value，且等级具体value为：罗马数字（>∧<）
             * 监听Topic,结果集处理 */
            Object paramValue = list.get(i).get("paramValue");
            Integer paramId = Integer.parseInt(paramValue.toString());
            DisasterGrade disasterGrade = disasterGradeMapper.selectById(paramId);
            if(null != disasterGrade && StringUtils.isNotBlank(disasterGrade.getName())){
                String armString = disasterGrade.getName().replace("级", "");
                Integer gradeValue = RomeToArabic.r2a(armString);
                stringBuilder.append(gradeValue);
            }
            if(null != maxValue && i == list.size()-1){
                stringBuilder.append(",");
                stringBuilder.append(maxValue);
            }
        }

        // 参数处理
        GroovyParamsDTO groovyParamsDTO = new GroovyParamsDTO();
        groovyParamsDTO.setParams(stringBuilder.toString());
        groovyParamsDTO.setId(calculateId);

        String s = iCalculateCurrencyService.calculateCurrencyExecute(groovyParamsDTO);


        // 计算引擎出参转换
        LambdaQueryWrapper<CalculateParams> eq = Wrappers.<CalculateParams>lambdaQuery()
                .eq(CalculateParams::getCalculateType,"0")
                .eq(CalculateParams::getCalculateId, calculateId)
                .eq(CalculateParams::getParamType,"1");
        List<CalculateParams> calculateParams = calculateParamsMapper.selectList(eq);

        List<InputParam> inputParamResultList = new ArrayList<>();
        for (CalculateParams calculateParam : calculateParams) {
            InputParam inputParam = new InputParam();
            inputParam.setParamId(calculateParam.getParamKey());
            inputParam.setParamValue(s);
            inputParamResultList.add(inputParam);
        }


        try {
            kafkaTemplate.send(System.getenv("output-topic"),objectMapper.writeValueAsString(inputParamResultList)).get();
        } catch (JsonProcessingException | InterruptedException | ExecutionException e) {
            log.error("发送失败..");
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
