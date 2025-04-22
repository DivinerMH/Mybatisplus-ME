package com.cateyes.data.govern.datafill.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldTopicAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldTopicQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldTopicUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldTopicDto;
import com.cateyes.data.govern.datafill.bean.po.DynamicFieldTopic;

/**
 * 动态表单字段主题(DgDynamicFieldTopic)impl
 *
 * @author CatEyes
 * @since 2023-12-05 09:30:08
 */
@Service
@AllArgsConstructor
public class DynamicFieldTopicServiceImpl implements IDynamicFieldTopicService {

    private DynamicFieldTopicMapper dynamicFieldTopicMapper;

    @Override
    public int add(ReqDynamicFieldTopicAddDto reqDto) {
        // checkNameUnique(reqDto);
        DynamicFieldTopic map = BeanMapperUtil.map(reqDto, DynamicFieldTopic.class);
        int insert = dynamicFieldTopicMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        DynamicFieldTopic entity = dynamicFieldTopicMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return dynamicFieldTopicMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqDynamicFieldTopicUpdateDto reqDto) {
        DynamicFieldTopic dynamicFieldTopic = dynamicFieldTopicMapper.selectById(reqDto.getId());
        Assert.notNull(dynamicFieldTopic, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(dynamicFieldTopic.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto);
        // }
        return dynamicFieldTopicMapper.updateById(BeanMapperUtil.map(reqDto, DynamicFieldTopic.class));
    }

    @Override
    public RspDynamicFieldTopicDto detail(ReqIdDto reqDto) {
        RspDynamicFieldTopicDto rspDto = dynamicFieldTopicMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspDynamicFieldTopicDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspDynamicFieldTopicDto> queryPage(ReqDynamicFieldTopicQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspDynamicFieldTopicDto> queryPageConditions(ReqDynamicFieldTopicQueryDto reqDto) {
        Page<RspDynamicFieldTopicDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspDynamicFieldTopicDto> pageInfo = dynamicFieldTopicMapper.queryByConditions(page, reqDto);
        PageInfo<RspDynamicFieldTopicDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspDynamicFieldTopicDto> list) {
        list.forEach(a -> {

        });
    }

}
