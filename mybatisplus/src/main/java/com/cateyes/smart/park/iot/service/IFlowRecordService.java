package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RspflowRecordDto;
import com.cateyes.smart.park.iot.bean.dto.ReqflowRecordDto;
import com.cateyes.smart.park.iot.bean.po.flowRecord;

/**
 * 人流管理-人流记录(SpIotFlowRecord)service
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:52
 */

public interface IFlowRecordService extends IService<FlowRecord> {

    /**
     * 人流管理-人流记录-新增
     * 
     * @param reqDto
     *            人流管理-人流记录接收入参DTO
     * @return 主键ID
     */
    int saveFlowRecord(ReqFlowRecordDto reqDto);

    /**
     * 人流管理-人流记录-删除
     * 
     * @param id
     *            人流管理-人流记录id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteFlowRecord(Integer id);

    /**
     * 人流管理-人流记录-修改
     * 
     * @param reqDto
     *            人流管理-人流记录接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateFlowRecord(ReqFlowRecordDto reqDto);

    /**
     * 人流管理-人流记录-详情
     * 
     * @param id
     *            人流管理-人流记录id
     * @return RspFlowRecordDto展示对象
     */
    RspFlowRecordDto queryDetail(Integer id);

    /**
     * 人流管理-人流记录-条件查询
     * 
     * @param reqDto
     *            人流管理-人流记录接收入参DTO
     * @return RspFlowRecordDto展示对象List
     */
    List<RspFlowRecordDto> queryList(ReqFlowRecordDto reqDto);

    /**
     * 人流管理-人流记录-分页查询
     * 
     * @param reqDto
     *            人流管理-人流记录接收入参DTO
     * @return RspFlowRecordDto展示对象IPage
     */
    PageInfo<RspFlowRecordDto> queryPage(ReqFlowRecordDto reqDto);

}
