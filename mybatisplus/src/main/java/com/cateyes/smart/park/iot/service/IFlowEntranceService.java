package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RspflowEntranceDto;
import com.cateyes.smart.park.iot.bean.dto.ReqflowEntranceDto;
import com.cateyes.smart.park.iot.bean.po.flowEntrance;

/**
 * 人流管理-门禁设备(SpIotFlowEntrance)service
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:26
 */

public interface IFlowEntranceService extends IService<FlowEntrance> {

    /**
     * 人流管理-门禁设备-新增
     * 
     * @param reqDto
     *            人流管理-门禁设备接收入参DTO
     * @return 主键ID
     */
    int saveFlowEntrance(ReqFlowEntranceDto reqDto);

    /**
     * 人流管理-门禁设备-删除
     * 
     * @param id
     *            人流管理-门禁设备id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteFlowEntrance(Integer id);

    /**
     * 人流管理-门禁设备-修改
     * 
     * @param reqDto
     *            人流管理-门禁设备接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateFlowEntrance(ReqFlowEntranceDto reqDto);

    /**
     * 人流管理-门禁设备-详情
     * 
     * @param id
     *            人流管理-门禁设备id
     * @return RspFlowEntranceDto展示对象
     */
    RspFlowEntranceDto queryDetail(Integer id);

    /**
     * 人流管理-门禁设备-条件查询
     * 
     * @param reqDto
     *            人流管理-门禁设备接收入参DTO
     * @return RspFlowEntranceDto展示对象List
     */
    List<RspFlowEntranceDto> queryList(ReqFlowEntranceDto reqDto);

    /**
     * 人流管理-门禁设备-分页查询
     * 
     * @param reqDto
     *            人流管理-门禁设备接收入参DTO
     * @return RspFlowEntranceDto展示对象IPage
     */
    PageInfo<RspFlowEntranceDto> queryPage(ReqFlowEntranceDto reqDto);

}
