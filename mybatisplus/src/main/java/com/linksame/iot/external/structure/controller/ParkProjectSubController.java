package com.linksame.iot.external.structure.controller;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.linksame.iot.common.core.constant.enums.BusinessEnum;
import com.linksame.iot.common.core.util.R;
import com.linksame.iot.common.log.annotation.SysLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.external.structure.entity.ParkProjectSub;
import com.linksame.iot.external.structure.vo.ParkProjectSubVO;
import com.linksame.iot.external.structure.dto.ParkProjectSubDTO;
import com.linksame.iot.external.structure.service.IParkProjectSubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源管理-项目分期表(ParkProjectSub)表控制层
 *
 * @author menghuan
 * @since 2022-03-11 15:39:05
 */
@AllArgsConstructor
@RestController
@RequestMapping("/parkProjectSub")
@Api(value = "ParkProjectSub", tags = "资源管理-项目分期表模块")
public class ParkProjectSubController {

    /**
     * 服务对象
     */
    private final IParkProjectSubService iparkProjectSubService;

    /**
     * 新增资源管理-项目分期表
     *
     * @param parkProjectSubDTO 资源管理-项目分期表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增资源管理-项目分期表")
    @ApiOperation(value = "新增资源管理-项目分期表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "parkProjectSubDTO", dataType = "ParkProjectSubDTO", required = true, value = "资源管理-项目分期表对象")})
    @PostMapping
    public R<Boolean> saveParkProjectSub(@RequestBody ParkProjectSubDTO parkProjectSubDTO) {
        return R.ok(iparkProjectSubService.saveParkProjectSub(parkProjectSubDTO));
    }

    /**
     * 根据id（逻辑）删除资源管理-项目分期表
     *
     * @param id 资源管理-项目分期表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除资源管理-项目分期表")
    @ApiOperation(value = "根据id（逻辑）删除资源管理-项目分期表")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资源管理-项目分期表id"))
    public R<Boolean> deleteParkProjectSub(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iparkProjectSubService.deleteParkProjectSub(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改资源管理-项目分期表
     *
     * @param parkProjectSubDTO 资源管理-项目分期表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改资源管理-项目分期表")
    @ApiOperation(value = "修改资源管理-项目分期表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "parkProjectSubDTO", dataType = "ParkProjectSubDTO", required = true, value = "资源管理-项目分期表对象")})
    @PutMapping
    public R<Boolean> updateParkProjectSub(@RequestBody ParkProjectSubDTO parkProjectSubDTO) {
        return R.ok(iparkProjectSubService.updateParkProjectSub(parkProjectSubDTO));
    }

    /**
     * 根据id查询资源管理-项目分期表详情(单服务)
     *
     * @param id 资源管理-项目分期表id
     * @return 资源管理-项目分期表展示对象ParkProjectSubVO
     */
    @ApiOperation(value = "根据id查询资源管理-项目分期表详情(单服务)")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资源管理-项目分期表id"))
    public R<ParkProjectSubVO> queryParkProjectSub(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iparkProjectSubService.queryParkProjectSub(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询资源管理-项目分期表详情(多服务)
     *
     * @param id 资源管理-项目分期表id
     * @return 资源管理-项目分期表展示对象ParkProjectSubVO
     */
    @ApiOperation(value = "根据id查询资源管理-项目分期表详情(多服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资源管理-项目分期表id"))
    public R<ParkProjectSubVO> queryParkProjectSubDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iparkProjectSubService.queryParkProjectSubDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询资源管理-项目分期表列表
     *
     * @return 资源管理-项目分期表展示对象集合ParkProjectSubVOList
     */
    @ApiOperation(value = "无参查询资源管理-项目分期表列表")
    @GetMapping("/lists")
    public R<List<ParkProjectSubVO>> queryParkProjectSubList() {
        return R.ok(iparkProjectSubService.queryParkProjectSubList());
    }

    /**
     * 条件查询资源管理-项目分期表列表
     *
     * @param parkProjectSubDTO 资源管理-项目分期表接收入参DTO
     * @return 资源管理-项目分期表展示对象集合ParkProjectSubVOList
     */
    @ApiOperation(value = "条件查询资源管理-项目分期表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "parkProjectSubDTO", dataType = "ParkProjectSubDTO", required = false, value = "资源管理-项目分期表对象")})
    @PostMapping("/lists/conditions")
    public R<List<ParkProjectSubVO>> queryListByConditions(@RequestBody ParkProjectSubDTO parkProjectSubDTO) {
        // 数据权限
        // parkProjectSubDTO.setTenantId(CommonConverter.dataPermission(parkProjectSubDTO.getTenantId()));
        return R.ok(iparkProjectSubService.queryListByConditions(parkProjectSubDTO));
    }

    /**
     * 分页条件查询资源管理-项目分期表列表
     *
     * @param parkProjectSubDTO 资源管理-项目分期表接收入参DTO
     * @return 资源管理-项目分期表展示对象集合ParkProjectSubVOList
     */
    @ApiOperation(value = "分页条件查询资源管理-项目分期表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "parkProjectSubDTO", dataType = "ParkProjectSubDTO", required = false, value = "资源管理-项目分期表对象")})
    @GetMapping("/page/conditions")
    public R<IPage<ParkProjectSubVO>> queryPageByConditions(Page page, ParkProjectSubDTO parkProjectSubDTO) {
        // 数据权限
        // parkProjectSubDTO.setTenantId(CommonConverter.dataPermission(parkProjectSubDTO.getTenantId()));
        return R.ok(iparkProjectSubService.queryPageByConditions(page, parkProjectSubDTO));
    }

    /**
     * 数据权限：参数转换
     * 将 tenantId == 1 的系统租户,处理为无 tenantId 条件的情况 - 20.10.12
     * 提示1：若前端同事未提供tenantId参数,但tenantId又有可能作为有用参数,故需要入参进行处理
     * 提示2：此处对比的非租户类型 tenantType
     * 提示3：系统租户唯一性
     * 提示4：构建角色对应资产结构数据权限 - 2021.08.19
     *
     * @param parkProjectSubDTO 入参
     * @return parkProjectSubDTO 处理后的入参
     */
    private ParkProjectSubDTO dealParam(ParkProjectSubDTO parkProjectSubDTO) {
        // 第一层处理:当tenant不传的情况,直接从框架获取对应TenantId数据信息
        if (null == parkProjectSubDTO.getTenantId()) {
            try {
                IotUser user = SecurityUtils.getUser();
                if (null != user.getTenantId()) {
                    parkProjectSubDTO.setTenantId(user.getTenantId());
                }
                // 构建角色资产结构数据权限 - 2021.08.19
                // if (null != user.getRoleId()){
                // parkProjectSubDTO.setAssertIdList(DataScopeComponent.assemblyParam(user.getRoleId()));
                // }
            } catch (Exception e) {
                e.printStackTrace();
                log.info("当前用户登录权限信息获取异常......");
            }
        }
        // 第二层处理:tenant是超级管理员的情况,移除租户边界限制,查询所有
        if (parkProjectSubDTO.getTenantId() == 1) {
            parkProjectSubDTO.setTenantId(null);
        }
        return parkProjectSubDTO;
    }


}
