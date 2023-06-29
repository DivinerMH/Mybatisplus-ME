package com.cateyes.smart.park.report.controller;

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
 * Description: 智慧大屏-系统-工程项目总览Controller
 *
 * @author CatEyes
 * @since 2023-06-29 10:41:08
 */
@RestController
@RequestMapping("/bsProjectOverview")
@Api(tags = "智慧大屏-系统-工程项目总览")
public class BsProjectOverviewController {

    @Autowired
    private IBsProjectOverviewService bsProjectOverviewService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Validated(SaveValid.class) @RequestBody ReqBsProjectOverviewDto reqDto) {
        return ApiResult.ok(bsProjectOverviewService.add(reqDto));
    }

    /**
     * 删除
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult delete(@PathVariable("id") Integer id) {
        bsProjectOverviewService.delete(id);
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
    public ApiResult update(@Validated(UpdateValid.class) @RequestBody ReqBsProjectOverviewDto reqDto) {
        bsProjectOverviewService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspBsProjectOverviewDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@PathVariable("id") Integer id) {
        return ApiResult.ok(bsProjectOverviewService.detail(id));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspBsProjectOverviewDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqBsProjectOverviewDto reqDto) {
        return ApiResult.ok(bsProjectOverviewService.queryPage(reqDto));
    }
}
