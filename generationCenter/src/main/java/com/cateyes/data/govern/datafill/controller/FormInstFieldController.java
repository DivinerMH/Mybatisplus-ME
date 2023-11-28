package com.cateyes.data.govern.datafill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.data.govern.datafill.bean.dto.RspFormInstFieldDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstFieldAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstFieldUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstFieldQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 表单实例数据Controller
 *
 * @author CatEyes
 * @since 2023-11-21 10:16:35
 */
@RestController
@RequestMapping("/formInstField")
@Api(tags = "表单实例数据")
public class FormInstFieldController {

    @Autowired
    private IFormInstFieldService formInstFieldService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqFormInstFieldAddDto reqDto) {
        return ApiResult.ok(formInstFieldService.add(reqDto));
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
        formInstFieldService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqFormInstFieldUpdateDto reqDto) {
        formInstFieldService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspFormInstFieldDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(formInstFieldService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspFormInstFieldDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqFormInstFieldQueryDto reqDto) {
        return ApiResult.ok(formInstFieldService.queryPage(reqDto));
    }
}
