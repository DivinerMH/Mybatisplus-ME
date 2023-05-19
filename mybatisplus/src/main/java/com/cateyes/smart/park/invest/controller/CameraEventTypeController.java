package com.cateyes.smart.park.invest.controller;

    
    







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
 * @since 2023-05-19 15:20:42
 */
@RestController
@RequestMapping("/cameraEventType")
@Api(tags = "")
public class CameraEventTypeController {

	@Autowired
    private ICameraEventTypeService cameraEventTypeService;

    /**
     * -新增
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "-新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveCameraEventType(@Validated(SaveValid.class) @RequestBody ReqCameraEventTypeDto reqDto) {
        return ApiResult.ok(cameraEventTypeService.saveCameraEventType(reqDto));
    }

    /**
     * -删除
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "-删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteCameraEventType(@PathVariable("id") Integer id) {
        cameraEventTypeService.deleteCameraEventType(id);
        return ApiResult.ok();
    }

    /**
     * -修改
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "-修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult updateCameraEventType(@Validated(UpdateValid.class) @RequestBody ReqCameraEventTypeDto reqDto) {
        cameraEventTypeService.updateCameraEventType(reqDto);
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
        return ApiResult.ok(cameraEventTypeService.queryDetail(id));
    }
    
    /**
     * -条件查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "-条件查询")
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqCameraEventTypeDto reqDto) {
        return ApiResult.ok(cameraEventTypeService.queryList(reqDto));
    }

    /**
     * -分页查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "-分页查询")
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqCameraEventTypeDto reqDto) {
        return ApiResult.ok(cameraEventTypeService.queryPage(reqDto));
    }
}
