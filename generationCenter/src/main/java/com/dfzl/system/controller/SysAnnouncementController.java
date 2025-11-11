package com.dfzl.system.controller;

import java.util.List;

import javax.validation.Valid;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dfzl.system.bean.dto.ReqSysAnnouncementAddDto;
import com.dfzl.system.bean.dto.ReqSysAnnouncementQueryDto;
import com.dfzl.system.bean.dto.ReqSysAnnouncementUpdateDto;
import com.dfzl.system.bean.dto.RspSysAnnouncementDto;
import com.dfzl.system.bean.po.SysAnnouncement;
import com.dfzl.system.service.ISysAnnouncementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: 系统通告表Controller
 *
 * @author menghuan
 * @since 2025-09-11 15:02:00
 * @version: V2.0
 */
@Api(tags = "系统通告表")
@RestController
@RequestMapping("/sysAnnouncement")
@Slf4j
public class SysAnnouncementController extends JeecgController<SysAnnouncement, ISysAnnouncementService> {

    @Autowired
    private ISysAnnouncementService sysAnnouncementService;

    /**
     * 添加
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "系统通告表-添加")
    @ApiOperation(value = "添加")
    // @RequiresPermissions("sysAnnouncement:SYS_ANNOUNCEMENT:add")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> add(@Valid @RequestBody ReqSysAnnouncementAddDto reqDto) {
        sysAnnouncementService.add(reqDto);
        return Result.OK("添加成功!");
    }

    /**
     * 删除
     * 
     * @param id 主键ID
     * @return Result
     **/
    @AutoLog(value = "系统通告表-删除")
    @ApiOperation(value = "删除")
    // @RequiresPermissions("sysAnnouncement:SYS_ANNOUNCEMENT:delete")
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> delete(@RequestParam("id") String id) {
        sysAnnouncementService.delete(id);
        return Result.OK("删除成功!");
    }

    /**
     * 编辑
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "系统通告表-编辑")
    @ApiOperation(value = "编辑")
    // @RequiresPermissions("sysAnnouncement:SYS_ANNOUNCEMENT:edit")
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result edit(@Valid @RequestBody ReqSysAnnouncementUpdateDto reqDto) {
        sysAnnouncementService.update(reqDto);
        return Result.OK("编辑成功!");
    }

    /**
     * 详情查询
     * 
     * @param id 主键ID
     * @return Result
     **/
    @ApiOperation(value = "详情查询", response = RspSysAnnouncementDto.class)
    // @RequiresPermissions("sysAnnouncement:SYS_ANNOUNCEMENT:detail")
    @GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<RspSysAnnouncementDto> detail(@RequestParam("id") String id) {
        return Result.ok(sysAnnouncementService.detail(id));
    }

    /**
     * 条件查询
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @ApiOperation(value = "条件查询", response = RspSysAnnouncementDto.class)
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<RspSysAnnouncementDto>> queryList(@Valid ReqSysAnnouncementQueryDto reqDto) {
        return Result.ok(sysAnnouncementService.queryList(reqDto));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @ApiOperation(value = "分页查询", response = RspSysAnnouncementDto.class)
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<IPage<RspSysAnnouncementDto>> queryPage(@Valid ReqSysAnnouncementQueryDto reqDto) {
        return Result.ok(sysAnnouncementService.queryPage(reqDto));
    }

}
