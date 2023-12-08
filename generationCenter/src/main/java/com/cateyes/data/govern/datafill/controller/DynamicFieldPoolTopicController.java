package com.cateyes.data.govern.datafill.controller;

    
    







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldPoolTopicDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolTopicAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolTopicUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolTopicQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 动态表单字段池主题关联Controller
 *
 * @author CatEyes
 * @since 2023-12-04 19:36:11
 */
@RestController
@RequestMapping("/dynamicFieldPoolTopic")
@Api(tags = "动态表单字段池主题关联")
public class DynamicFieldPoolTopicController {

	@Autowired
    private IDynamicFieldPoolTopicService dynamicFieldPoolTopicService;

    /**
     * 新增
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqDynamicFieldPoolTopicAddDto reqDto) {
        return ApiResult.ok(dynamicFieldPoolTopicService.add(reqDto));
    }

    /**
     * 删除
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/del", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult del(@Valid @RequestBody ReqIdDto reqDto) {
        dynamicFieldPoolTopicService.del(reqDto);
        return ApiResult.ok();
    }

    /**
     * 修改
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult update(@Valid @RequestBody ReqDynamicFieldPoolTopicUpdateDto reqDto) {
        dynamicFieldPoolTopicService.update(reqDto);
        return ApiResult.ok();
    }
    
    /**
     * 详情查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspDynamicFieldPoolTopicDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(dynamicFieldPoolTopicService.detail(reqDto));
    }
    
    /**
     * 分页查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspDynamicFieldPoolTopicDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqDynamicFieldPoolTopicQueryDto reqDto) {
        return ApiResult.ok(dynamicFieldPoolTopicService.queryPage(reqDto));
    }
}
