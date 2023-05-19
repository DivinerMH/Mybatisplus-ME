package com.cateyes.smart.park.invest.service;

    
    





import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.invest.bean.dto.ReqCameraAlarmDto;
import com.cateyes.smart.park.invest.bean.dto.RspCameraAlarmDto;
import com.cateyes.smart.park.invest.bean.dto.RspcameraAlarmDto;
import com.cateyes.smart.park.invest.bean.dto.ReqcameraAlarmDto;
import com.cateyes.smart.park.invest.bean.po.cameraAlarm;

import java.util.List;

/**
 * 视屏告警事件(SpIotCameraAlarm)service
 *
 * @author CatEyes
 * @since 2023-05-17 09:59:54
 */

public interface ICameraAlarmService extends IService<CameraAlarm> {

    /**
     * 视屏告警事件-新增
     * @param reqDto 视屏告警事件接收入参DTO
     * @return 主键ID
     */
    int saveCameraAlarm(ReqCameraAlarmDto reqDto);

    /**
     * 视屏告警事件-删除
     * @param id 视屏告警事件id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteCameraAlarm(Integer id);

    /**
     * 视屏告警事件-修改
     * @param reqDto 视屏告警事件接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateCameraAlarm(ReqCameraAlarmDto reqDto);

    /**
     * 视屏告警事件-详情
     * @param id 视屏告警事件id
     * @return RspCameraAlarmDto展示对象
     */
    RspCameraAlarmDto queryDetail(Integer id);

    /**
     * 视屏告警事件-条件查询
     * @param reqDto 视屏告警事件接收入参DTO
     * @return RspCameraAlarmDto展示对象List
     */
    List<RspCameraAlarmDto> queryList(ReqCameraAlarmDto reqDto);

    /**
     * 视屏告警事件-分页查询
     * @param reqDto 视屏告警事件接收入参DTO
     * @return RspCameraAlarmDto展示对象IPage
     */
    PageInfo<RspCameraAlarmDto> queryPage(ReqCameraAlarmDto reqDto);

}
