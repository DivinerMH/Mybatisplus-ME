package com.cateyes.smart.park.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.base.ApiResult;
import com.cateyes.base.valid.PageValid;
import com.cateyes.base.valid.SaveValid;
import com.cateyes.base.valid.UpdateValid;
import com.cateyes.smart.park.report.bean.dto.ReqEnterpriseMuBenefitTargetDto;
import com.cateyes.smart.park.report.bean.dto.RspEnterpriseMuBenefitTargetDto;
import com.cateyes.smart.park.report.service.IEnterpriseMuBenefitTargetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 企业亩均效益指标设置Controller
 *
 * @author CatEyes
 * @since 2023-07-21 15:43:30
 */
@RestController
@RequestMapping("/enterprise/mu-benefit/target")
@Api(tags = "企业亩均效益指标设置")
public class EnterpriseMuBenefitTargetController {

    @Autowired
    private IEnterpriseMuBenefitTargetService enterpriseMuBenefitTargetService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Validated(SaveValid.class) @RequestBody ReqEnterpriseMuBenefitTargetDto reqDto) {
        return ApiResult.ok(enterpriseMuBenefitTargetService.add(reqDto));
    }

    /**
     * 删除
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult delete(@PathVariable("id") Integer id) {
        enterpriseMuBenefitTargetService.delete(id);
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
    public ApiResult update(@Validated(UpdateValid.class) @RequestBody ReqEnterpriseMuBenefitTargetDto reqDto) {
        enterpriseMuBenefitTargetService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspEnterpriseMuBenefitTargetDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@PathVariable("id") Integer id) {
        return ApiResult.ok(enterpriseMuBenefitTargetService.detail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "条件查询", response = RspEnterpriseMuBenefitTargetDto.class)
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqEnterpriseMuBenefitTargetDto reqDto) {
        return ApiResult.ok(enterpriseMuBenefitTargetService.query(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspEnterpriseMuBenefitTargetDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqEnterpriseMuBenefitTargetDto reqDto) {
        return ApiResult.ok(enterpriseMuBenefitTargetService.queryPage(reqDto));
    }
}
