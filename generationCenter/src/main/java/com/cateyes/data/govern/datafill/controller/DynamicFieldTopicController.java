package com.cateyes.data.govern.datafill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldTopicDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldTopicAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldTopicUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldTopicQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 动态表单字段主题Controller
 *
 * @author CatEyes
 * @since 2023-12-05 09:30:08
 */
@RestController
@RequestMapping("/dynamicFieldTopic")
@Api(tags = "动态表单字段主题")
public class DynamicFieldTopicController {

    @Autowired
    private IDynamicFieldTopicService dynamicFieldTopicService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqDynamicFieldTopicAddDto reqDto) {
        return ApiResult.ok(dynamicFieldTopicService.add(reqDto));
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
        dynamicFieldTopicService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqDynamicFieldTopicUpdateDto reqDto) {
        dynamicFieldTopicService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspDynamicFieldTopicDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(dynamicFieldTopicService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspDynamicFieldTopicDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqDynamicFieldTopicQueryDto reqDto) {
        return ApiResult.ok(dynamicFieldTopicService.queryPage(reqDto));
    }
}
