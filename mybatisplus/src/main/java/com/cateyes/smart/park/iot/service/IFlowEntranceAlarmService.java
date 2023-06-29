package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RspflowEntranceAlarmDto;
import com.cateyes.smart.park.iot.bean.dto.ReqflowEntranceAlarmDto;
import com.cateyes.smart.park.iot.bean.po.flowEntranceAlarm;

/**
 * 视屏告警事件(SpIotFlowEntranceAlarm)service
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:40
 */

public interface IFlowEntranceAlarmService extends IService<FlowEntranceAlarm> {

    /**
     * 视屏告警事件-新增
     * 
     * @param reqDto
     *            视屏告警事件接收入参DTO
     * @return 主键ID
     */
    int saveFlowEntranceAlarm(ReqFlowEntranceAlarmDto reqDto);

    /**
     * 视屏告警事件-删除
     * 
     * @param id
     *            视屏告警事件id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteFlowEntranceAlarm(Integer id);

    /**
     * 视屏告警事件-修改
     * 
     * @param reqDto
     *            视屏告警事件接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateFlowEntranceAlarm(ReqFlowEntranceAlarmDto reqDto);

    /**
     * 视屏告警事件-详情
     * 
     * @param id
     *            视屏告警事件id
     * @return RspFlowEntranceAlarmDto展示对象
     */
    RspFlowEntranceAlarmDto queryDetail(Integer id);

    /**
     * 视屏告警事件-条件查询
     * 
     * @param reqDto
     *            视屏告警事件接收入参DTO
     * @return RspFlowEntranceAlarmDto展示对象List
     */
    List<RspFlowEntranceAlarmDto> queryList(ReqFlowEntranceAlarmDto reqDto);

    /**
     * 视屏告警事件-分页查询
     * 
     * @param reqDto
     *            视屏告警事件接收入参DTO
     * @return RspFlowEntranceAlarmDto展示对象IPage
     */
    PageInfo<RspFlowEntranceAlarmDto> queryPage(ReqFlowEntranceAlarmDto reqDto);

}
