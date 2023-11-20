package com.cateyes.data.govern.datafill.controller;

import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldPoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolAddDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 动态表单字段池Controller
 *
 * @author CatEyes
 * @since 2023-11-20 10:50:50
 */
@RestController
@RequestMapping("/dynamicFieldPool")
@Api(tags = "动态表单字段池")
public class DynamicFieldPoolController {

    @Autowired
    private IDynamicFieldPoolService dynamicFieldPoolService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqDynamicFieldPoolAddDto reqDto) {
        return ApiResult.ok(dynamicFieldPoolService.add(reqDto));
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
        dynamicFieldPoolService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqDynamicFieldPoolUpdateDto reqDto) {
        dynamicFieldPoolService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspDynamicFieldPoolDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(dynamicFieldPoolService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspDynamicFieldPoolDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqDynamicFieldPoolQueryDto reqDto) {
        return ApiResult.ok(dynamicFieldPoolService.queryPage(reqDto));
    }
}
