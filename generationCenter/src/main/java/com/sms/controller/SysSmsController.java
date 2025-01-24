package com.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sms.bean.dto.ReqSysSmsAddDto;
import com.sms.bean.dto.ReqSysSmsQueryDto;
import com.sms.bean.dto.ReqSysSmsUpdateDto;
import com.sms.bean.dto.RspSysSmsDto;
import com.sms.bean.po.SysSms;
import com.sms.service.ISysSmsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: 短信表Controller
 *
 * @author menghuan
 * @since 2025-01-22 09:49:09
 * @Version: V2.0
 */
@Api(tags = "短信表")
@RestController
@RequestMapping("/sysSms")
@Slf4j
public class SysSmsController extends JeecgController<SysSms, ISysSmsService> {

    @Autowired
    private ISysSmsService sysSmsService;

    /**
     * 添加
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "短信表-添加")
    @ApiOperation(value = "添加")
    // @RequiresPermissions("inbound:SYS_SMS:add")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> add(@Valid @RequestBody ReqSysSmsAddDto reqDto) {
        sysSmsService.add(reqDto);
        return Result.OK("添加成功!");
    }

    /**
     * 删除
     * 
     * @param id 主键ID
     * @return Result
     **/
    @AutoLog(value = "短信表-删除")
    @ApiOperation(value = "删除")
    // @RequiresPermissions("inbound:SYS_SMS:delete")
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> delete(@RequestParam("id") String id) {
        sysSmsService.delete(id);
        return Result.OK("删除成功!");
    }

    /**
     * 编辑
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "短信表-编辑")
    @ApiOperation(value = "编辑")
    // @RequiresPermissions("inbound:SYS_SMS:edit")
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result edit(@Valid @RequestBody ReqSysSmsUpdateDto reqDto) {
        sysSmsService.update(reqDto);
        return Result.OK("编辑成功!");
    }

    /**
     * 详情查询
     * 
     * @param id 主键ID
     * @return Result
     **/
    @ApiOperation(value = "详情查询", response = RspSysSmsDto.class)
    // @RequiresPermissions("inbound:SYS_SMS:detail")
    @GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<RspSysSmsDto> detail(@RequestParam("id") String id) {
        return Result.ok(sysSmsService.detail(id));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspSysSmsDto.class)
    // @RequiresPermissions("inbound:SYS_SMS:page")
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<IPage<RspSysSmsDto>> queryPage(@Valid ReqSysSmsQueryDto reqDto) {
        return Result.ok(sysSmsService.queryPage(reqDto));
    }

}
