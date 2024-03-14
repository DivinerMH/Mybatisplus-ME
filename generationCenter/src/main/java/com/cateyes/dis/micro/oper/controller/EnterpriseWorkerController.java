package com.cateyes.dis.micro.oper.controller;

import com.cateyes.base.dto.ReqIdDto;
import com.cateyes.dis.micro.oper.service.IEnterpriseWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseWorkerDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseWorkerAddDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseWorkerUpdateDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseWorkerQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

/**
 * Description: 企业用工Controller
 *
 * @author CatEyes
 * @since 2024-02-01 19:30:35
 */
@RestController
@RequestMapping("/enterpriseWorker")
@Api(tags = "企业用工")
public class EnterpriseWorkerController {

    @Autowired
    private IEnterpriseWorkerService enterpriseWorkerService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqEnterpriseWorkerAddDto reqDto) {
        return ApiResult.ok(enterpriseWorkerService.add(reqDto));
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
        enterpriseWorkerService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqEnterpriseWorkerUpdateDto reqDto) {
        enterpriseWorkerService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspEnterpriseWorkerDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(enterpriseWorkerService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspEnterpriseWorkerDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqEnterpriseWorkerQueryDto reqDto) {
        return ApiResult.ok(enterpriseWorkerService.queryPage(reqDto));
    }
}
