package com.cateyes.data.govern.datafill.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldTopicQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldTopicDto;

/**
 * 动态表单字段主题(DgDynamicFieldTopic)Mapper
 *
 * @author CatEyes
 * @since 2023-12-05 09:30:06
 */
@Mapper
public interface DynamicFieldTopicMapper extends BaseMapper<DynamicFieldTopic> {

    /**
     * 详情查询
     * 
     * @param id 动态表单字段主题id
     * @return 动态表单字段主题展示对象RspDynamicFieldTopicDto
     */
    RspDynamicFieldTopicDto detail(@Param("id") Integer id);

    /**
     * 条件查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 动态表单字段主题分页展示对象集合
     */
    IPage<RspDynamicFieldTopicDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqDynamicFieldTopicQueryDto reqDto);

}
