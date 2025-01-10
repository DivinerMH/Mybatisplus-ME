package com.cateyes.data.govern.bi.service;

    
    





import com.base.dto.ReqIdDto;
import com.base.util.PageInfo;
import com.cateyes.data.govern.bi.bean.dto.RspBiReportDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportQueryDto;

/**
 * 报表(DgBiReport)service
 *
 * @author CatEyes
 * @since 2024-01-16 15:41:42
 */

public interface IBiReportService {

    /**
     * 新增
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqBiReportAddDto reqDto);

    /**
     * 删除
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int del(ReqIdDto reqDto);

    /**
     * 修改
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int update(ReqBiReportUpdateDto reqDto);

    /**
     * 详情
     * @param reqDto 入参DTO
     * @return RspBiReportDto展示对象
     */
    RspBiReportDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * @param reqDto 入参DTO
     * @return RspBiReportDto展示对象 PageInfo
     */
    PageInfo<RspBiReportDto> queryPage(ReqBiReportQueryDto reqDto);
    
}
