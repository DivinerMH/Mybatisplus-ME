package com.cateyes.data.govern.bi.controller;

    
    







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.data.govern.bi.bean.dto.RspBiReportDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 报表Controller
 *
 * @author CatEyes
 * @since 2024-01-16 15:41:42
 */
@RestController
@RequestMapping("/biReport")
@Api(tags = "报表")
public class BiReportController {

	@Autowired
    private IBiReportService biReportService;

    /**
     * 新增
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqBiReportAddDto reqDto) {
        return ApiResult.ok(biReportService.add(reqDto));
    }

    /**
     * 删除
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/del", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult del(@Valid @RequestBody ReqIdDto reqDto) {
        biReportService.del(reqDto);
        return ApiResult.ok();
    }

    /**
     * 修改
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult update(@Valid @RequestBody ReqBiReportUpdateDto reqDto) {
        biReportService.update(reqDto);
        return ApiResult.ok();
    }
    
    /**
     * 详情查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspBiReportDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(biReportService.detail(reqDto));
    }
    
    /**
     * 分页查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspBiReportDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqBiReportQueryDto reqDto) {
        return ApiResult.ok(biReportService.queryPage(reqDto));
    }
}
