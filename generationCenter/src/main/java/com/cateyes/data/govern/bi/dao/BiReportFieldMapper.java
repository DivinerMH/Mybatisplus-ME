package com.cateyes.data.govern.bi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportFieldQueryDto;
import com.cateyes.data.govern.bi.bean.dto.RspBiReportFieldDto;

/**
 * 报表-字段管理(DgBiReportField)Mapper
 *
 * @author CatEyes
 * @since 2024-03-19 14:41:41
 */
@Mapper
public interface BiReportFieldMapper extends BaseMapper<BiReportField> {

    /**
     * 详情查询
     * 
     * @param id 报表-字段管理id
     * @return 报表-字段管理展示对象RspBiReportFieldDto
     */
    RspBiReportFieldDto detail(@Param("id") Integer id);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 报表-字段管理分页展示对象集合
     */
    IPage<RspBiReportFieldDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqBiReportFieldQueryDto reqDto);

}
