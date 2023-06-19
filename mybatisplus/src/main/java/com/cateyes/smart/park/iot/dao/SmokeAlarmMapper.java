package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RspsmokeAlarmDto;
import com.cateyes.smart.park.iot.bean.po.smokeAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 烟感告警事件(SpIotSmokeAlarm)Mapper
 *
 * @author CatEyes
 * @since 2023-06-19 16:40:10
 */
@Mapper
public interface SmokeAlarmMapper extends BaseMapper<SmokeAlarm> {

    /**
     * 根据id查询烟感告警事件详情(跨服务)
     * 
     * @param id
     *            烟感告警事件id
     * @return 烟感告警事件展示对象RspSmokeAlarmDto
     */
    RspSmokeAlarmDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询烟感告警事件List
     * 
     * @param reqDto
     *            烟感告警事件接收入参DTO
     * @return 烟感告警事件展示对象集合RspSmokeAlarmDtoList
     */
    List<RspSmokeAlarmDto> queryByConditions(@Param("reqDto") ReqSmokeAlarmDto reqDto);

    /**
     * 条件查询烟感告警事件Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            烟感告警事件接收入参DTO
     * @return 烟感告警事件展示对象集合RspsmokeAlarmDtoList
     */
    IPage<RspSmokeAlarmDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqSmokeAlarmDto reqDto);

}
