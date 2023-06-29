package com.cateyes.smart.park.iot.controller;

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
 * Description: 粉尘监测仪告警Controller
 *
 * @author CatEyes
 * @since 2023-06-25 11:13:06
 */
@RestController
@RequestMapping("/monitorDustAlarm")
@Api(tags = "粉尘监测仪告警")
public class MonitorDustAlarmController {

    @Autowired
    private IMonitorDustAlarmService monitorDustAlarmService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveMonitorDustAlarm(@Validated(SaveValid.class) @RequestBody ReqMonitorDustAlarmDto reqDto) {
        return ApiResult.ok(monitorDustAlarmService.saveMonitorDustAlarm(reqDto));
    }

    /**
     * 删除
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteMonitorDustAlarm(@PathVariable("id") Integer id) {
        monitorDustAlarmService.deleteMonitorDustAlarm(id);
        return ApiResult.ok();
    }

    /**
     * 修改
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult updateMonitorDustAlarm(@Validated(UpdateValid.class) @RequestBody ReqMonitorDustAlarmDto reqDto) {
        monitorDustAlarmService.updateMonitorDustAlarm(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspMonitorDustAlarmDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(monitorDustAlarmService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspMonitorDustAlarmDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqMonitorDustAlarmDto reqDto) {
        return ApiResult.ok(monitorDustAlarmService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspMonitorDustAlarmDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqMonitorDustAlarmDto reqDto) {
        return ApiResult.ok(monitorDustAlarmService.queryPage(reqDto));
    }
}
