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
 * Description: 合同模板表Controller
 *
 * @author CatEyes
 * @since 2023-05-08 10:04:27
 */
@RestController
@RequestMapping("/contractTemplate")
@Api(tags = "合同模板表")
public class ContractTemplateController {

	@Autowired
    private IContractTemplateService contractTemplateService;

    /**
     * 合同模板表-新增
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "合同模板表-新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Validated(SaveValid.class) @RequestBody ReqContractTemplateDto reqDto) {
        contractTemplateService.add(reqDto);
        return ApiResult.ok();
    }

    /**
     *  合同模板表-删除
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "合同模板表-删除")
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult delete(@PathVariable("id") Integer id) {
        contractTemplateService.delete(id);
        return ApiResult.ok();
    }

    /**
     *  合同模板表-修改
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "合同模板表-修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult update(@Validated(UpdateValid.class) @RequestBody ReqContractTemplateDto reqDto) {
        contractTemplateService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     *  合同模板表-分页查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "合同模板表-分页查询")
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqContractTemplateDto reqDto) {
        return ApiResult.ok(contractTemplateService.queryPage(reqDto));
    }
}
