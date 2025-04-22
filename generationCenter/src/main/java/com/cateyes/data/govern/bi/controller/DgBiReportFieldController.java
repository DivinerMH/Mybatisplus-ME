package com.cateyes.data.govern.bi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cateyes.data.govern.bi.bean.dto.ReqDgBiReportFieldAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqDgBiReportFieldQueryDto;
import com.cateyes.data.govern.bi.bean.dto.ReqDgBiReportFieldUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.RspDgBiReportFieldDto;
import com.cateyes.smart.park.base.api.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 报表-字段管理Controller
 *
 * @author CatEyes
 * @since 2024-03-19 14:40:06
 */
@RestController
@RequestMapping("/dgBiReportField")
@Api(tags = "报表-字段管理")
public class DgBiReportFieldController {

    @Autowired
    private IDgBiReportFieldService dgBiReportFieldService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqDgBiReportFieldAddDto reqDto) {
        return ApiResult.ok(dgBiReportFieldService.add(reqDto));
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
        dgBiReportFieldService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqDgBiReportFieldUpdateDto reqDto) {
        dgBiReportFieldService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspDgBiReportFieldDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(dgBiReportFieldService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspDgBiReportFieldDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqDgBiReportFieldQueryDto reqDto) {
        return ApiResult.ok(dgBiReportFieldService.queryPage(reqDto));
    }
}
