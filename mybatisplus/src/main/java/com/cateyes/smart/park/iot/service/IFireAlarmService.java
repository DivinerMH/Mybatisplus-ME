package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RspfireAlarmDto;
import com.cateyes.smart.park.iot.bean.dto.ReqfireAlarmDto;
import com.cateyes.smart.park.iot.bean.po.fireAlarm;

/**
 * 消防告警(SpIotFireAlarm)service
 *
 * @author CatEyes
 * @since 2023-06-21 18:12:13
 */

public interface IFireAlarmService {

    /**
     * 消防告警-新增
     * 
     * @param reqDto 消防告警接收入参DTO
     * @return 主键ID
     */
    int saveFireAlarm(ReqFireAlarmDto reqDto);

    /**
     * 消防告警-删除
     * 
     * @param id 消防告警id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteFireAlarm(Integer id);

    /**
     * 消防告警-修改
     * 
     * @param reqDto 消防告警接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateFireAlarm(ReqFireAlarmDto reqDto);

    /**
     * 消防告警-详情
     * 
     * @param id 消防告警id
     * @return RspFireAlarmDto展示对象
     */
    RspFireAlarmDto queryDetail(Integer id);

    /**
     * 消防告警-条件查询
     * 
     * @param reqDto 消防告警接收入参DTO
     * @return RspFireAlarmDto展示对象List
     */
    List<RspFireAlarmDto> queryList(ReqFireAlarmDto reqDto);

    /**
     * 消防告警-分页查询
     * 
     * @param reqDto 消防告警接收入参DTO
     * @return RspFireAlarmDto展示对象IPage
     */
    PageInfo<RspFireAlarmDto> queryPage(ReqFireAlarmDto reqDto);

}
