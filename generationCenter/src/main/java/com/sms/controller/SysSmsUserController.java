package com.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sms.bean.dto.ReqSysSmsUserAddDto;
import com.sms.bean.dto.ReqSysSmsUserQueryDto;
import com.sms.bean.dto.ReqSysSmsUserUpdateDto;
import com.sms.bean.dto.RspSysSmsUserDto;
import com.sms.bean.po.SysSmsUser;
import com.sms.service.ISysSmsUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: 短信发送用户表Controller
 *
 * @author makejava
 * @since 2025-01-15 15:48:28
 * @Version: V2.0
 */
@Api(tags = "短信发送用户表")
@RestController
@RequestMapping("/sysSmsUser")
@Slf4j
public class SysSmsUserController extends JeecgController<SysSmsUser, ISysSmsUserService> {

    @Autowired
    private ISysSmsUserService sysSmsUserService;

    /**
     * 添加
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "短信发送用户表-添加")
    @ApiOperation(value = "添加")
    // @RequiresPermissions("inbound:SYS_SMS_USER:add")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> add(@Valid @RequestBody ReqSysSmsUserAddDto reqDto) {
        sysSmsUserService.add(reqDto);
        return Result.OK("添加成功!");
    }

    /**
     * 删除
     * 
     * @param id 主键ID
     * @return Result
     **/
    @AutoLog(value = "短信发送用户表-删除")
    @ApiOperation(value = "删除")
    // @RequiresPermissions("inbound:SYS_SMS_USER:delete")
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> delete(@RequestParam("id") String id) {
        sysSmsUserService.delete(id);
        return Result.OK("删除成功!");
    }

    /**
     * 编辑
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "短信发送用户表-编辑")
    @ApiOperation(value = "编辑")
    // @RequiresPermissions("inbound:SYS_SMS_USER:edit")
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result edit(@Valid @RequestBody ReqSysSmsUserUpdateDto reqDto) {
        sysSmsUserService.update(reqDto);
        return Result.OK("编辑成功!");
    }

    /**
     * 详情查询
     * 
     * @param id 主键ID
     * @return Result
     **/
    @ApiOperation(value = "详情查询", response = RspSysSmsUserDto.class)
    @GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<RspSysSmsUserDto> detail(@RequestParam("id") String id) {
        return Result.ok(sysSmsUserService.detail(id));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspSysSmsUserDto.class)
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<IPage<RspSysSmsUserDto>> queryPage(@Valid ReqSysSmsUserQueryDto reqDto) {
        return Result.ok(sysSmsUserService.queryPage(reqDto));
    }

}
