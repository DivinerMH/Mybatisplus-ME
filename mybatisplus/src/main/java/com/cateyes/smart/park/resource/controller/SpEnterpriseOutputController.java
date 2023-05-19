package com.cateyes.smart.park.resource.controller;

    
    







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cateyes.smart.park.base.api.ApiResult;
import com.cateyes.smart.park.base.valid.PageValid;
import com.cateyes.smart.park.base.valid.QueryValid;
import com.cateyes.smart.park.base.valid.SaveValid;
import com.cateyes.smart.park.base.valid.UpdateValid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Description: 企业产值Controller
 *
 * @author CatEyes
 * @since 2023-05-19 10:23:19
 */
@RestController
@RequestMapping("/spEnterpriseOutput")
@Api(tags = "企业产值")
public class SpEnterpriseOutputController {

	@Autowired
    private ISpEnterpriseOutputService spEnterpriseOutputService;

    /**
     * 企业产值-新增
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "企业产值-新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult saveSpEnterpriseOutput(@Validated(SaveValid.class) @RequestBody ReqSpEnterpriseOutputDto reqDto) {
        return ApiResult.ok(spEnterpriseOutputService.saveSpEnterpriseOutput(reqDto));
    }

    /**
     * 企业产值-删除
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "企业产值-删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult deleteSpEnterpriseOutput(@PathVariable("id") Integer id) {
        spEnterpriseOutputService.deleteSpEnterpriseOutput(id);
        return ApiResult.ok();
    }

    /**
     * 企业产值-修改
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "企业产值-修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult updateSpEnterpriseOutput(@Validated(UpdateValid.class) @RequestBody ReqSpEnterpriseOutputDto reqDto) {
        spEnterpriseOutputService.updateSpEnterpriseOutput(reqDto);
        return ApiResult.ok();
    }
    
    /**
     * 企业产值-详情查询
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "企业产值-详情查询")
    @PostMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryDetail(@PathVariable("id") Integer id) {
        return ApiResult.ok(spEnterpriseOutputService.queryDetail(id));
    }
    
    /**
     * 企业产值-条件查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "企业产值-条件查询")
    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryList(@RequestBody ReqSpEnterpriseOutputDto reqDto) {
        return ApiResult.ok(spEnterpriseOutputService.queryList(reqDto));
    }

    /**
     * 企业产值-分页查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "企业产值-分页查询")
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqSpEnterpriseOutputDto reqDto) {
        return ApiResult.ok(spEnterpriseOutputService.queryPage(reqDto));
    }
}
