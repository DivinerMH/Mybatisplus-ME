package com.linksame.iot.external.structure.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.common.core.constant.enums.BusinessEnum;
import com.linksame.iot.common.core.util.R;
import com.linksame.iot.common.log.annotation.SysLog;
import com.linksame.iot.external.structure.dto.BuildingFloorDTO;
import com.linksame.iot.external.structure.service.IBuildingFloorService;
import com.linksame.iot.external.structure.vo.BuildingFloorVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源管理-楼层表(BuildingFloor)表控制层
 *
 * @author menghuan
 * @since 2022-03-11 15:50:31
 */
@AllArgsConstructor
@RestController
@RequestMapping("/buildingFloor")
@Api(value = "BuildingFloor", tags = "资源管理-楼层表模块")
public class BuildingFloorController {

    /**
     * 服务对象
     */
    private final IBuildingFloorService ibuildingFloorService;

    /**
     * 新增资源管理-楼层表
     *
     * @param buildingFloorDTO 资源管理-楼层表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增资源管理-楼层表")
    @ApiOperation(value = "新增资源管理-楼层表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "buildingFloorDTO", dataType = "BuildingFloorDTO", required = true, value = "资源管理-楼层表对象")})
    @PostMapping
    public R<Boolean> saveBuildingFloor(@RequestBody BuildingFloorDTO buildingFloorDTO) {
        return R.ok(ibuildingFloorService.saveBuildingFloor(buildingFloorDTO));
    }

    /**
     * 根据id（逻辑）删除资源管理-楼层表
     *
     * @param id 资源管理-楼层表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除资源管理-楼层表")
    @ApiOperation(value = "根据id（逻辑）删除资源管理-楼层表")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资源管理-楼层表id"))
    public R<Boolean> deleteBuildingFloor(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ibuildingFloorService.deleteBuildingFloor(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改资源管理-楼层表
     *
     * @param buildingFloorDTO 资源管理-楼层表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改资源管理-楼层表")
    @ApiOperation(value = "修改资源管理-楼层表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "buildingFloorDTO", dataType = "BuildingFloorDTO", required = true, value = "资源管理-楼层表对象")})
    @PutMapping
    public R<Boolean> updateBuildingFloor(@RequestBody BuildingFloorDTO buildingFloorDTO) {
        return R.ok(ibuildingFloorService.updateBuildingFloor(buildingFloorDTO));
    }

    /**
     * 根据id查询资源管理-楼层表详情(单服务)
     *
     * @param id 资源管理-楼层表id
     * @return 资源管理-楼层表展示对象BuildingFloorVO
     */
    @ApiOperation(value = "根据id查询资源管理-楼层表详情(单服务)")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资源管理-楼层表id"))
    public R<BuildingFloorVO> queryBuildingFloor(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ibuildingFloorService.queryBuildingFloor(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询资源管理-楼层表详情(多服务)
     *
     * @param id 资源管理-楼层表id
     * @return 资源管理-楼层表展示对象BuildingFloorVO
     */
    @ApiOperation(value = "根据id查询资源管理-楼层表详情(多服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资源管理-楼层表id"))
    public R<BuildingFloorVO> queryBuildingFloorDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ibuildingFloorService.queryBuildingFloorDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询资源管理-楼层表列表
     *
     * @return 资源管理-楼层表展示对象集合BuildingFloorVOList
     */
    @ApiOperation(value = "无参查询资源管理-楼层表列表")
    @GetMapping("/lists")
    public R<List<BuildingFloorVO>> queryBuildingFloorList() {
        return R.ok(ibuildingFloorService.queryBuildingFloorList());
    }

    /**
     * 条件查询资源管理-楼层表列表
     *
     * @param buildingFloorDTO 资源管理-楼层表接收入参DTO
     * @return 资源管理-楼层表展示对象集合BuildingFloorVOList
     */
    @ApiOperation(value = "条件查询资源管理-楼层表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "buildingFloorDTO", dataType = "BuildingFloorDTO", required = false, value = "资源管理-楼层表对象")})
    @PostMapping("/lists/conditions")
    public R<List<BuildingFloorVO>> queryListByConditions(@RequestBody BuildingFloorDTO buildingFloorDTO) {
        // 数据权限
        // buildingFloorDTO.setTenantId(CommonConverter.dataPermission(buildingFloorDTO.getTenantId()));
        return R.ok(ibuildingFloorService.queryListByConditions(buildingFloorDTO));
    }

    /**
     * 分页条件查询资源管理-楼层表列表
     *
     * @param buildingFloorDTO 资源管理-楼层表接收入参DTO
     * @return 资源管理-楼层表展示对象集合BuildingFloorVOList
     */
    @ApiOperation(value = "分页条件查询资源管理-楼层表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "buildingFloorDTO", dataType = "BuildingFloorDTO", required = false, value = "资源管理-楼层表对象")})
    @GetMapping("/page/conditions")
    public R<IPage<BuildingFloorVO>> queryPageByConditions(Page page, BuildingFloorDTO buildingFloorDTO) {
        // 数据权限
        // buildingFloorDTO.setTenantId(CommonConverter.dataPermission(buildingFloorDTO.getTenantId()));
        return R.ok(ibuildingFloorService.queryPageByConditions(page, buildingFloorDTO));
    }

    /**
     * 数据权限：参数转换
     * 将 tenantId == 1 的系统租户,处理为无 tenantId 条件的情况 - 20.10.12
     * 提示1：若前端同事未提供tenantId参数,但tenantId又有可能作为有用参数,故需要入参进行处理
     * 提示2：此处对比的非租户类型 tenantType
     * 提示3：系统租户唯一性
     * 提示4：构建角色对应资产结构数据权限 - 2021.08.19
     *
     * @param buildingFloorDTO 入参
     * @return buildingFloorDTO 处理后的入参
     */
    private BuildingFloorDTO dealParam(BuildingFloorDTO buildingFloorDTO) {
        // 第一层处理:当tenant不传的情况,直接从框架获取对应TenantId数据信息
        if (null == buildingFloorDTO.getTenantId()) {
            try {
                IotUser user = SecurityUtils.getUser();
                if (null != user.getTenantId()) {
                    buildingFloorDTO.setTenantId(user.getTenantId());
                }
                // 构建角色资产结构数据权限 - 2021.08.19
                // if (null != user.getRoleId()){
                // buildingFloorDTO.setAssertIdList(DataScopeComponent.assemblyParam(user.getRoleId()));
                // }
            } catch (Exception e) {
                e.printStackTrace();
                log.info("当前用户登录权限信息获取异常......");
            }
        }
        // 第二层处理:tenant是超级管理员的情况,移除租户边界限制,查询所有
        if (buildingFloorDTO.getTenantId() == 1) {
            buildingFloorDTO.setTenantId(null);
        }
        return buildingFloorDTO;
    }


}
