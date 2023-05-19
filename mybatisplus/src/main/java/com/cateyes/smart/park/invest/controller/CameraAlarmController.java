package com.cateyes.smart.park.invest.controller;

    
    







import com.cateyes.smart.park.invest.bean.dto.ReqCameraAlarmDto;
import com.cateyes.smart.park.invest.service.ICameraAlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;
import com.cateyes.smart.park.base.valid.PageValid;
import com.cateyes.smart.park.base.valid.QueryValid;
import com.cateyes.smart.park.base.valid.SaveValid;
import com.cateyes.smart.park.base.valid.UpdateValid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 视屏告警事件Controller
 *
 * @author CatEyes
 * @since 2023-05-17 09:59:54
 */
@RestController
@RequestMapping("/cameraAlarm")
@Api(tags = "视屏告警事件")
public class CameraAlarmController {

	@Autowired
    private ICameraAlarmService cameraAlarmService;

    /**
     * 视屏告警事件-新增
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveCameraAlarm(@Validated(SaveValid.class) @RequestBody ReqCameraAlarmDto reqDto) {
        return ApiResult.ok(cameraAlarmService.saveCameraAlarm(reqDto));
    }

    /**
     * 视屏告警事件-删除
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteCameraAlarm(@PathVariable("id") Integer id) {
        cameraAlarmService.deleteCameraAlarm(id);
        return ApiResult.ok();
    }

    /**
     * 视屏告警事件-修改
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult updateCameraAlarm(@Validated(UpdateValid.class) @RequestBody ReqCameraAlarmDto reqDto) {
        cameraAlarmService.updateCameraAlarm(reqDto);
        return ApiResult.ok();
    }
    
    /**
     * 视屏告警事件-详情查询
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-详情查询")
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(cameraAlarmService.queryDetail(id));
    }
    
    /**
     * 视屏告警事件-条件查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-条件查询")
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqCameraAlarmDto reqDto) {
        return ApiResult.ok(cameraAlarmService.queryList(reqDto));
    }

    /**
     * 视屏告警事件-分页查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-分页查询")
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqCameraAlarmDto reqDto) {
        return ApiResult.ok(cameraAlarmService.queryPage(reqDto));
    }
}
