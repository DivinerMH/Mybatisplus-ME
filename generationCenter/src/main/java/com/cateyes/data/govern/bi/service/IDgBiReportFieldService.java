package com.cateyes.data.govern.bi.service;

import com.cateyes.data.govern.bi.bean.dto.ReqDgBiReportFieldAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqDgBiReportFieldQueryDto;
import com.cateyes.data.govern.bi.bean.dto.ReqDgBiReportFieldUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.RspDgBiReportFieldDto;

/**
 * 报表-字段管理(DgBiReportField)service
 *
 * @author CatEyes
 * @since 2024-03-19 14:40:06
 */

public interface IDgBiReportFieldService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqDgBiReportFieldAddDto reqDto);

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
    int update(ReqDgBiReportFieldUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspDgBiReportFieldDto展示对象
     */
    RspDgBiReportFieldDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspDgBiReportFieldDto展示对象 PageInfo
     */
    PageInfo<RspDgBiReportFieldDto> queryPage(ReqDgBiReportFieldQueryDto reqDto);

}
