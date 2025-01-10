package com.cateyes.smart.park.invest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.base.ApiResult;
import com.base.valid.PageValid;
import com.base.valid.SaveValid;
import com.base.valid.UpdateValid;
import com.cateyes.smart.park.invest.bean.dto.ReqIndustryWeakDto;
import com.cateyes.smart.park.invest.bean.dto.RspIndustryWeakDto;
import com.cateyes.smart.park.invest.service.IIndustryWeakService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 产业链节点评价指标设置Controller
 *
 * @author CatEyes
 * @since 2023-07-17 11:00:38
 */
@RestController
@RequestMapping("/industryWeak")
@Api(tags = "产业链节点评价指标设置")
public class IndustryWeakController {

    @Autowired
    private IIndustryWeakService industryWeakService;

    /**
     * 新增
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Validated(SaveValid.class) @RequestBody ReqIndustryWeakDto reqDto) {
        return ApiResult.ok(industryWeakService.add(reqDto));
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
        industryWeakService.delete(id);
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
    public ApiResult update(@Validated(UpdateValid.class) @RequestBody ReqIndustryWeakDto reqDto) {
        industryWeakService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     * 详情查询
     * 
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "详情查询", response = RspIndustryWeakDto.class)
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult detail(@PathVariable("id") Integer id) {
        return ApiResult.ok(industryWeakService.detail(id));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspIndustryWeakDto.class)
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqIndustryWeakDto reqDto) {
        return ApiResult.ok(industryWeakService.queryPage(reqDto));
    }
}
