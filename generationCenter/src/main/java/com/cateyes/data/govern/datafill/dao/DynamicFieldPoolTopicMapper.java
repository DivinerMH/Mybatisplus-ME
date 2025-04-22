package com.cateyes.data.govern.datafill.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolTopicQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldPoolTopicDto;

/**
 * 动态表单字段池主题关联(DgDynamicFieldPoolTopic)Mapper
 *
 * @author CatEyes
 * @since 2023-12-04 19:36:11
 */
@Mapper
public interface DynamicFieldPoolTopicMapper extends BaseMapper<DynamicFieldPoolTopic> {

    /**
     * 详情查询
     * @param id 动态表单字段池主题关联id
     * @return 动态表单字段池主题关联展示对象RspDynamicFieldPoolTopicDto
     */
    RspDynamicFieldPoolTopicDto detail(@Param("id") Integer id);
    
    /**
     * 条件查询
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 动态表单字段池主题关联分页展示对象集合
     */
    IPage<RspDynamicFieldPoolTopicDto> queryByConditions(@Param("page")Page page, @Param("reqDto") ReqDynamicFieldPoolTopicQueryDto reqDto);
    
}
