package com.cateyes.data.govern.datafill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicModelDto;
import com.cateyes.smart.park.base.api.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 动态表单模型Controller
 *
 * @author CatEyes
 * @since 2023-11-20 13:55:44
 */
@RestController
@RequestMapping("/dynamicModel")
@Api(tags = "动态表单模型")
public class DynamicModelController {

    @Autowired
    private IDynamicModelService dynamicModelService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqDynamicModelAddDto reqDto) {
        return ApiResult.ok(dynamicModelService.add(reqDto));
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
        dynamicModelService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqDynamicModelUpdateDto reqDto) {
        dynamicModelService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspDynamicModelDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(dynamicModelService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspDynamicModelDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqDynamicModelQueryDto reqDto) {
        return ApiResult.ok(dynamicModelService.queryPage(reqDto));
    }
}
