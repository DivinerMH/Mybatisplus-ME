package com.cateyes.data.govern.bi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.data.govern.bi.bean.dto.RspBiDatasetFieldDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiDatasetFieldAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiDatasetFieldUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiDatasetFieldQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 数据集-字段管理Controller
 *
 * @author CatEyes
 * @since 2023-12-21 14:40:46
 */
@RestController
@RequestMapping("/biDatasetField")
@Api(tags = "数据集-字段管理")
public class BiDatasetFieldController {

    @Autowired
    private IBiDatasetFieldService biDatasetFieldService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqBiDatasetFieldAddDto reqDto) {
        return ApiResult.ok(biDatasetFieldService.add(reqDto));
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
        biDatasetFieldService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqBiDatasetFieldUpdateDto reqDto) {
        biDatasetFieldService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspBiDatasetFieldDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(biDatasetFieldService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspBiDatasetFieldDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqBiDatasetFieldQueryDto reqDto) {
        return ApiResult.ok(biDatasetFieldService.queryPage(reqDto));
    }
}
