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
 * Description: 视屏告警事件Controller
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:40
 */
@RestController
@RequestMapping("/flowEntranceAlarm")
@Api(tags = "视屏告警事件")
public class FlowEntranceAlarmController {

    @Autowired
    private IFlowEntranceAlarmService flowEntranceAlarmService;

    /**
     * 新增
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveFlowEntranceAlarm(@Validated(SaveValid.class) @RequestBody ReqFlowEntranceAlarmDto reqDto) {
        return ApiResult.ok(flowEntranceAlarmService.saveFlowEntranceAlarm(reqDto));
    }

    /**
     * 删除
     * 
     * @param id
     *            主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteFlowEntranceAlarm(@PathVariable("id") Integer id) {
        flowEntranceAlarmService.deleteFlowEntranceAlarm(id);
        return ApiResult.ok();
    }

    /**
     * 修改
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult
        updateFlowEntranceAlarm(@Validated(UpdateValid.class) @RequestBody ReqFlowEntranceAlarmDto reqDto) {
        flowEntranceAlarmService.updateFlowEntranceAlarm(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id
     *            主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspFlowEntranceAlarmDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(flowEntranceAlarmService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspFlowEntranceAlarmDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqFlowEntranceAlarmDto reqDto) {
        return ApiResult.ok(flowEntranceAlarmService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspFlowEntranceAlarmDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqFlowEntranceAlarmDto reqDto) {
        return ApiResult.ok(flowEntranceAlarmService.queryPage(reqDto));
    }
}
