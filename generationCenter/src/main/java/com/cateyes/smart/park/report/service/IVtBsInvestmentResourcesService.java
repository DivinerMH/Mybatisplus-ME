package com.cateyes.smart.park.report.service;

import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentResourcesAddDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentResourcesQueryDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentResourcesUpdateDto;
import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentResourcesDto;

/**
 * 智慧大屏-手工-招商资源(SpVtBsInvestmentResources)service
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:48
 */

public interface IVtBsInvestmentResourcesService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqVtBsInvestmentResourcesAddDto reqDto);

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
    int update(ReqVtBsInvestmentResourcesUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspVtBsInvestmentResourcesDto展示对象
     */
    RspVtBsInvestmentResourcesDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspVtBsInvestmentResourcesDto展示对象 PageInfo
     */
    PageInfo<RspVtBsInvestmentResourcesDto> queryPage(ReqVtBsInvestmentResourcesQueryDto reqDto);

}
