package com.cateyes.data.govern.bi.controller;

import com.base.ApiResult;
import com.base.dto.ReqIdDto;
import com.cateyes.data.govern.bi.service.IBiReportFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.data.govern.bi.bean.dto.RspBiReportFieldDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportFieldAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportFieldUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportFieldQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

/**
 * Description: 报表-字段管理Controller
 *
 * @author CatEyes
 * @since 2024-03-19 14:41:42
 */
@RestController
@RequestMapping("/biReportField")
@Api(tags = "报表-字段管理")
public class BiReportFieldController {

    @Autowired
    private IBiReportFieldService biReportFieldService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqBiReportFieldAddDto reqDto) {
        return ApiResult.ok(biReportFieldService.add(reqDto));
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
        biReportFieldService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqBiReportFieldUpdateDto reqDto) {
        biReportFieldService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspBiReportFieldDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(biReportFieldService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspBiReportFieldDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqBiReportFieldQueryDto reqDto) {
        return ApiResult.ok(biReportFieldService.queryPage(reqDto));
    }
}
