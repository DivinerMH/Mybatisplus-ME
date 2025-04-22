package com.dfzl.material.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dfzl.material.bean.dto.ReqAfMaterialApplyAddDto;
import com.dfzl.material.bean.dto.ReqAfMaterialApplyQueryDto;
import com.dfzl.material.bean.dto.ReqAfMaterialApplyUpdateDto;
import com.dfzl.material.bean.dto.RspAfMaterialApplyDto;
import com.dfzl.material.bean.po.AfMaterialApply;
import com.dfzl.material.service.IAfMaterialApplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: 物料申请Controller
 *
 * @author makejava
 * @since 2025-01-14 18:42:12
 * @Version: V2.0
 */
@Api(tags = "物料申请")
@RestController
@RequestMapping("/afMaterialApply")
@Slf4j
public class AfMaterialApplyController extends JeecgController<AfMaterialApply, IAfMaterialApplyService> {

    @Autowired
    private IAfMaterialApplyService afMaterialApplyService;

    /**
     * 添加
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "物料申请-添加")
    @ApiOperation(value = "添加")
    // @RequiresPermissions("inbound:AF_MATERIAL_APPLY:add")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> add(@Valid @RequestBody ReqAfMaterialApplyAddDto reqDto) {
        afMaterialApplyService.add(reqDto);
        return Result.OK("添加成功!");
    }

    /**
     * 删除
     * 
     * @param id 主键ID
     * @return Result
     **/
    @AutoLog(value = "物料申请-删除")
    @ApiOperation(value = "删除")
    // @RequiresPermissions("inbound:AF_MATERIAL_APPLY:delete")
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> delete(@RequestParam("id") String id) {
        afMaterialApplyService.delete(id);
        return Result.OK("删除成功!");
    }

    /**
     * 编辑
     * 
     * @param reqDto 入参Dto
     * @return Result
     **/
    @AutoLog(value = "物料申请-编辑")
    @ApiOperation(value = "编辑")
    // @RequiresPermissions("inbound:AF_MATERIAL_APPLY:edit")
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result edit(@Valid @RequestBody ReqAfMaterialApplyUpdateDto reqDto) {
        afMaterialApplyService.update(reqDto);
        return Result.OK("编辑成功!");
    }

    /**
     * 详情查询
     * 
     * @param id 主键ID
     * @return Result
     **/
    @ApiOperation(value = "详情查询", response = RspAfMaterialApplyDto.class)
    @GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<RspAfMaterialApplyDto> detail(@RequestParam("id") String id) {
        return Result.ok(afMaterialApplyService.detail(id));
    }

    /**
     * 分页查询
     * 
     * @param reqDto 入参Dto
     * @return ApiResult
     **/
    @ApiOperation(value = "分页查询", response = RspAfMaterialApplyDto.class)
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<IPage<RspAfMaterialApplyDto>> queryPage(@Valid ReqAfMaterialApplyQueryDto reqDto) {
        return Result.ok(afMaterialApplyService.queryPage(reqDto));
    }

}
