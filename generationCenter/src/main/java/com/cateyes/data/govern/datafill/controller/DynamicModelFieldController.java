package com.cateyes.data.govern.datafill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.data.govern.datafill.bean.dto.RspDynamicModelFieldDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelFieldAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelFieldUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelFieldQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 动态表单字段Controller
 *
 * @author CatEyes
 * @since 2023-11-20 13:56:08
 */
@RestController
@RequestMapping("/dynamicModelField")
@Api(tags = "动态表单字段")
public class DynamicModelFieldController {

    @Autowired
    private IDynamicModelFieldService dynamicModelFieldService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqDynamicModelFieldAddDto reqDto) {
        return ApiResult.ok(dynamicModelFieldService.add(reqDto));
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
        dynamicModelFieldService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqDynamicModelFieldUpdateDto reqDto) {
        dynamicModelFieldService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspDynamicModelFieldDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(dynamicModelFieldService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspDynamicModelFieldDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqDynamicModelFieldQueryDto reqDto) {
        return ApiResult.ok(dynamicModelFieldService.queryPage(reqDto));
    }
}
