package com.linksame.iot.device.bill.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.common.core.constant.enums.BusinessEnum;
import com.linksame.iot.common.core.util.R;
import com.linksame.iot.common.log.annotation.SysLog;
import com.linksame.iot.device.bill.dto.DeviceInformationAttributeDTO;
import com.linksame.iot.device.bill.service.IDeviceInformationAttributeService;
import com.linksame.iot.device.bill.vo.DeviceInformationAttributeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 虚拟设备台账属性表(DeviceInformationAttribute)表控制层
 *
 * @author menghuan
 * @since 2022-04-11 16:24:01
 */
@AllArgsConstructor
@RestController
@RequestMapping("/deviceInformationAttribute")
@Api(value = "DeviceInformationAttribute", tags = "虚拟设备台账属性表模块")
public class DeviceInformationAttributeController {

    /**
     * 服务对象
     */
    private final IDeviceInformationAttributeService ideviceInformationAttributeService;

    /**
     * 新增虚拟设备台账属性表
     *
     * @param deviceInformationAttributeDTO 虚拟设备台账属性表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增虚拟设备台账属性表")
    @ApiOperation(value = "新增虚拟设备台账属性表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "deviceInformationAttributeDTO", dataType = "DeviceInformationAttributeDTO", required = true, value = "虚拟设备台账属性表对象")})
    @PostMapping
    public R<Boolean> saveDeviceInformationAttribute(@RequestBody DeviceInformationAttributeDTO deviceInformationAttributeDTO) {
        return R.ok(ideviceInformationAttributeService.saveDeviceInformationAttribute(deviceInformationAttributeDTO));
    }

    /**
     * 根据id（逻辑）删除虚拟设备台账属性表
     *
     * @param id 虚拟设备台账属性表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除虚拟设备台账属性表")
    @ApiOperation(value = "根据id（逻辑）删除虚拟设备台账属性表")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "虚拟设备台账属性表id"))
    public R<Boolean> deleteDeviceInformationAttribute(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ideviceInformationAttributeService.deleteDeviceInformationAttribute(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改虚拟设备台账属性表
     *
     * @param deviceInformationAttributeDTO 虚拟设备台账属性表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改虚拟设备台账属性表")
    @ApiOperation(value = "修改虚拟设备台账属性表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "deviceInformationAttributeDTO", dataType = "DeviceInformationAttributeDTO", required = true, value = "虚拟设备台账属性表对象")})
    @PutMapping
    public R<Boolean> updateDeviceInformationAttribute(@RequestBody DeviceInformationAttributeDTO deviceInformationAttributeDTO) {
        return R.ok(ideviceInformationAttributeService.updateDeviceInformationAttribute(deviceInformationAttributeDTO));
    }

    /**
     * 根据id查询虚拟设备台账属性表详情(单服务)
     *
     * @param id 虚拟设备台账属性表id
     * @return 虚拟设备台账属性表展示对象DeviceInformationAttributeVO
     */
    @ApiOperation(value = "根据id查询虚拟设备台账属性表详情(单服务)")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "虚拟设备台账属性表id"))
    public R<DeviceInformationAttributeVO> queryDeviceInformationAttribute(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ideviceInformationAttributeService.queryDeviceInformationAttribute(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询虚拟设备台账属性表详情(多服务)
     *
     * @param id 虚拟设备台账属性表id
     * @return 虚拟设备台账属性表展示对象DeviceInformationAttributeVO
     */
    @ApiOperation(value = "根据id查询虚拟设备台账属性表详情(多服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "虚拟设备台账属性表id"))
    public R<DeviceInformationAttributeVO> queryDeviceInformationAttributeDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(ideviceInformationAttributeService.queryDeviceInformationAttributeDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询虚拟设备台账属性表列表
     *
     * @return 虚拟设备台账属性表展示对象集合DeviceInformationAttributeVOList
     */
    @ApiOperation(value = "无参查询虚拟设备台账属性表列表")
    @GetMapping("/lists")
    public R<List<DeviceInformationAttributeVO>> queryDeviceInformationAttributeList() {
        return R.ok(ideviceInformationAttributeService.queryDeviceInformationAttributeList());
    }

    /**
     * 条件查询虚拟设备台账属性表列表
     *
     * @param deviceInformationAttributeDTO 虚拟设备台账属性表接收入参DTO
     * @return 虚拟设备台账属性表展示对象集合DeviceInformationAttributeVOList
     */
    @ApiOperation(value = "条件查询虚拟设备台账属性表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "deviceInformationAttributeDTO", dataType = "DeviceInformationAttributeDTO", required = false, value = "虚拟设备台账属性表对象")})
    @PostMapping("/lists/conditions")
    public R<List<DeviceInformationAttributeVO>> queryListByConditions(@RequestBody DeviceInformationAttributeDTO deviceInformationAttributeDTO) {
        // 数据权限
        // deviceInformationAttributeDTO.setTenantId(CommonConverter.dataPermission(deviceInformationAttributeDTO.getTenantId()));
        return R.ok(ideviceInformationAttributeService.queryListByConditions(deviceInformationAttributeDTO));
    }

    /**
     * 分页条件查询虚拟设备台账属性表列表
     *
     * @param deviceInformationAttributeDTO 虚拟设备台账属性表接收入参DTO
     * @return 虚拟设备台账属性表展示对象集合DeviceInformationAttributeVOList
     */
    @ApiOperation(value = "分页条件查询虚拟设备台账属性表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "deviceInformationAttributeDTO", dataType = "DeviceInformationAttributeDTO", required = false, value = "虚拟设备台账属性表对象")})
    @GetMapping("/page/conditions")
    public R<IPage<DeviceInformationAttributeVO>> queryPageByConditions(Page page, DeviceInformationAttributeDTO deviceInformationAttributeDTO) {
        // 数据权限
        // deviceInformationAttributeDTO.setTenantId(CommonConverter.dataPermission(deviceInformationAttributeDTO.getTenantId()));
        return R.ok(ideviceInformationAttributeService.queryPageByConditions(page, deviceInformationAttributeDTO));
    }

    /**
     * 数据权限：参数转换
     * 将 tenantId == 1 的系统租户,处理为无 tenantId 条件的情况 - 20.10.12
     * 提示1：若前端同事未提供tenantId参数,但tenantId又有可能作为有用参数,故需要入参进行处理
     * 提示2：此处对比的非租户类型 tenantType
     * 提示3：系统租户唯一性
     * 提示4：构建角色对应资产结构数据权限 - 2021.08.19
     *
     * @param deviceInformationAttributeDTO 入参
     * @return deviceInformationAttributeDTO 处理后的入参
     */
    private DeviceInformationAttributeDTO dealParam(DeviceInformationAttributeDTO deviceInformationAttributeDTO) {
        // 第一层处理:当tenant不传的情况,直接从框架获取对应TenantId数据信息
        if (null == deviceInformationAttributeDTO.getTenantId()) {
            try {
                IotUser user = SecurityUtils.getUser();
                if (null != user.getTenantId()) {
                    deviceInformationAttributeDTO.setTenantId(user.getTenantId());
                }
                // 构建角色资产结构数据权限 - 2021.08.19
                // if (null != user.getRoleId()){
                // deviceInformationAttributeDTO.setAssertIdList(DataScopeComponent.assemblyParam(user.getRoleId()));
                // }
            } catch (Exception e) {
                e.printStackTrace();
                log.info("当前用户登录权限信息获取异常......");
            }
        }
        // 第二层处理:tenant是超级管理员的情况,移除租户边界限制,查询所有
        if (deviceInformationAttributeDTO.getTenantId() == 1) {
            deviceInformationAttributeDTO.setTenantId(null);
        }
        return deviceInformationAttributeDTO;
    }


}
