package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RsplightPoleAlarmDto;
import com.cateyes.smart.park.iot.bean.po.lightPoleAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 灯杆告警(SpIotLightPoleAlarm)Mapper
 *
 * @author CatEyes
 * @since 2023-06-25 14:28:48
 */
@Mapper
public interface LightPoleAlarmMapper extends BaseMapper<LightPoleAlarm> {

    /**
     * 根据id查询灯杆告警详情(跨服务)
     * 
     * @param id 灯杆告警id
     * @return 灯杆告警展示对象RspLightPoleAlarmDto
     */
    RspLightPoleAlarmDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询灯杆告警List
     * 
     * @param reqDto 灯杆告警接收入参DTO
     * @return 灯杆告警展示对象集合RspLightPoleAlarmDtoList
     */
    List<RspLightPoleAlarmDto> queryByConditions(@Param("reqDto") ReqLightPoleAlarmDto reqDto);

    /**
     * 条件查询灯杆告警Page
     * 
     * @param page 分页参数
     * @param reqDto 灯杆告警接收入参DTO
     * @return 灯杆告警展示对象集合RspLightPoleAlarmDtoList
     */
    IPage<RspLightPoleAlarmDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqLightPoleAlarmDto reqDto);

}
