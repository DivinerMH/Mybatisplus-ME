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
 * Description: 人流管理-人流记录Controller
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:52
 */
@RestController
@RequestMapping("/flowRecord")
@Api(tags = "人流管理-人流记录")
public class FlowRecordController {

    @Autowired
    private IFlowRecordService flowRecordService;

    /**
     * 新增
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveFlowRecord(@Validated(SaveValid.class) @RequestBody ReqFlowRecordDto reqDto) {
        return ApiResult.ok(flowRecordService.saveFlowRecord(reqDto));
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
    public ApiResult deleteFlowRecord(@PathVariable("id") Integer id) {
        flowRecordService.deleteFlowRecord(id);
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
    public ApiResult updateFlowRecord(@Validated(UpdateValid.class) @RequestBody ReqFlowRecordDto reqDto) {
        flowRecordService.updateFlowRecord(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id
     *            主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspFlowRecordDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(flowRecordService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspFlowRecordDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqFlowRecordDto reqDto) {
        return ApiResult.ok(flowRecordService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspFlowRecordDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqFlowRecordDto reqDto) {
        return ApiResult.ok(flowRecordService.queryPage(reqDto));
    }
}
