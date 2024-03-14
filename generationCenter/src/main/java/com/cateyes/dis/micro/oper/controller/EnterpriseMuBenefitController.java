package com.cateyes.dis.micro.oper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseMuBenefitDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseMuBenefitAddDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseMuBenefitUpdateDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseMuBenefitQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 企业亩均效益Controller
 *
 * @author CatEyes
 * @since 2024-02-01 18:31:34
 */
@RestController
@RequestMapping("/enterpriseMuBenefit")
@Api(tags = "企业亩均效益")
public class EnterpriseMuBenefitController {

    @Autowired
    private IEnterpriseMuBenefitService enterpriseMuBenefitService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqEnterpriseMuBenefitAddDto reqDto) {
        return ApiResult.ok(enterpriseMuBenefitService.add(reqDto));
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
        enterpriseMuBenefitService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqEnterpriseMuBenefitUpdateDto reqDto) {
        enterpriseMuBenefitService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspEnterpriseMuBenefitDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(enterpriseMuBenefitService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspEnterpriseMuBenefitDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqEnterpriseMuBenefitQueryDto reqDto) {
        return ApiResult.ok(enterpriseMuBenefitService.queryPage(reqDto));
    }
}
