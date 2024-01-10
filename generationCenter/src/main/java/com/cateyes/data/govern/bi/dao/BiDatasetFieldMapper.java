package com.cateyes.data.govern.bi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.bi.bean.dto.RspBiDatasetFieldDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiDatasetFieldQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据集-字段管理(DgBiDatasetField)Mapper
 *
 * @author CatEyes
 * @since 2023-12-21 14:40:45
 */
@Mapper
public interface BiDatasetFieldMapper extends BaseMapper<BiDatasetField> {

    /**
     * 详情查询
     * 
     * @param id 数据集-字段管理id
     * @return 数据集-字段管理展示对象RspBiDatasetFieldDto
     */
    RspBiDatasetFieldDto detail(@Param("id") Integer id);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 数据集-字段管理分页展示对象集合
     */
    IPage<RspBiDatasetFieldDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqBiDatasetFieldQueryDto reqDto);

}
