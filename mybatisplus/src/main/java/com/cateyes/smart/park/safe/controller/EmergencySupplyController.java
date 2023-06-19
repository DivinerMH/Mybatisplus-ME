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
 * Description: 应急物资Controller
 *
 * @author CatEyes
 * @since 2023-06-05 11:51:27
 */
@RestController
@RequestMapping("/emergencySupply")
@Api(tags = "应急物资")
public class EmergencySupplyController {

    @Autowired
    private IEmergencySupplyService emergencySupplyService;

    /**
     * 新增
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveEmergencySupply(@Validated(SaveValid.class) @RequestBody ReqEmergencySupplyDto reqDto) {
        return ApiResult.ok(emergencySupplyService.saveEmergencySupply(reqDto));
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
    public ApiResult deleteEmergencySupply(@PathVariable("id") Integer id) {
        emergencySupplyService.deleteEmergencySupply(id);
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
    public ApiResult updateEmergencySupply(@Validated(UpdateValid.class) @RequestBody ReqEmergencySupplyDto reqDto) {
        emergencySupplyService.updateEmergencySupply(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id
     *            主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspEmergencySupplyDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(emergencySupplyService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspEmergencySupplyDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqEmergencySupplyDto reqDto) {
        return ApiResult.ok(emergencySupplyService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspEmergencySupplyDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqEmergencySupplyDto reqDto) {
        return ApiResult.ok(emergencySupplyService.queryPage(reqDto));
    }
}
