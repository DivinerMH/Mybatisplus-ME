package com.cateyes.iis.micro.rbac.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.ApiResult;
import com.base.dto.ReqIdDto;
import com.cateyes.iis.micro.rbac.bean.dto.ReqSysConfAddDto;
import com.cateyes.iis.micro.rbac.bean.dto.ReqSysConfQueryDto;
import com.cateyes.iis.micro.rbac.bean.dto.ReqSysConfUpdateDto;
import com.cateyes.iis.micro.rbac.bean.dto.RspSysConfDto;
import com.cateyes.iis.micro.rbac.service.ISysConfService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 系统配置表Controller
 *
 * @author CatEyes
 * @since 2023-11-13 13:50:08
 */
@RestController
@RequestMapping("/sysConf")
@Api(tags = "系统配置表")
public class SysConfController {

    @Autowired
    private ISysConfService sysConfService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqSysConfAddDto reqDto) {
        return ApiResult.ok(sysConfService.add(reqDto));
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
        sysConfService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqSysConfUpdateDto reqDto) {
        sysConfService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspSysConfDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(sysConfService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspSysConfDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqSysConfQueryDto reqDto) {
        return ApiResult.ok(sysConfService.queryPage(reqDto));
    }
}
