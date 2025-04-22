package com.cateyes.smart.park.report.service;

import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemAddDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemQueryDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemUpdateDto;
import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentItemDto;

/**
 * 智慧大屏-手工-招商项目(SpVtBsInvestmentItem)service
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:19
 */

public interface IVtBsInvestmentItemService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqVtBsInvestmentItemAddDto reqDto);

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
    int update(ReqVtBsInvestmentItemUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspVtBsInvestmentItemDto展示对象
     */
    RspVtBsInvestmentItemDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspVtBsInvestmentItemDto展示对象 PageInfo
     */
    PageInfo<RspVtBsInvestmentItemDto> queryPage(ReqVtBsInvestmentItemQueryDto reqDto);

}
