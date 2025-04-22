package com.cateyes.smart.park.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cateyes.smart.park.base.api.ApiResult;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemAddDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemQueryDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemUpdateDto;
import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentItemDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 智慧大屏-手工-招商项目Controller
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:21
 */
@RestController
@RequestMapping("/vtBsInvestmentItem")
@Api(tags = "智慧大屏-手工-招商项目")
public class VtBsInvestmentItemController {

    @Autowired
    private IVtBsInvestmentItemService vtBsInvestmentItemService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Valid @RequestBody ReqVtBsInvestmentItemAddDto reqDto) {
        return ApiResult.ok(vtBsInvestmentItemService.add(reqDto));
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
        vtBsInvestmentItemService.del(reqDto);
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
    public ApiResult update(@Valid @RequestBody ReqVtBsInvestmentItemUpdateDto reqDto) {
        vtBsInvestmentItemService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspVtBsInvestmentItemDto.class)
    @PostMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@Valid @RequestBody ReqIdDto reqDto) {
        return ApiResult.ok(vtBsInvestmentItemService.detail(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspVtBsInvestmentItemDto.class)
    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Valid @RequestBody ReqVtBsInvestmentItemQueryDto reqDto) {
        return ApiResult.ok(vtBsInvestmentItemService.queryPage(reqDto));
    }
}
