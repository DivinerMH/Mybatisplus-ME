package com.linksame.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.dto.IotTrdStructureMachineDTO;
import com.linksame.iot.common.core.constant.enums.BusinessEnum;
import com.linksame.iot.common.core.util.R;
import com.linksame.iot.common.log.annotation.SysLog;
import com.linksame.service.IIotTrdStructureMachineService;
import com.linksame.vo.IotTrdStructureMachineVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 3D模型组件与资产结构设备关系(IotTrdStructureMachine)表控制层
 *
 * @author menghuan
 * @since 2022-04-19 14:16:50
 */
@AllArgsConstructor
@RestController
@RequestMapping("/iotTrdStructureMachine")
@Api(value = "IotTrdStructureMachine", tags = "3D模型组件与资产结构设备关系模块")
public class IotTrdStructureMachineController {

    /**
     * 服务对象
     */
    private final IIotTrdStructureMachineService iiotTrdStructureMachineService;

    /**
     * 新增3D模型组件与资产结构设备关系
     *
     * @param iotTrdStructureMachineDTO 3D模型组件与资产结构设备关系接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增3D模型组件与资产结构设备关系")
    @ApiOperation(value = "新增3D模型组件与资产结构设备关系")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotTrdStructureMachineDTO", dataType = "IotTrdStructureMachineDTO", required = true, value = "3D模型组件与资产结构设备关系对象")})
    @PostMapping
    public R<Boolean> saveIotTrdStructureMachine(@RequestBody IotTrdStructureMachineDTO iotTrdStructureMachineDTO) {
        return R.ok(iiotTrdStructureMachineService.saveIotTrdStructureMachine(iotTrdStructureMachineDTO));
    }

    /**
     * 根据id（逻辑）删除3D模型组件与资产结构设备关系
     *
     * @param id 3D模型组件与资产结构设备关系id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除3D模型组件与资产结构设备关系")
    @ApiOperation(value = "根据id（逻辑）删除3D模型组件与资产结构设备关系")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "3D模型组件与资产结构设备关系id"))
    public R<Boolean> deleteIotTrdStructureMachine(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotTrdStructureMachineService.deleteIotTrdStructureMachine(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改3D模型组件与资产结构设备关系
     *
     * @param iotTrdStructureMachineDTO 3D模型组件与资产结构设备关系接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改3D模型组件与资产结构设备关系")
    @ApiOperation(value = "修改3D模型组件与资产结构设备关系")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotTrdStructureMachineDTO", dataType = "IotTrdStructureMachineDTO", required = true, value = "3D模型组件与资产结构设备关系对象")})
    @PutMapping
    public R<Boolean> updateIotTrdStructureMachine(@RequestBody IotTrdStructureMachineDTO iotTrdStructureMachineDTO) {
        return R.ok(iiotTrdStructureMachineService.updateIotTrdStructureMachine(iotTrdStructureMachineDTO));
    }

    /**
     * 根据id查询3D模型组件与资产结构设备关系详情(单服务)
     *
     * @param id 3D模型组件与资产结构设备关系id
     * @return 3D模型组件与资产结构设备关系展示对象IotTrdStructureMachineVO
     */
    @ApiOperation(value = "根据id查询3D模型组件与资产结构设备关系详情(单服务)")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "3D模型组件与资产结构设备关系id"))
    public R<IotTrdStructureMachineVO> queryIotTrdStructureMachine(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotTrdStructureMachineService.queryIotTrdStructureMachine(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询3D模型组件与资产结构设备关系详情(多服务)
     *
     * @param id 3D模型组件与资产结构设备关系id
     * @return 3D模型组件与资产结构设备关系展示对象IotTrdStructureMachineVO
     */
    @ApiOperation(value = "根据id查询3D模型组件与资产结构设备关系详情(多服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "3D模型组件与资产结构设备关系id"))
    public R<IotTrdStructureMachineVO> queryIotTrdStructureMachineDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotTrdStructureMachineService.queryIotTrdStructureMachineDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询3D模型组件与资产结构设备关系列表
     *
     * @return 3D模型组件与资产结构设备关系展示对象集合IotTrdStructureMachineVOList
     */
    @ApiOperation(value = "无参查询3D模型组件与资产结构设备关系列表")
    @GetMapping("/lists")
    public R<List<IotTrdStructureMachineVO>> queryIotTrdStructureMachineList() {
        return R.ok(iiotTrdStructureMachineService.queryIotTrdStructureMachineList());
    }

    /**
     * 条件查询3D模型组件与资产结构设备关系列表
     *
     * @param iotTrdStructureMachineDTO 3D模型组件与资产结构设备关系接收入参DTO
     * @return 3D模型组件与资产结构设备关系展示对象集合IotTrdStructureMachineVOList
     */
    @ApiOperation(value = "条件查询3D模型组件与资产结构设备关系列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotTrdStructureMachineDTO", dataType = "IotTrdStructureMachineDTO", required = false, value = "3D模型组件与资产结构设备关系对象")})
    @PostMapping("/lists/conditions")
    public R<List<IotTrdStructureMachineVO>> queryListByConditions(@RequestBody IotTrdStructureMachineDTO iotTrdStructureMachineDTO) {
        // 数据权限
        // iotTrdStructureMachineDTO.setTenantId(CommonConverter.dataPermission(iotTrdStructureMachineDTO.getTenantId()));
        return R.ok(iiotTrdStructureMachineService.queryListByConditions(iotTrdStructureMachineDTO));
    }

    /**
     * 分页条件查询3D模型组件与资产结构设备关系列表
     *
     * @param iotTrdStructureMachineDTO 3D模型组件与资产结构设备关系接收入参DTO
     * @return 3D模型组件与资产结构设备关系展示对象集合IotTrdStructureMachineVOList
     */
    @ApiOperation(value = "分页条件查询3D模型组件与资产结构设备关系列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "iotTrdStructureMachineDTO", dataType = "IotTrdStructureMachineDTO", required = false, value = "3D模型组件与资产结构设备关系对象")})
    @GetMapping("/page/conditions")
    public R<IPage<IotTrdStructureMachineVO>> queryPageByConditions(Page page, IotTrdStructureMachineDTO iotTrdStructureMachineDTO) {
        // 数据权限
        // iotTrdStructureMachineDTO.setTenantId(CommonConverter.dataPermission(iotTrdStructureMachineDTO.getTenantId()));
        return R.ok(iiotTrdStructureMachineService.queryPageByConditions(page, iotTrdStructureMachineDTO));
    }

    /**
     * 数据权限：参数转换
     * 将 tenantId == 1 的系统租户,处理为无 tenantId 条件的情况 - 20.10.12
     * 提示1：若前端同事未提供tenantId参数,但tenantId又有可能作为有用参数,故需要入参进行处理
     * 提示2：此处对比的非租户类型 tenantType
     * 提示3：系统租户唯一性
     * 提示4：构建角色对应资产结构数据权限 - 2021.08.19
     *
     * @param iotTrdStructureMachineDTO 入参
     * @return iotTrdStructureMachineDTO 处理后的入参
     */
    private IotTrdStructureMachineDTO dealParam(IotTrdStructureMachineDTO iotTrdStructureMachineDTO) {
        // 第一层处理:当tenant不传的情况,直接从框架获取对应TenantId数据信息
        if (null == iotTrdStructureMachineDTO.getTenantId()) {
            try {
                IotUser user = SecurityUtils.getUser();
                if (null != user.getTenantId()) {
                    iotTrdStructureMachineDTO.setTenantId(user.getTenantId());
                }
                // 构建角色资产结构数据权限 - 2021.08.19
                // if (null != user.getRoleId()){
                // iotTrdStructureMachineDTO.setAssertIdList(DataScopeComponent.assemblyParam(user.getRoleId()));
                // }
            } catch (Exception e) {
                e.printStackTrace();
                log.info("当前用户登录权限信息获取异常......");
            }
        }
        // 第二层处理:tenant是超级管理员的情况,移除租户边界限制,查询所有
        if (iotTrdStructureMachineDTO.getTenantId() == 1) {
            iotTrdStructureMachineDTO.setTenantId(null);
        }
        return iotTrdStructureMachineDTO;
    }


}
