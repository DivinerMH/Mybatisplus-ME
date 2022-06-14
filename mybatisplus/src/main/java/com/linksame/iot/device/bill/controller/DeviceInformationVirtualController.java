package com.linksame.iot.device.bill.controller;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.linksame.iot.common.core.constant.enums.BusinessEnum;
import com.linksame.iot.common.core.util.R;
import com.linksame.iot.common.log.annotation.SysLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.device.bill.entity.DeviceInformationVirtual;
import com.linksame.iot.device.bill.vo.DeviceInformationVirtualVO;
import com.linksame.iot.device.bill.dto.DeviceInformationVirtualDTO;
import com.linksame.iot.device.bill.service.IDeviceInformationVirtualService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 虚拟设备台账表(DeviceInformationVirtual)表控制层
 *
 * @author menghuan
 * @since 2022-04-11 16:24:29
 */
@AllArgsConstructor
@RestController
@RequestMapping("/deviceInformationVirtual")
@Api(value = "DeviceInformationVirtual", tags = "虚拟设备台账表模块")
public class DeviceInformationVirtualController {

    /**
     * 服务对象
     */
    private final IDeviceInformationVirtualService ideviceInformationVirtualService;

    /**
     * 新增虚拟设备台账表
     *
     * @param deviceInformationVirtualDTO 虚拟设备台账表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增虚拟设备台账表")
    @ApiOperation(value = "新增虚拟设备台账表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "deviceInformationVirtualDTO", dataType = "DeviceInformationVirtualDTO", required = true, value = "虚拟设备台账表对象")})
    @PostMapping
    public R<Boolean> saveDeviceInformationVirtual(@RequestBody DeviceInformationVirtualDTO deviceInformationVirtualDTO) {
        return R.ok(ideviceInformationVirtualService.saveDeviceInformationVirtual(deviceInformationVirtualDTO));
    }

    /**
     * 根据id（逻辑）删除虚拟设备台账表
     *
     * @param id 虚拟设备台账表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除虚拟设备台账表")
    @ApiOperation(value = "根据id（逻辑）删除虚拟设备台账表")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "虚拟设备台账表id"))
    public R<Boolean> deleteDeviceInformationVirtual(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ideviceInformationVirtualService.deleteDeviceInformationVirtual(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改虚拟设备台账表
     *
     * @param deviceInformationVirtualDTO 虚拟设备台账表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改虚拟设备台账表")
    @ApiOperation(value = "修改虚拟设备台账表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "deviceInformationVirtualDTO", dataType = "DeviceInformationVirtualDTO", required = true, value = "虚拟设备台账表对象")})
    @PutMapping
    public R<Boolean> updateDeviceInformationVirtual(@RequestBody DeviceInformationVirtualDTO deviceInformationVirtualDTO) {
        return R.ok(ideviceInformationVirtualService.updateDeviceInformationVirtual(deviceInformationVirtualDTO));
    }

    /**
     * 根据id查询虚拟设备台账表详情(单服务)
     *
     * @param id 虚拟设备台账表id
     * @return 虚拟设备台账表展示对象DeviceInformationVirtualVO
     */
    @ApiOperation(value = "根据id查询虚拟设备台账表详情(单服务)")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "虚拟设备台账表id"))
    public R<DeviceInformationVirtualVO> queryDeviceInformationVirtual(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ideviceInformationVirtualService.queryDeviceInformationVirtual(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询虚拟设备台账表详情(多服务)
     *
     * @param id 虚拟设备台账表id
     * @return 虚拟设备台账表展示对象DeviceInformationVirtualVO
     */
    @ApiOperation(value = "根据id查询虚拟设备台账表详情(多服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "虚拟设备台账表id"))
    public R<DeviceInformationVirtualVO> queryDeviceInformationVirtualDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ideviceInformationVirtualService.queryDeviceInformationVirtualDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询虚拟设备台账表列表
     *
     * @return 虚拟设备台账表展示对象集合DeviceInformationVirtualVOList
     */
    @ApiOperation(value = "无参查询虚拟设备台账表列表")
    @GetMapping("/lists")
    public R<List<DeviceInformationVirtualVO>> queryDeviceInformationVirtualList() {
        return R.ok(ideviceInformationVirtualService.queryDeviceInformationVirtualList());
    }

    /**
     * 条件查询虚拟设备台账表列表
     *
     * @param deviceInformationVirtualDTO 虚拟设备台账表接收入参DTO
     * @return 虚拟设备台账表展示对象集合DeviceInformationVirtualVOList
     */
    @ApiOperation(value = "条件查询虚拟设备台账表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "deviceInformationVirtualDTO", dataType = "DeviceInformationVirtualDTO", required = false, value = "虚拟设备台账表对象")})
    @PostMapping("/lists/conditions")
    public R<List<DeviceInformationVirtualVO>> queryListByConditions(@RequestBody DeviceInformationVirtualDTO deviceInformationVirtualDTO) {
        // 数据权限
        // deviceInformationVirtualDTO.setTenantId(CommonConverter.dataPermission(deviceInformationVirtualDTO.getTenantId()));
        return R.ok(ideviceInformationVirtualService.queryListByConditions(deviceInformationVirtualDTO));
    }

    /**
     * 分页条件查询虚拟设备台账表列表
     *
     * @param deviceInformationVirtualDTO 虚拟设备台账表接收入参DTO
     * @return 虚拟设备台账表展示对象集合DeviceInformationVirtualVOList
     */
    @ApiOperation(value = "分页条件查询虚拟设备台账表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "deviceInformationVirtualDTO", dataType = "DeviceInformationVirtualDTO", required = false, value = "虚拟设备台账表对象")})
    @GetMapping("/page/conditions")
    public R<IPage<DeviceInformationVirtualVO>> queryPageByConditions(Page page, DeviceInformationVirtualDTO deviceInformationVirtualDTO) {
        // 数据权限
        // deviceInformationVirtualDTO.setTenantId(CommonConverter.dataPermission(deviceInformationVirtualDTO.getTenantId()));
        return R.ok(ideviceInformationVirtualService.queryPageByConditions(page, deviceInformationVirtualDTO));
    }

    /**
     * 数据权限：参数转换
     * 将 tenantId == 1 的系统租户,处理为无 tenantId 条件的情况 - 20.10.12
     * 提示1：若前端同事未提供tenantId参数,但tenantId又有可能作为有用参数,故需要入参进行处理
     * 提示2：此处对比的非租户类型 tenantType
     * 提示3：系统租户唯一性
     * 提示4：构建角色对应资产结构数据权限 - 2021.08.19
     *
     * @param deviceInformationVirtualDTO 入参
     * @return deviceInformationVirtualDTO 处理后的入参
     */
    private DeviceInformationVirtualDTO dealParam(DeviceInformationVirtualDTO deviceInformationVirtualDTO) {
        // 第一层处理:当tenant不传的情况,直接从框架获取对应TenantId数据信息
        if (null == deviceInformationVirtualDTO.getTenantId()) {
            try {
                IotUser user = SecurityUtils.getUser();
                if (null != user.getTenantId()) {
                    deviceInformationVirtualDTO.setTenantId(user.getTenantId());
                }
                // 构建角色资产结构数据权限 - 2021.08.19
                // if (null != user.getRoleId()){
                // deviceInformationVirtualDTO.setAssertIdList(DataScopeComponent.assemblyParam(user.getRoleId()));
                // }
            } catch (Exception e) {
                e.printStackTrace();
                log.info("当前用户登录权限信息获取异常......");
            }
        }
        // 第二层处理:tenant是超级管理员的情况,移除租户边界限制,查询所有
        if (deviceInformationVirtualDTO.getTenantId() == 1) {
            deviceInformationVirtualDTO.setTenantId(null);
        }
        return deviceInformationVirtualDTO;
    }


}
