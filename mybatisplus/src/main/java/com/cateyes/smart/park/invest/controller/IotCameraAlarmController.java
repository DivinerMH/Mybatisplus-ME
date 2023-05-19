package com.cateyes.smart.park.invest.controller;

    
    






import com.cateyes.smart.park.invest.bean.dto.ReqIotCameraAlarmDto;
import com.cateyes.smart.park.invest.service.IIotCameraAlarmService;
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
 * @since 2023-05-16 15:17:37
 */
@RestController
@RequestMapping("/iotCameraAlarm")
@Api(tags = "视屏告警事件")
public class IotCameraAlarmController {

	@Autowired
    private IIotCameraAlarmService iotCameraAlarmService;

    /**
     * 视屏告警事件-新增
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveIotCameraAlarm(@Validated(SaveValid.class) @RequestBody ReqIotCameraAlarmDto reqDto) {
        return ApiResult.ok(iotCameraAlarmService.saveIotCameraAlarm(reqDto));
    }

    /**
     * 视屏告警事件-删除
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteIotCameraAlarm(@PathVariable("id") Integer id) {
        iotCameraAlarmService.deleteIotCameraAlarm(id);
        return ApiResult.ok();
    }

    /**
     * 视屏告警事件-修改
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult updateIotCameraAlarm(@Validated(UpdateValid.class) @RequestBody ReqIotCameraAlarmDto reqDto) {
        iotCameraAlarmService.updateIotCameraAlarm(reqDto);
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
        return ApiResult.ok(iotCameraAlarmService.queryDetail(id));
    }
    
    /**
     * 视屏告警事件-条件查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-条件查询")
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqIotCameraAlarmDto reqDto) {
        return ApiResult.ok(iotCameraAlarmService.queryList(reqDto));
    }

    /**
     * 视屏告警事件-分页查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "视屏告警事件-分页查询")
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqIotCameraAlarmDto reqDto) {
        return ApiResult.ok(iotCameraAlarmService.queryPage(reqDto));
    }
}
