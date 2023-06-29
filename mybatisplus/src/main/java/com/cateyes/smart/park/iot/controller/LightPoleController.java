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
 * Description: 灯杆Controller
 *
 * @author CatEyes
 * @since 2023-06-25 14:28:36
 */
@RestController
@RequestMapping("/lightPole")
@Api(tags = "灯杆")
public class LightPoleController {

    @Autowired
    private ILightPoleService lightPoleService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveLightPole(@Validated(SaveValid.class) @RequestBody ReqLightPoleDto reqDto) {
        return ApiResult.ok(lightPoleService.saveLightPole(reqDto));
    }

    /**
     * 删除
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteLightPole(@PathVariable("id") Integer id) {
        lightPoleService.deleteLightPole(id);
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
    public ApiResult updateLightPole(@Validated(UpdateValid.class) @RequestBody ReqLightPoleDto reqDto) {
        lightPoleService.updateLightPole(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspLightPoleDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(lightPoleService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspLightPoleDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqLightPoleDto reqDto) {
        return ApiResult.ok(lightPoleService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspLightPoleDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqLightPoleDto reqDto) {
        return ApiResult.ok(lightPoleService.queryPage(reqDto));
    }
}
