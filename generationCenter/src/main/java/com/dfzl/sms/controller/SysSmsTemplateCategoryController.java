package com.dfzl.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dfzl.sms.bean.dto.ReqSysSmsTemplateCategoryAddDto;
import com.dfzl.sms.bean.dto.ReqSysSmsTemplateCategoryQueryDto;
import com.dfzl.sms.bean.dto.ReqSysSmsTemplateCategoryUpdateDto;
import com.dfzl.sms.bean.dto.RspSysSmsTemplateCategoryDto;
import com.dfzl.sms.bean.po.SysSmsTemplateCategory;
import com.dfzl.sms.service.ISysSmsTemplateCategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: 短信模板分类Controller
 *
 * @author makejava
 * @since 2025-01-15 15:47:56
 * @Version: V2.0
 */
@Api(tags = "短信模板分类")
@RestController
@RequestMapping("/sysSmsTemplateCategory")
@Slf4j
public class SysSmsTemplateCategoryController
    extends JeecgController<SysSmsTemplateCategory, ISysSmsTemplateCategoryService> {

    @Autowired
    private ISysSmsTemplateCategoryService sysSmsTemplateCategoryService;

    /**
     * 添加
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "短信模板分类-添加")
    @ApiOperation(value = "添加")
    // @RequiresPermissions("inbound:SYS_SMS_TEMPLATE_CATEGORY:add")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> add(@Valid @RequestBody ReqSysSmsTemplateCategoryAddDto reqDto) {
        sysSmsTemplateCategoryService.add(reqDto);
        return Result.OK("添加成功!");
    }

    /**
     * 删除
     * 
     * @param id 主键ID
     * @return Result
     **/
    @AutoLog(value = "短信模板分类-删除")
    @ApiOperation(value = "删除")
    // @RequiresPermissions("inbound:SYS_SMS_TEMPLATE_CATEGORY:delete")
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> delete(@RequestParam("id") String id) {
        sysSmsTemplateCategoryService.delete(id);
        return Result.OK("删除成功!");
    }

    /**
     * 编辑
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "短信模板分类-编辑")
    @ApiOperation(value = "编辑")
    // @RequiresPermissions("inbound:SYS_SMS_TEMPLATE_CATEGORY:edit")
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result edit(@Valid @RequestBody ReqSysSmsTemplateCategoryUpdateDto reqDto) {
        sysSmsTemplateCategoryService.update(reqDto);
        return Result.OK("编辑成功!");
    }

    /**
     * 详情查询
     * 
     * @param id 主键ID
     * @return Result
     **/
    @ApiOperation(value = "详情查询", response = RspSysSmsTemplateCategoryDto.class)
    @GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<RspSysSmsTemplateCategoryDto> detail(@RequestParam("id") String id) {
        return Result.ok(sysSmsTemplateCategoryService.detail(id));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspSysSmsTemplateCategoryDto.class)
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<IPage<RspSysSmsTemplateCategoryDto>> queryPage(@Valid ReqSysSmsTemplateCategoryQueryDto reqDto) {
        return Result.ok(sysSmsTemplateCategoryService.queryPage(reqDto));
    }

}
