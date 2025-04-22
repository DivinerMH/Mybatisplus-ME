package com.cateyes.data.govern.datafill.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstFieldQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.RspFormInstFieldDto;

/**
 * 表单实例数据(DgFormInstField)Mapper
 *
 * @author CatEyes
 * @since 2023-11-21 10:16:35
 */
@Mapper
public interface FormInstFieldMapper extends BaseMapper<FormInstField> {

    /**
     * 详情查询
     * 
     * @param id 表单实例数据id
     * @return 表单实例数据展示对象RspFormInstFieldDto
     */
    RspFormInstFieldDto detail(@Param("id") Integer id);

    /**
     * 条件查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 表单实例数据分页展示对象集合
     */
    IPage<RspFormInstFieldDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqFormInstFieldQueryDto reqDto);

}
