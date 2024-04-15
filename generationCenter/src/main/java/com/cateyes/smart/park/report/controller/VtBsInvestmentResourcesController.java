package com.cateyes.smart.park.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentResourcesDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentResourcesAddDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentResourcesUpdateDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentResourcesQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 智慧大屏-手工-招商资源Controller
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:48
 */
@RestController
@RequestMapping("/vtBsInvestmentResources")
@Api(tags = "智慧大屏-手工-招商资源")
public class VtBsInvestmentResourcesController {

    @Autowired
    private IVtBsInvestmentResourcesService vtBsInvestmentResourcesService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqVtBsInvestmentResourcesAddDto reqDto) {
        return ApiResult.ok(vtBsInvestmentResourcesService.add(reqDto));
    }

    /**
     * 删除
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/del", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult del(@Valid @RequestBody ReqIdDto reqDto) {
        vtBsInvestmentResourcesService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqVtBsInvestmentResourcesUpdateDto reqDto) {
        vtBsInvestmentResourcesService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspVtBsInvestmentResourcesDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(vtBsInvestmentResourcesService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspVtBsInvestmentResourcesDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqVtBsInvestmentResourcesQueryDto reqDto) {
        return ApiResult.ok(vtBsInvestmentResourcesService.queryPage(reqDto));
    }
}
