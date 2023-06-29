package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RspflowEntranceAlarmDto;
import com.cateyes.smart.park.iot.bean.po.flowEntranceAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 视屏告警事件(SpIotFlowEntranceAlarm)Mapper
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:39
 */
@Mapper
public interface FlowEntranceAlarmMapper extends BaseMapper<FlowEntranceAlarm> {

    /**
     * 根据id查询视屏告警事件详情(跨服务)
     * 
     * @param id
     *            视屏告警事件id
     * @return 视屏告警事件展示对象RspFlowEntranceAlarmDto
     */
    RspFlowEntranceAlarmDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询视屏告警事件List
     * 
     * @param reqDto
     *            视屏告警事件接收入参DTO
     * @return 视屏告警事件展示对象集合RspFlowEntranceAlarmDtoList
     */
    List<RspFlowEntranceAlarmDto> queryByConditions(@Param("reqDto") ReqFlowEntranceAlarmDto reqDto);

    /**
     * 条件查询视屏告警事件Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            视屏告警事件接收入参DTO
     * @return 视屏告警事件展示对象集合RspflowEntranceAlarmDtoList
     */
    IPage<RspFlowEntranceAlarmDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqFlowEntranceAlarmDto reqDto);

}
