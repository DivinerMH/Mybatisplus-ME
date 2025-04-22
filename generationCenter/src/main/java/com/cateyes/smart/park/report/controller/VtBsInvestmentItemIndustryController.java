package com.cateyes.smart.park.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cateyes.smart.park.base.api.ApiResult;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemIndustryAddDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemIndustryQueryDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemIndustryUpdateDto;
import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentItemIndustryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 智慧大屏-手工-招商项目-产业项目分布Controller
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:40
 */
@RestController
@RequestMapping("/vtBsInvestmentItemIndustry")
@Api(tags = "智慧大屏-手工-招商项目-产业项目分布")
public class VtBsInvestmentItemIndustryController {

    @Autowired
    private IVtBsInvestmentItemIndustryService vtBsInvestmentItemIndustryService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqVtBsInvestmentItemIndustryAddDto reqDto) {
        return ApiResult.ok(vtBsInvestmentItemIndustryService.add(reqDto));
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
        vtBsInvestmentItemIndustryService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqVtBsInvestmentItemIndustryUpdateDto reqDto) {
        vtBsInvestmentItemIndustryService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspVtBsInvestmentItemIndustryDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(vtBsInvestmentItemIndustryService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspVtBsInvestmentItemIndustryDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqVtBsInvestmentItemIndustryQueryDto reqDto) {
        return ApiResult.ok(vtBsInvestmentItemIndustryService.queryPage(reqDto));
    }
}
