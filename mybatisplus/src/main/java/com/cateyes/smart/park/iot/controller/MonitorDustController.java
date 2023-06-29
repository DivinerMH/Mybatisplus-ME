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
 * Description: 粉尘监测仪Controller
 *
 * @author CatEyes
 * @since 2023-06-21 18:12:29
 */
@RestController
@RequestMapping("/monitorDust")
@Api(tags = "粉尘监测仪")
public class MonitorDustController {

    @Autowired
    private IMonitorDustService monitorDustService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveMonitorDust(@Validated(SaveValid.class) @RequestBody ReqMonitorDustDto reqDto) {
        return ApiResult.ok(monitorDustService.saveMonitorDust(reqDto));
    }

    /**
     * 删除
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteMonitorDust(@PathVariable("id") Integer id) {
        monitorDustService.deleteMonitorDust(id);
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
    public ApiResult updateMonitorDust(@Validated(UpdateValid.class) @RequestBody ReqMonitorDustDto reqDto) {
        monitorDustService.updateMonitorDust(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspMonitorDustDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(monitorDustService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspMonitorDustDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqMonitorDustDto reqDto) {
        return ApiResult.ok(monitorDustService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspMonitorDustDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqMonitorDustDto reqDto) {
        return ApiResult.ok(monitorDustService.queryPage(reqDto));
    }
}
