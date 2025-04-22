package com.cateyes.data.govern.datafill.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelFieldQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicModelFieldDto;

/**
 * 动态表单字段(DgDynamicModelField)Mapper
 *
 * @author CatEyes
 * @since 2023-11-20 13:56:08
 */
@Mapper
public interface DynamicModelFieldMapper extends BaseMapper<DynamicModelField> {

    /**
     * 详情查询
     * 
     * @param id 动态表单字段id
     * @return 动态表单字段展示对象RspDynamicModelFieldDto
     */
    RspDynamicModelFieldDto detail(@Param("id") Integer id);

    /**
     * 条件查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 动态表单字段分页展示对象集合
     */
    IPage<RspDynamicModelFieldDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqDynamicModelFieldQueryDto reqDto);

}
