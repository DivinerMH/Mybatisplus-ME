package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RspmonitorDustAlarmDto;
import com.cateyes.smart.park.iot.bean.dto.ReqmonitorDustAlarmDto;
import com.cateyes.smart.park.iot.bean.po.monitorDustAlarm;

/**
 * 粉尘监测仪告警(SpIotMonitorDustAlarm)service
 *
 * @author CatEyes
 * @since 2023-06-25 11:13:06
 */

public interface IMonitorDustAlarmService {

    /**
     * 粉尘监测仪告警-新增
     * 
     * @param reqDto 粉尘监测仪告警接收入参DTO
     * @return 主键ID
     */
    int saveMonitorDustAlarm(ReqMonitorDustAlarmDto reqDto);

    /**
     * 粉尘监测仪告警-删除
     * 
     * @param id 粉尘监测仪告警id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteMonitorDustAlarm(Integer id);

    /**
     * 粉尘监测仪告警-修改
     * 
     * @param reqDto 粉尘监测仪告警接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateMonitorDustAlarm(ReqMonitorDustAlarmDto reqDto);

    /**
     * 粉尘监测仪告警-详情
     * 
     * @param id 粉尘监测仪告警id
     * @return RspMonitorDustAlarmDto展示对象
     */
    RspMonitorDustAlarmDto queryDetail(Integer id);

    /**
     * 粉尘监测仪告警-条件查询
     * 
     * @param reqDto 粉尘监测仪告警接收入参DTO
     * @return RspMonitorDustAlarmDto展示对象List
     */
    List<RspMonitorDustAlarmDto> queryList(ReqMonitorDustAlarmDto reqDto);

    /**
     * 粉尘监测仪告警-分页查询
     * 
     * @param reqDto 粉尘监测仪告警接收入参DTO
     * @return RspMonitorDustAlarmDto展示对象IPage
     */
    PageInfo<RspMonitorDustAlarmDto> queryPage(ReqMonitorDustAlarmDto reqDto);

}
