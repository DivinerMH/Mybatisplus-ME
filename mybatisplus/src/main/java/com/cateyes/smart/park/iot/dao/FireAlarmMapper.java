package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RspfireAlarmDto;
import com.cateyes.smart.park.iot.bean.po.fireAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消防告警(SpIotFireAlarm)Mapper
 *
 * @author CatEyes
 * @since 2023-06-21 18:12:13
 */
@Mapper
public interface FireAlarmMapper extends BaseMapper<FireAlarm> {

    /**
     * 根据id查询消防告警详情(跨服务)
     * 
     * @param id 消防告警id
     * @return 消防告警展示对象RspFireAlarmDto
     */
    RspFireAlarmDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询消防告警List
     * 
     * @param reqDto 消防告警接收入参DTO
     * @return 消防告警展示对象集合RspFireAlarmDtoList
     */
    List<RspFireAlarmDto> queryByConditions(@Param("reqDto") ReqFireAlarmDto reqDto);

    /**
     * 条件查询消防告警Page
     * 
     * @param page 分页参数
     * @param reqDto 消防告警接收入参DTO
     * @return 消防告警展示对象集合RspFireAlarmDtoList
     */
    IPage<RspFireAlarmDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqFireAlarmDto reqDto);

}
