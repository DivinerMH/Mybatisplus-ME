package com.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sms.bean.dto.ReqSysSmsTemplateAddDto;
import com.sms.bean.dto.ReqSysSmsTemplateQueryDto;
import com.sms.bean.dto.ReqSysSmsTemplateUpdateDto;
import com.sms.bean.dto.RspSysSmsTemplateDto;
import com.sms.bean.po.SysSmsTemplate;
import com.sms.service.ISysSmsTemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: 短信模版表Controller
 *
 * @author makejava
 * @since 2025-01-15 15:47:05
 * @Version: V2.0
 */
@Api(tags = "短信模版表")
@RestController
@RequestMapping("/sysSmsTemplate")
@Slf4j
public class SysSmsTemplateController extends JeecgController<SysSmsTemplate, ISysSmsTemplateService> {

    @Autowired
    private ISysSmsTemplateService sysSmsTemplateService;

    /**
     * 添加
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "短信模版表-添加")
    @ApiOperation(value = "添加")
    // @RequiresPermissions("inbound:SYS_SMS_TEMPLATE:add")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> add(@Valid @RequestBody ReqSysSmsTemplateAddDto reqDto) {
        sysSmsTemplateService.add(reqDto);
        return Result.OK("添加成功!");
    }

    /**
     * 删除
     * 
     * @param id 主键ID
     * @return Result
     **/
    @AutoLog(value = "短信模版表-删除")
    @ApiOperation(value = "删除")
    // @RequiresPermissions("inbound:SYS_SMS_TEMPLATE:delete")
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> delete(@RequestParam("id") String id) {
        sysSmsTemplateService.delete(id);
        return Result.OK("删除成功!");
    }

    /**
     * 编辑
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "短信模版表-编辑")
    @ApiOperation(value = "编辑")
    // @RequiresPermissions("inbound:SYS_SMS_TEMPLATE:edit")
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result edit(@Valid @RequestBody ReqSysSmsTemplateUpdateDto reqDto) {
        sysSmsTemplateService.update(reqDto);
        return Result.OK("编辑成功!");
    }

    /**
     * 详情查询
     * 
     * @param id 主键ID
     * @return Result
     **/
    @ApiOperation(value = "详情查询", response = RspSysSmsTemplateDto.class)
    @GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<RspSysSmsTemplateDto> detail(@RequestParam("id") String id) {
        return Result.ok(sysSmsTemplateService.detail(id));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspSysSmsTemplateDto.class)
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<IPage<RspSysSmsTemplateDto>> queryPage(@Valid ReqSysSmsTemplateQueryDto reqDto) {
        return Result.ok(sysSmsTemplateService.queryPage(reqDto));
    }

}
