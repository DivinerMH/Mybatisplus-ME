package com.linksame.iot.visual.controller;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.linksame.iot.common.core.constant.enums.BusinessEnum;
import com.linksame.iot.common.core.util.R;
import com.linksame.iot.common.log.annotation.SysLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.visual.entity.Component;
import com.linksame.iot.visual.vo.ComponentVO;
import com.linksame.iot.visual.dto.ComponentDTO;
import com.linksame.iot.visual.service.IComponentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 组件(Component)表控制层
 *
 * @author menghuan
 * @since 2021-07-13 11:24:53
 */
@AllArgsConstructor
@RestController
@RequestMapping("/component")
@Api(value = "Component", tags = "组件模块")
public class ComponentController {

    /**
     * 服务对象
     */
    private final IComponentService icomponentService;

    /**
     * 新增组件
     *
     * @param componentDTO 组件接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增组件")
    @ApiOperation(value = "新增组件")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "componentDTO", dataType = "ComponentDTO", required = true, value = "组件对象")})
    @PostMapping
    public R<Boolean> saveComponent(@RequestBody ComponentDTO componentDTO) {
        return R.ok(icomponentService.saveComponent(componentDTO));
    }

    /**
     * 根据id（逻辑）删除组件
     *
     * @param id 组件id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除组件")
    @ApiOperation(value = "根据id（逻辑）删除组件")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "组件id"))
    public R<Boolean> deleteComponent(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(icomponentService.deleteComponent(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改组件
     *
     * @param componentDTO 组件接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改组件")
    @ApiOperation(value = "修改组件")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "componentDTO", dataType = "ComponentDTO", required = true, value = "组件对象")})
    @PutMapping
    public R<Boolean> updateComponent(@RequestBody ComponentDTO componentDTO) {
        return R.ok(icomponentService.updateComponent(componentDTO));
    }

    /**
     * 根据id查询组件详情（单服务）
     *
     * @param id 组件id
     * @return 组件展示对象ComponentVO
     */
    @ApiOperation(value = "根据id查询组件详情")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "组件id"))
    public R<ComponentVO> queryComponent(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(icomponentService.queryComponent(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询组件详情(跨服务)
     *
     * @param id 组件id
     * @return 组件展示对象ComponentVO
     */
    @ApiOperation(value = "根据id查询组件详情(跨服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "组件id"))
    public R<ComponentVO> queryComponentDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(icomponentService.queryComponentDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询组件列表
     *
     * @return 组件展示对象集合ComponentVOList
     */
    @ApiOperation(value = "无参查询组件列表")
    @GetMapping("/lists")
    public R<List<ComponentVO>> queryComponentList() {
        return R.ok(icomponentService.queryComponentList());
    }

    /**
     * 条件查询组件列表
     *
     * @param componentDTO 组件接收入参DTO
     * @return 组件展示对象集合ComponentVOList
     */
    @ApiOperation(value = "条件查询组件列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "componentDTO", dataType = "ComponentDTO", required = false, value = "组件对象")})
    @GetMapping("/lists/conditions")
    public R<List<ComponentVO>> queryListByConditions(ComponentDTO componentDTO) {
        return R.ok(icomponentService.queryListByConditions(componentDTO));
    }

    /**
     * 分页查询查询组件列表
     *
     * @param componentDTO 组件接收入参DTO
     * @return 组件展示对象集合ComponentVOList
     */
    @ApiOperation(value = "分页查询查询组件列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "componentDTO", dataType = "ComponentDTO", required = false, value = "组件对象")})
    @GetMapping("/page/conditions")
    public R<IPage<ComponentVO>> queryPageByConditions(Page page, ComponentDTO componentDTO) {
        return R.ok(icomponentService.queryPageByConditions(page, componentDTO));
    }


}
