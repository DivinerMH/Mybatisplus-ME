package com.cateyes.data.govern.datafill.service.impl;

    
    






import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldPoolTopicDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolTopicAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolTopicUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolTopicQueryDto;
import com.cateyes.data.govern.datafill.bean.po.DynamicFieldPoolTopic;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * 动态表单字段池主题关联(DgDynamicFieldPoolTopic)impl
 *
 * @author CatEyes
 * @since 2023-12-04 19:36:11
 */
@Service
@AllArgsConstructor
public class DynamicFieldPoolTopicServiceImpl implements IDynamicFieldPoolTopicService{

    private DynamicFieldPoolTopicMapper dynamicFieldPoolTopicMapper;

    @Override
    public int add(ReqDynamicFieldPoolTopicAddDto reqDto){
        // checkNameUnique(reqDto);
        DynamicFieldPoolTopic map = BeanMapperUtil.map(reqDto, DynamicFieldPoolTopic.class);
        int insert = dynamicFieldPoolTopicMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto){
        DynamicFieldPoolTopic entity = dynamicFieldPoolTopicMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return dynamicFieldPoolTopicMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqDynamicFieldPoolTopicUpdateDto reqDto){
        DynamicFieldPoolTopic dynamicFieldPoolTopic = dynamicFieldPoolTopicMapper.selectById(reqDto.getId());
        Assert.notNull(dynamicFieldPoolTopic, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(dynamicFieldPoolTopic.getName(), reqDto.getName())) {
            // checkNameUnique(reqDto);
        // }
        return dynamicFieldPoolTopicMapper.updateById(BeanMapperUtil.map(reqDto, DynamicFieldPoolTopic.class));
    }
    
    @Override
    public RspDynamicFieldPoolTopicDto detail(ReqIdDto reqDto){
        RspDynamicFieldPoolTopicDto rspDto = dynamicFieldPoolTopicMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspDynamicFieldPoolTopicDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }
    
    @Override
    public PageInfo<RspDynamicFieldPoolTopicDto> queryPage(ReqDynamicFieldPoolTopicQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }
    
    private PageInfo<RspDynamicFieldPoolTopicDto> queryPageConditions(ReqDynamicFieldPoolTopicQueryDto reqDto) {
        Page<RspDynamicFieldPoolTopicDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspDynamicFieldPoolTopicDto> pageInfo = dynamicFieldPoolTopicMapper.queryByConditions(page, reqDto);
        PageInfo<RspDynamicFieldPoolTopicDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }
    
    private void listConverter(List<RspDynamicFieldPoolTopicDto> list) {
        list.forEach(a -> {

        });
    }
    
}
