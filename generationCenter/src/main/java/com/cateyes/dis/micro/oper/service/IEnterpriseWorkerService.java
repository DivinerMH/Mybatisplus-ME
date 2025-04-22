package com.cateyes.dis.micro.oper.service;

import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseWorkerAddDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseWorkerQueryDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseWorkerUpdateDto;
import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseWorkerDto;

/**
 * 企业用工(DisEnterpriseWorker)service
 *
 * @author CatEyes
 * @since 2024-02-01 19:30:35
 */

public interface IEnterpriseWorkerService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqEnterpriseWorkerAddDto reqDto);

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
    int update(ReqEnterpriseWorkerUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspEnterpriseWorkerDto展示对象
     */
    RspEnterpriseWorkerDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspEnterpriseWorkerDto展示对象 PageInfo
     */
    PageInfo<RspEnterpriseWorkerDto> queryPage(ReqEnterpriseWorkerQueryDto reqDto);

}
