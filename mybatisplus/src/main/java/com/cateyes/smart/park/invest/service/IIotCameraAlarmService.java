package com.cateyes.smart.park.invest.service;

    
    





import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.invest.bean.dto.ReqIotCameraAlarmDto;
import com.cateyes.smart.park.invest.bean.dto.RspDto;
import com.cateyes.smart.park.invest.bean.dto.ReqDto;
import com.cateyes.smart.park.invest.bean.dto.RspIotCameraAlarmDto;
import com.cateyes.smart.park.invest.bean.po.;import java.util.List;

/**
 * 视屏告警事件(SpIotCameraAlarm)service
 *
 * @author CatEyes
 * @since 2023-05-16 14:31:37
 */

public interface IIotCameraAlarmService extends IService<IotCameraAlarm> {

    /**
     * 视屏告警事件-新增
     * @param reqDto 视屏告警事件接收入参DTO
     * @return 主键ID
     */
    int saveIotCameraAlarm(ReqIotCameraAlarmDto reqDto);

    /**
     * 视屏告警事件-删除
     * @param id 视屏告警事件id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteIotCameraAlarm(Integer id);

    /**
     * 视屏告警事件-修改
     * @param reqDto 视屏告警事件接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateIotCameraAlarm(ReqIotCameraAlarmDto reqDto);

    /**
     * 视屏告警事件-详情
     * @param id 视屏告警事件id
     * @return RspIotCameraAlarmDto展示对象
     */
    RspIotCameraAlarmDto queryDetail(Integer id);

    /**
     * 视屏告警事件-条件查询
     * @param reqDto 视屏告警事件接收入参DTO
     * @return RspIotCameraAlarmDto展示对象List
     */
    List<RspIotCameraAlarmDto> queryList(ReqIotCameraAlarmDto reqDto);

    /**
     * 视屏告警事件-分页查询
     * @param reqDto 视屏告警事件接收入参DTO
     * @return RspIotCameraAlarmDto展示对象IPage
     */
    PageInfo<RspIotCameraAlarmDto> queryPage(ReqIotCameraAlarmDto reqDto);

}
