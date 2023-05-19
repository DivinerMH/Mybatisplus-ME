package com.cateyes.smart.park.controller;

    
    







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
 * Description: Controller
 *
 * @author CatEyes
 * @since 2023-05-19 15:32:55
 */
@RestController
@RequestMapping("/deviceType")
@Api(tags = "")
public class DeviceTypeController {

	@Autowired
    private IDeviceTypeService deviceTypeService;

    /**
     * -新增
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "-新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveDeviceType(@Validated(SaveValid.class) @RequestBody ReqDeviceTypeDto reqDto) {
        return ApiResult.ok(deviceTypeService.saveDeviceType(reqDto));
    }

    /**
     * -删除
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "-删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteDeviceType(@PathVariable("id") Integer id) {
        deviceTypeService.deleteDeviceType(id);
        return ApiResult.ok();
    }

    /**
     * -修改
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "-修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult updateDeviceType(@Validated(UpdateValid.class) @RequestBody ReqDeviceTypeDto reqDto) {
        deviceTypeService.updateDeviceType(reqDto);
        return ApiResult.ok();
    }
    
    /**
     * -详情查询
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "-详情查询")
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(deviceTypeService.queryDetail(id));
    }
    
    /**
     * -条件查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "-条件查询")
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqDeviceTypeDto reqDto) {
        return ApiResult.ok(deviceTypeService.queryList(reqDto));
    }

    /**
     * -分页查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "-分页查询")
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqDeviceTypeDto reqDto) {
        return ApiResult.ok(deviceTypeService.queryPage(reqDto));
    }
}
