package com.linksame.iot.external.structure.controller;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.linksame.iot.common.core.constant.enums.BusinessEnum;
import com.linksame.iot.common.core.util.R;
import com.linksame.iot.common.log.annotation.SysLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.external.structure.entity.Building;
import com.linksame.iot.external.structure.vo.BuildingVO;
import com.linksame.iot.external.structure.dto.BuildingDTO;
import com.linksame.iot.external.structure.service.IBuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源管理-楼宇表(Building)表控制层
 *
 * @author menghuan
 * @since 2022-03-11 15:50:15
 */
@AllArgsConstructor
@RestController
@RequestMapping("/building")
@Api(value = "Building", tags = "资源管理-楼宇表模块")
public class BuildingController {

    /**
     * 服务对象
     */
    private final IBuildingService ibuildingService;

    /**
     * 新增资源管理-楼宇表
     *
     * @param buildingDTO 资源管理-楼宇表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增资源管理-楼宇表")
    @ApiOperation(value = "新增资源管理-楼宇表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "buildingDTO", dataType = "BuildingDTO", required = true, value = "资源管理-楼宇表对象")})
    @PostMapping
    public R<Boolean> saveBuilding(@RequestBody BuildingDTO buildingDTO) {
        return R.ok(ibuildingService.saveBuilding(buildingDTO));
    }

    /**
     * 根据id（逻辑）删除资源管理-楼宇表
     *
     * @param id 资源管理-楼宇表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除资源管理-楼宇表")
    @ApiOperation(value = "根据id（逻辑）删除资源管理-楼宇表")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资源管理-楼宇表id"))
    public R<Boolean> deleteBuilding(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ibuildingService.deleteBuilding(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改资源管理-楼宇表
     *
     * @param buildingDTO 资源管理-楼宇表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改资源管理-楼宇表")
    @ApiOperation(value = "修改资源管理-楼宇表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "buildingDTO", dataType = "BuildingDTO", required = true, value = "资源管理-楼宇表对象")})
    @PutMapping
    public R<Boolean> updateBuilding(@RequestBody BuildingDTO buildingDTO) {
        return R.ok(ibuildingService.updateBuilding(buildingDTO));
    }

    /**
     * 根据id查询资源管理-楼宇表详情(单服务)
     *
     * @param id 资源管理-楼宇表id
     * @return 资源管理-楼宇表展示对象BuildingVO
     */
    @ApiOperation(value = "根据id查询资源管理-楼宇表详情(单服务)")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资源管理-楼宇表id"))
    public R<BuildingVO> queryBuilding(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ibuildingService.queryBuilding(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询资源管理-楼宇表详情(多服务)
     *
     * @param id 资源管理-楼宇表id
     * @return 资源管理-楼宇表展示对象BuildingVO
     */
    @ApiOperation(value = "根据id查询资源管理-楼宇表详情(多服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资源管理-楼宇表id"))
    public R<BuildingVO> queryBuildingDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ibuildingService.queryBuildingDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询资源管理-楼宇表列表
     *
     * @return 资源管理-楼宇表展示对象集合BuildingVOList
     */
    @ApiOperation(value = "无参查询资源管理-楼宇表列表")
    @GetMapping("/lists")
    public R<List<BuildingVO>> queryBuildingList() {
        return R.ok(ibuildingService.queryBuildingList());
    }

    /**
     * 条件查询资源管理-楼宇表列表
     *
     * @param buildingDTO 资源管理-楼宇表接收入参DTO
     * @return 资源管理-楼宇表展示对象集合BuildingVOList
     */
    @ApiOperation(value = "条件查询资源管理-楼宇表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "buildingDTO", dataType = "BuildingDTO", required = false, value = "资源管理-楼宇表对象")})
    @PostMapping("/lists/conditions")
    public R<List<BuildingVO>> queryListByConditions(@RequestBody BuildingDTO buildingDTO) {
        // 数据权限
        // buildingDTO.setTenantId(CommonConverter.dataPermission(buildingDTO.getTenantId()));
        return R.ok(ibuildingService.queryListByConditions(buildingDTO));
    }

    /**
     * 分页条件查询资源管理-楼宇表列表
     *
     * @param buildingDTO 资源管理-楼宇表接收入参DTO
     * @return 资源管理-楼宇表展示对象集合BuildingVOList
     */
    @ApiOperation(value = "分页条件查询资源管理-楼宇表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "buildingDTO", dataType = "BuildingDTO", required = false, value = "资源管理-楼宇表对象")})
    @GetMapping("/page/conditions")
    public R<IPage<BuildingVO>> queryPageByConditions(Page page, BuildingDTO buildingDTO) {
        // 数据权限
        // buildingDTO.setTenantId(CommonConverter.dataPermission(buildingDTO.getTenantId()));
        return R.ok(ibuildingService.queryPageByConditions(page, buildingDTO));
    }

    /**
     * 数据权限：参数转换
     * 将 tenantId == 1 的系统租户,处理为无 tenantId 条件的情况 - 20.10.12
     * 提示1：若前端同事未提供tenantId参数,但tenantId又有可能作为有用参数,故需要入参进行处理
     * 提示2：此处对比的非租户类型 tenantType
     * 提示3：系统租户唯一性
     * 提示4：构建角色对应资产结构数据权限 - 2021.08.19
     *
     * @param buildingDTO 入参
     * @return buildingDTO 处理后的入参
     */
    private BuildingDTO dealParam(BuildingDTO buildingDTO) {
        // 第一层处理:当tenant不传的情况,直接从框架获取对应TenantId数据信息
        if (null == buildingDTO.getTenantId()) {
            try {
                IotUser user = SecurityUtils.getUser();
                if (null != user.getTenantId()) {
                    buildingDTO.setTenantId(user.getTenantId());
                }
                // 构建角色资产结构数据权限 - 2021.08.19
                // if (null != user.getRoleId()){
                // buildingDTO.setAssertIdList(DataScopeComponent.assemblyParam(user.getRoleId()));
                // }
            } catch (Exception e) {
                e.printStackTrace();
                log.info("当前用户登录权限信息获取异常......");
            }
        }
        // 第二层处理:tenant是超级管理员的情况,移除租户边界限制,查询所有
        if (buildingDTO.getTenantId() == 1) {
            buildingDTO.setTenantId(null);
        }
        return buildingDTO;
    }


}
