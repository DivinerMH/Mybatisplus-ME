package com.cateyes.data.govern.datafill.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldPoolDto;

/**
 * 动态表单字段池(DgDynamicFieldPool)Mapper
 *
 * @author CatEyes
 * @since 2023-11-20 10:50:48
 */
@Mapper
public interface DynamicFieldPoolMapper extends BaseMapper<DynamicFieldPool> {

    /**
     * 详情查询
     * 
     * @param id 动态表单字段池id
     * @return 动态表单字段池展示对象RspDynamicFieldPoolDto
     */
    RspDynamicFieldPoolDto detail(@Param("id") Integer id);

    /**
     * 条件查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 动态表单字段池分页展示对象集合
     */
    IPage<RspDynamicFieldPoolDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqDynamicFieldPoolQueryDto reqDto);

}
