package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RsplightPoleAlarmDto;
import com.cateyes.smart.park.iot.bean.dto.ReqlightPoleAlarmDto;
import com.cateyes.smart.park.iot.bean.po.lightPoleAlarm;

/**
 * 灯杆告警(SpIotLightPoleAlarm)service
 *
 * @author CatEyes
 * @since 2023-06-25 14:28:49
 */

public interface ILightPoleAlarmService {

    /**
     * 灯杆告警-新增
     * 
     * @param reqDto 灯杆告警接收入参DTO
     * @return 主键ID
     */
    int saveLightPoleAlarm(ReqLightPoleAlarmDto reqDto);

    /**
     * 灯杆告警-删除
     * 
     * @param id 灯杆告警id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteLightPoleAlarm(Integer id);

    /**
     * 灯杆告警-修改
     * 
     * @param reqDto 灯杆告警接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateLightPoleAlarm(ReqLightPoleAlarmDto reqDto);

    /**
     * 灯杆告警-详情
     * 
     * @param id 灯杆告警id
     * @return RspLightPoleAlarmDto展示对象
     */
    RspLightPoleAlarmDto queryDetail(Integer id);

    /**
     * 灯杆告警-条件查询
     * 
     * @param reqDto 灯杆告警接收入参DTO
     * @return RspLightPoleAlarmDto展示对象List
     */
    List<RspLightPoleAlarmDto> queryList(ReqLightPoleAlarmDto reqDto);

    /**
     * 灯杆告警-分页查询
     * 
     * @param reqDto 灯杆告警接收入参DTO
     * @return RspLightPoleAlarmDto展示对象IPage
     */
    PageInfo<RspLightPoleAlarmDto> queryPage(ReqLightPoleAlarmDto reqDto);

}
