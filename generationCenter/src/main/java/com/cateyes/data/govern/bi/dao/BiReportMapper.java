package com.cateyes.data.govern.bi.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportQueryDto;
import com.cateyes.data.govern.bi.bean.dto.RspBiReportDto;
import com.cateyes.data.govern.bi.bean.po.BiReport;

/**
 * 报表(DgBiReport)Mapper
 *
 * @author CatEyes
 * @since 2024-01-16 15:41:42
 */
@Mapper
public interface BiReportMapper extends BaseMapper<BiReport> {

    /**
     * 详情查询
     * @param id 报表id
     * @return 报表展示对象RspBiReportDto
     */
    RspBiReportDto detail(@Param("id") Integer id);
    
    /**
     * 分页查询
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 报表分页展示对象集合
     */
    IPage<RspBiReportDto> queryByConditions(@Param("page")Page page, @Param("reqDto") ReqBiReportQueryDto reqDto);
    
}
