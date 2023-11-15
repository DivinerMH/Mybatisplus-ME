package com.cateyes.smart.park.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.base.api.ApiResult;
import com.cateyes.base.valid.PageValid;
import com.cateyes.base.valid.SaveValid;
import com.cateyes.base.valid.UpdateValid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 企业亩均效益分析-企业得分Controller
 *
 * @author CatEyes
 * @since 2023-07-25 15:55:46
 */
@RestController
@RequestMapping("/enterpriseMuBenefitAnalysis")
@Api(tags = "企业亩均效益分析-企业得分")
public class EnterpriseMuBenefitAnalysisController {

    @Autowired
    private IEnterpriseMuBenefitAnalysisService enterpriseMuBenefitAnalysisService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveEnterpriseMuBenefitAnalysis(
        @Validated(SaveValid.class) @RequestBody ReqEnterpriseMuBenefitAnalysisDto reqDto) {
        return ApiResult.ok(enterpriseMuBenefitAnalysisService.saveEnterpriseMuBenefitAnalysis(reqDto));
    }

    /**
     * 删除
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteEnterpriseMuBenefitAnalysis(@PathVariable("id") Integer id) {
        enterpriseMuBenefitAnalysisService.deleteEnterpriseMuBenefitAnalysis(id);
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
    public ApiResult updateEnterpriseMuBenefitAnalysis(
        @Validated(UpdateValid.class) @RequestBody ReqEnterpriseMuBenefitAnalysisDto reqDto) {
        enterpriseMuBenefitAnalysisService.updateEnterpriseMuBenefitAnalysis(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspEnterpriseMuBenefitAnalysisDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(enterpriseMuBenefitAnalysisService.queryDetail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspEnterpriseMuBenefitAnalysisDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqEnterpriseMuBenefitAnalysisDto reqDto) {
        return ApiResult.ok(enterpriseMuBenefitAnalysisService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspEnterpriseMuBenefitAnalysisDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqEnterpriseMuBenefitAnalysisDto reqDto) {
        return ApiResult.ok(enterpriseMuBenefitAnalysisService.queryPage(reqDto));
    }
}
