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
 * Description: 巡检点Controller
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:15
 */
@RestController
@RequestMapping("/patrolPoint")
@Api(tags = "巡检点")
public class PatrolPointController {

    @Autowired
    private IPatrolPointService patrolPointService;

    /**
     * 新增
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult savePatrolPoint(@Validated(SaveValid.class) @RequestBody ReqPatrolPointDto reqDto) {
        return ApiResult.ok(patrolPointService.savePatrolPoint(reqDto));
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
    public ApiResult deletePatrolPoint(@PathVariable("id") Integer id) {
        patrolPointService.deletePatrolPoint(id);
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
    public ApiResult updatePatrolPoint(@Validated(UpdateValid.class) @RequestBody ReqPatrolPointDto reqDto) {
        patrolPointService.updatePatrolPoint(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id
     *            主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspPatrolPointDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(patrolPointService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspPatrolPointDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqPatrolPointDto reqDto) {
        return ApiResult.ok(patrolPointService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto
     *            入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspPatrolPointDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqPatrolPointDto reqDto) {
        return ApiResult.ok(patrolPointService.queryPage(reqDto));
    }
}
