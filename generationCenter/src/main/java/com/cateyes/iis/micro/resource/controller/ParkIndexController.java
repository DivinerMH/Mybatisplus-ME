package com.cateyes.iis.micro.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.base.ApiResult;
import com.base.valid.PageValid;
import com.base.valid.SaveValid;
import com.base.valid.UpdateValid;
import com.cateyes.iis.micro.resource.bean.dto.ReqParkIndexDto;
import com.cateyes.iis.micro.resource.service.IParkIndexService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: Controller
 *
 * @author CatEyes
 * @since 2023-10-17 11:11:54
 */
@RestController
@RequestMapping("/parkIndex")
@Api(tags = "")
public class ParkIndexController {

    @Autowired
    private IParkIndexService parkIndexService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveParkIndex(@Validated(SaveValid.class) @RequestBody ReqParkIndexDto reqDto) {
        return ApiResult.ok(parkIndexService.saveParkIndex(reqDto));
    }

    /**
     * 删除
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteParkIndex(@PathVariable("id") Integer id) {
        parkIndexService.deleteParkIndex(id);
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
    public ApiResult updateParkIndex(@Validated(UpdateValid.class) @RequestBody ReqParkIndexDto reqDto) {
        parkIndexService.updateParkIndex(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspParkIndexDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(parkIndexService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspParkIndexDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqParkIndexDto reqDto) {
        return ApiResult.ok(parkIndexService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspParkIndexDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqParkIndexDto reqDto) {
        return ApiResult.ok(parkIndexService.queryPage(reqDto));
    }
}
