package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RspsmokeAlarmDto;
import com.cateyes.smart.park.iot.bean.dto.ReqsmokeAlarmDto;
import com.cateyes.smart.park.iot.bean.po.smokeAlarm;

/**
 * 烟感告警事件(SpIotSmokeAlarm)service
 *
 * @author CatEyes
 * @since 2023-06-19 16:40:10
 */

public interface ISmokeAlarmService extends IService<SmokeAlarm> {

    /**
     * 烟感告警事件-新增
     * 
     * @param reqDto
     *            烟感告警事件接收入参DTO
     * @return 主键ID
     */
    int saveSmokeAlarm(ReqSmokeAlarmDto reqDto);

    /**
     * 烟感告警事件-删除
     * 
     * @param id
     *            烟感告警事件id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteSmokeAlarm(Integer id);

    /**
     * 烟感告警事件-修改
     * 
     * @param reqDto
     *            烟感告警事件接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateSmokeAlarm(ReqSmokeAlarmDto reqDto);

    /**
     * 烟感告警事件-详情
     * 
     * @param id
     *            烟感告警事件id
     * @return RspSmokeAlarmDto展示对象
     */
    RspSmokeAlarmDto queryDetail(Integer id);

    /**
     * 烟感告警事件-条件查询
     * 
     * @param reqDto
     *            烟感告警事件接收入参DTO
     * @return RspSmokeAlarmDto展示对象List
     */
    List<RspSmokeAlarmDto> queryList(ReqSmokeAlarmDto reqDto);

    /**
     * 烟感告警事件-分页查询
     * 
     * @param reqDto
     *            烟感告警事件接收入参DTO
     * @return RspSmokeAlarmDto展示对象IPage
     */
    PageInfo<RspSmokeAlarmDto> queryPage(ReqSmokeAlarmDto reqDto);

}
