package com.cateyes.dis.micro.oper.controller;

import com.base.dto.ReqIdDto;
import com.cateyes.dis.micro.oper.service.IEnterpriseTechAchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;

import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseTechAchieveDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseTechAchieveAddDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseTechAchieveUpdateDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseTechAchieveQueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

/**
 * Description: 企业科技成果Controller
 *
 * @author CatEyes
 * @since 2024-02-01 19:22:46
 */
@RestController
@RequestMapping("/enterpriseTechAchieve")
@Api(tags = "企业科技成果")
public class EnterpriseTechAchieveController {

    @Autowired
    private IEnterpriseTechAchieveService enterpriseTechAchieveService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqEnterpriseTechAchieveAddDto reqDto) {
        return ApiResult.ok(enterpriseTechAchieveService.add(reqDto));
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
        enterpriseTechAchieveService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqEnterpriseTechAchieveUpdateDto reqDto) {
        enterpriseTechAchieveService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspEnterpriseTechAchieveDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(enterpriseTechAchieveService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspEnterpriseTechAchieveDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqEnterpriseTechAchieveQueryDto reqDto) {
        return ApiResult.ok(enterpriseTechAchieveService.queryPage(reqDto));
    }
}
