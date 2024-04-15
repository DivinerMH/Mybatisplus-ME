package com.cateyes.smart.park.report.service;

import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentItemIndustryDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemIndustryAddDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemIndustryUpdateDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemIndustryQueryDto;

/**
 * 智慧大屏-手工-招商项目-产业项目分布(SpVtBsInvestmentItemIndustry)service
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:39
 */

public interface IVtBsInvestmentItemIndustryService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqVtBsInvestmentItemIndustryAddDto reqDto);

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
    int update(ReqVtBsInvestmentItemIndustryUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspVtBsInvestmentItemIndustryDto展示对象
     */
    RspVtBsInvestmentItemIndustryDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspVtBsInvestmentItemIndustryDto展示对象 PageInfo
     */
    PageInfo<RspVtBsInvestmentItemIndustryDto> queryPage(ReqVtBsInvestmentItemIndustryQueryDto reqDto);

}
