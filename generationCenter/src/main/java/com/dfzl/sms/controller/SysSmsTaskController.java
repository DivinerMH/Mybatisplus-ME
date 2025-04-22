package com.dfzl.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dfzl.sms.bean.dto.ReqSysSmsTaskAddDto;
import com.dfzl.sms.bean.dto.ReqSysSmsTaskQueryDto;
import com.dfzl.sms.bean.dto.ReqSysSmsTaskUpdateDto;
import com.dfzl.sms.bean.dto.RspSysSmsTaskDto;
import com.dfzl.sms.bean.po.SysSmsTask;
import com.dfzl.sms.service.ISysSmsTaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: 短信发送任务表Controller
 *
 * @author makejava
 * @since 2025-01-15 15:46:31
 * @Version: V2.0
 */
@Api(tags = "短信发送任务表")
@RestController
@RequestMapping("/sysSmsTask")
@Slf4j
public class SysSmsTaskController extends JeecgController<SysSmsTask, ISysSmsTaskService> {

    @Autowired
    private ISysSmsTaskService sysSmsTaskService;

    /**
     * 添加
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "短信发送任务表-添加")
    @ApiOperation(value = "添加")
    // @RequiresPermissions("inbound:SYS_SMS_TASK:add")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> add(@Valid @RequestBody ReqSysSmsTaskAddDto reqDto) {
        sysSmsTaskService.add(reqDto);
        return Result.OK("添加成功!");
    }

    /**
     * 删除
     * 
     * @param id 主键ID
     * @return Result
     **/
    @AutoLog(value = "短信发送任务表-删除")
    @ApiOperation(value = "删除")
    // @RequiresPermissions("inbound:SYS_SMS_TASK:delete")
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> delete(@RequestParam("id") String id) {
        sysSmsTaskService.delete(id);
        return Result.OK("删除成功!");
    }

    /**
     * 编辑
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "短信发送任务表-编辑")
    @ApiOperation(value = "编辑")
    // @RequiresPermissions("inbound:SYS_SMS_TASK:edit")
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result edit(@Valid @RequestBody ReqSysSmsTaskUpdateDto reqDto) {
        sysSmsTaskService.update(reqDto);
        return Result.OK("编辑成功!");
    }

    /**
     * 详情查询
     * 
     * @param id 主键ID
     * @return Result
     **/
    @ApiOperation(value = "详情查询", response = RspSysSmsTaskDto.class)
    @GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<RspSysSmsTaskDto> detail(@RequestParam("id") String id) {
        return Result.ok(sysSmsTaskService.detail(id));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspSysSmsTaskDto.class)
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<IPage<RspSysSmsTaskDto>> queryPage(@Valid ReqSysSmsTaskQueryDto reqDto) {
        return Result.ok(sysSmsTaskService.queryPage(reqDto));
    }

}
