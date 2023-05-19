package com.cateyes.smart.park.invest.controller;

    
    






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
 * Description: 企业库表Controller
 *
 * @author CatEyes
 * @since 2023-05-08 10:40:20
 */
@RestController
@RequestMapping("/company")
@Api(tags = "企业库表")
public class CompanyController {

	@Autowired
    private ICompanyService companyService;

    /**
     * 企业库表-新增
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "企业库表-新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Validated(SaveValid.class) @RequestBody ReqCompanyDto reqDto) {
        companyService.add(reqDto);
        return ApiResult.ok();
    }

    /**
     *  企业库表-删除
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "企业库表-删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult delete(@PathVariable("id") Integer id) {
        companyService.delete(id);
        return ApiResult.ok();
    }

    /**
     *  企业库表-修改
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "企业库表-修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult update(@Validated(UpdateValid.class) @RequestBody ReqCompanyDto reqDto) {
        companyService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     *  企业库表-分页查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "企业库表-分页查询")
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqCompanyDto reqDto) {
        return ApiResult.ok(companyService.queryPage(reqDto));
    }
}
