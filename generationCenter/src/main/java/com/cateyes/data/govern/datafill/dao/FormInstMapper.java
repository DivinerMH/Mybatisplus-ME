package com.cateyes.data.govern.datafill.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.RspFormInstDto;

/**
 * 表单实例(DgFormInst)Mapper
 *
 * @author CatEyes
 * @since 2023-11-21 10:16:01
 */
@Mapper
public interface FormInstMapper extends BaseMapper<FormInst> {

    /**
     * 详情查询
     * 
     * @param id 表单实例id
     * @return 表单实例展示对象RspFormInstDto
     */
    RspFormInstDto detail(@Param("id") Integer id);

    /**
     * 条件查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 表单实例分页展示对象集合
     */
    IPage<RspFormInstDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqFormInstQueryDto reqDto);

}
