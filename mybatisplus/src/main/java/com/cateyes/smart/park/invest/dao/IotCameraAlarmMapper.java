package com.cateyes.smart.park.invest.dao;

    
    








import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.invest.bean.dto.RspIotCameraAlarmDto;
import com.cateyes.smart.park.invest.bean.po.IotCameraAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 视屏告警事件(SpIotCameraAlarm)Mapper
 *
 * @author CatEyes
 * @since 2023-05-16 14:22:07
 */
@Mapper
public interface IotCameraAlarmMapper extends BaseMapper<IotCameraAlarm> {

    /**
     * 根据id查询视屏告警事件详情(跨服务)
     * @param id 视屏告警事件id
     * @return 视屏告警事件展示对象RspIotCameraAlarmDto
     */
    RspIotCameraAlarmDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询视屏告警事件List
     * @param reqDto 视屏告警事件接收入参DTO
     * @return 视屏告警事件展示对象集合RspIotCameraAlarmDtoList
     */
    List<RspIotCameraAlarmDto> queryByConditions(@Param("reqDto") RspIotCameraAlarmDto reqDto);

    /**
     * 条件查询视屏告警事件Page
     * @param page 分页参数
     * @param reqDto 视屏告警事件接收入参DTO
     * @return 视屏告警事件展示对象集合RspIotCameraAlarmDtoList
     */
    IPage<RspIotCameraAlarmDto> queryByConditions(@Param("page")Page page, @Param("reqDto") RspIotCameraAlarmDto reqDto);
    
}
