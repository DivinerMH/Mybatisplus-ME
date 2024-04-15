package com.cateyes.data.govern.bi.service;

import com.cateyes.data.govern.bi.bean.dto.RspBiReportFieldDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportFieldAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportFieldUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportFieldQueryDto;

/**
 * 报表-字段管理(DgBiReportField)service
 *
 * @author CatEyes
 * @since 2024-03-19 14:41:41
 */

public interface IBiReportFieldService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqBiReportFieldAddDto reqDto);

    /**
     * 删除
     * 
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int del(ReqIdDto reqDto);

    /**
     * 修改
     * 
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int update(ReqBiReportFieldUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspBiReportFieldDto展示对象
     */
    RspBiReportFieldDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspBiReportFieldDto展示对象 PageInfo
     */
    PageInfo<RspBiReportFieldDto> queryPage(ReqBiReportFieldQueryDto reqDto);

}
