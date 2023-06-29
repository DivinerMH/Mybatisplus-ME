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
 * Description: 灯杆告警Controller
 *
 * @author CatEyes
 * @since 2023-06-25 14:28:49
 */
@RestController
@RequestMapping("/lightPoleAlarm")
@Api(tags = "灯杆告警")
public class LightPoleAlarmController {

    @Autowired
    private ILightPoleAlarmService lightPoleAlarmService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveLightPoleAlarm(@Validated(SaveValid.class) @RequestBody ReqLightPoleAlarmDto reqDto) {
        return ApiResult.ok(lightPoleAlarmService.saveLightPoleAlarm(reqDto));
    }

    /**
     * 删除
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteLightPoleAlarm(@PathVariable("id") Integer id) {
        lightPoleAlarmService.deleteLightPoleAlarm(id);
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
    public ApiResult updateLightPoleAlarm(@Validated(UpdateValid.class) @RequestBody ReqLightPoleAlarmDto reqDto) {
        lightPoleAlarmService.updateLightPoleAlarm(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspLightPoleAlarmDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(lightPoleAlarmService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspLightPoleAlarmDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqLightPoleAlarmDto reqDto) {
        return ApiResult.ok(lightPoleAlarmService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspLightPoleAlarmDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqLightPoleAlarmDto reqDto) {
        return ApiResult.ok(lightPoleAlarmService.queryPage(reqDto));
    }
}
