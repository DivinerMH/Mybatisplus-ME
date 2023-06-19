package com.cateyes.smart.park.safe.controller;

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
 * Description: 应急疏散表Controller
 *
 * @author CatEyes
 * @since 2023-06-07 17:27:54
 */
@RestController
@RequestMapping("/emergencyEvacuate")
@Api(tags = "应急疏散表")
public class EmergencyEvacuateController {

    @Autowired
    private IEmergencyEvacuateService emergencyEvacuateService;

    /**
     * 新增
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveEmergencyEvacuate(@Validated(SaveValid.class) @RequestBody ReqEmergencyEvacuateDto reqDto) {
        return ApiResult.ok(emergencyEvacuateService.saveEmergencyEvacuate(reqDto));
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
    public ApiResult deleteEmergencyEvacuate(@PathVariable("id") Integer id) {
        emergencyEvacuateService.deleteEmergencyEvacuate(id);
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
        updateEmergencyEvacuate(@Validated(UpdateValid.class) @RequestBody ReqEmergencyEvacuateDto reqDto) {
        emergencyEvacuateService.updateEmergencyEvacuate(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id
     *            主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspEmergencyEvacuateDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(emergencyEvacuateService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspEmergencyEvacuateDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqEmergencyEvacuateDto reqDto) {
        return ApiResult.ok(emergencyEvacuateService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspEmergencyEvacuateDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqEmergencyEvacuateDto reqDto) {
        return ApiResult.ok(emergencyEvacuateService.queryPage(reqDto));
    }
}
