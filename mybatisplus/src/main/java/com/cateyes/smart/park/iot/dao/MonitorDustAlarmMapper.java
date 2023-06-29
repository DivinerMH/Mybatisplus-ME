package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RspmonitorDustAlarmDto;
import com.cateyes.smart.park.iot.bean.po.monitorDustAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 粉尘监测仪告警(SpIotMonitorDustAlarm)Mapper
 *
 * @author CatEyes
 * @since 2023-06-25 11:13:06
 */
@Mapper
public interface MonitorDustAlarmMapper extends BaseMapper<MonitorDustAlarm> {

    /**
     * 根据id查询粉尘监测仪告警详情(跨服务)
     * 
     * @param id 粉尘监测仪告警id
     * @return 粉尘监测仪告警展示对象RspMonitorDustAlarmDto
     */
    RspMonitorDustAlarmDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询粉尘监测仪告警List
     * 
     * @param reqDto 粉尘监测仪告警接收入参DTO
     * @return 粉尘监测仪告警展示对象集合RspMonitorDustAlarmDtoList
     */
    List<RspMonitorDustAlarmDto> queryByConditions(@Param("reqDto") ReqMonitorDustAlarmDto reqDto);

    /**
     * 条件查询粉尘监测仪告警Page
     * 
     * @param page 分页参数
     * @param reqDto 粉尘监测仪告警接收入参DTO
     * @return 粉尘监测仪告警展示对象集合RspMonitorDustAlarmDtoList
     */
    IPage<RspMonitorDustAlarmDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqMonitorDustAlarmDto reqDto);

}
