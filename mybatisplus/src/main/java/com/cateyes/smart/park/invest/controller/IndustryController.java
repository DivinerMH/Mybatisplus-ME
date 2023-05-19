package com.cateyes.smart.park.invest.controller;

    
    






import com.cateyes.smart.park.invest.bean.dto.ReqIndustryDto;
import com.cateyes.smart.park.invest.service.IIndustryService;
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
 * Description: 产业-产业环节-产业节点信息表Controller
 *
 * @author CatEyes
 * @since 2023-04-20 14:22:56
 */
@RestController
@RequestMapping("/industry")
@Api(tags = "产业-产业环节-产业节点信息表")
public class IndustryController {

	@Autowired
    private IIndustryService industryService;

    /**
     * 产业-产业环节-产业节点信息表-新增
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "产业-产业环节-产业节点信息表-新增")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult add(@Validated(SaveValid.class) @RequestBody ReqIndustryDto reqDto) {
        industryService.add(reqDto);
        return ApiResult.ok();
    }

    /**
     *  产业-产业环节-产业节点信息表-删除
     * @param id 主键id
     * @return ApiResult
     **/
    @ApiOperation(value = "产业-产业环节-产业节点信息表-删除")
    @PostMapping(value = "/delete/{id}")
    public ApiResult delete(@PathVariable("id") Integer id) {
        industryService.delete(id);
        return ApiResult.ok();
    }

    /**
     *  产业-产业环节-产业节点信息表-修改
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "产业-产业环节-产业节点信息表-修改")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult update(@Validated(UpdateValid.class) @RequestBody ReqIndustryDto reqDto) {
        industryService.update(reqDto);
        return ApiResult.ok();
    }

    /**
     *  产业-产业环节-产业节点信息表-分页查询
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "产业-产业环节-产业节点信息表-分页查询")
    @PostMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult queryPage(@Validated({PageValid.class}) @RequestBody ReqIndustryDto reqDto) {
        return ApiResult.ok(industryService.queryPage(reqDto));
    }
}
