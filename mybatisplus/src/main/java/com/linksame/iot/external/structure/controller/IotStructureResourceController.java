package com.linksame.iot.external.structure.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.linksame.iot.common.core.constant.enums.BusinessEnum;
import com.linksame.iot.common.core.util.R;
import com.linksame.iot.common.log.annotation.SysLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.external.structure.entity.IotStructureResource;
import com.linksame.iot.external.structure.vo.IotStructureResourceVO;
import com.linksame.iot.external.structure.dto.IotStructureResourceDTO;
import com.linksame.iot.external.structure.service.IIotStructureResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资产结构与资源关系（深宝园-手动维护）(IotStructureResource)表控制层
 *
 * @author menghuan
 * @since 2022-03-11 16:14:08
 */
@AllArgsConstructor
@RestController
@RequestMapping("/iotStructureResource")
@Api(value = "IotStructureResource", tags = "资产结构与资源关系（深宝园-手动维护）模块")
public class IotStructureResourceController {

    /**
     * 服务对象
     */
    private final IIotStructureResourceService iiotStructureResourceService;

    /**
     * 新增资产结构与资源关系（深宝园-手动维护）
     *
     * @param iotStructureResourceDTO 资产结构与资源关系（深宝园-手动维护）接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增资产结构与资源关系（深宝园-手动维护）")
    @ApiOperation(value = "新增资产结构与资源关系（深宝园-手动维护）")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotStructureResourceDTO", dataType = "IotStructureResourceDTO", required = true, value = "资产结构与资源关系（深宝园-手动维护）对象")})
    @PostMapping
    public R<Boolean> saveIotStructureResource(@RequestBody IotStructureResourceDTO iotStructureResourceDTO) {
        return R.ok(iiotStructureResourceService.saveIotStructureResource(iotStructureResourceDTO));
    }

    /**
     * 根据id（逻辑）删除资产结构与资源关系（深宝园-手动维护）
     *
     * @param id 资产结构与资源关系（深宝园-手动维护）id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除资产结构与资源关系（深宝园-手动维护）")
    @ApiOperation(value = "根据id（逻辑）删除资产结构与资源关系（深宝园-手动维护）")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资产结构与资源关系（深宝园-手动维护）id"))
    public R<Boolean> deleteIotStructureResource(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotStructureResourceService.deleteIotStructureResource(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改资产结构与资源关系（深宝园-手动维护）
     *
     * @param iotStructureResourceDTO 资产结构与资源关系（深宝园-手动维护）接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改资产结构与资源关系（深宝园-手动维护）")
    @ApiOperation(value = "修改资产结构与资源关系（深宝园-手动维护）")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotStructureResourceDTO", dataType = "IotStructureResourceDTO", required = true, value = "资产结构与资源关系（深宝园-手动维护）对象")})
    @PutMapping
    public R<Boolean> updateIotStructureResource(@RequestBody IotStructureResourceDTO iotStructureResourceDTO) {
        return R.ok(iiotStructureResourceService.updateIotStructureResource(iotStructureResourceDTO));
    }

    /**
     * 根据id查询资产结构与资源关系（深宝园-手动维护）详情(单服务)
     *
     * @param id 资产结构与资源关系（深宝园-手动维护）id
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象IotStructureResourceVO
     */
    @ApiOperation(value = "根据id查询资产结构与资源关系（深宝园-手动维护）详情(单服务)")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资产结构与资源关系（深宝园-手动维护）id"))
    public R<IotStructureResourceVO> queryIotStructureResource(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotStructureResourceService.queryIotStructureResource(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询资产结构与资源关系（深宝园-手动维护）详情(多服务)
     *
     * @param id 资产结构与资源关系（深宝园-手动维护）id
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象IotStructureResourceVO
     */
    @ApiOperation(value = "根据id查询资产结构与资源关系（深宝园-手动维护）详情(多服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "资产结构与资源关系（深宝园-手动维护）id"))
    public R<IotStructureResourceVO> queryIotStructureResourceDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotStructureResourceService.queryIotStructureResourceDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询资产结构与资源关系（深宝园-手动维护）列表
     *
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象集合IotStructureResourceVOList
     */
    @ApiOperation(value = "无参查询资产结构与资源关系（深宝园-手动维护）列表")
    @GetMapping("/lists")
    public R<List<IotStructureResourceVO>> queryIotStructureResourceList() {
        return R.ok(iiotStructureResourceService.queryIotStructureResourceList());
    }

    /**
     * 条件查询资产结构与资源关系（深宝园-手动维护）列表
     *
     * @param iotStructureResourceDTO 资产结构与资源关系（深宝园-手动维护）接收入参DTO
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象集合IotStructureResourceVOList
     */
    @ApiOperation(value = "条件查询资产结构与资源关系（深宝园-手动维护）列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotStructureResourceDTO", dataType = "IotStructureResourceDTO", required = false, value = "资产结构与资源关系（深宝园-手动维护）对象")})
    @PostMapping("/lists/conditions")
    public R<List<IotStructureResourceVO>> queryListByConditions(@RequestBody IotStructureResourceDTO iotStructureResourceDTO) {
        // 数据权限
        // iotStructureResourceDTO.setTenantId(CommonConverter.dataPermission(iotStructureResourceDTO.getTenantId()));
        return R.ok(iiotStructureResourceService.queryListByConditions(iotStructureResourceDTO));
    }

    /**
     * 分页条件查询资产结构与资源关系（深宝园-手动维护）列表
     *
     * @param iotStructureResourceDTO 资产结构与资源关系（深宝园-手动维护）接收入参DTO
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象集合IotStructureResourceVOList
     */
    @ApiOperation(value = "分页条件查询资产结构与资源关系（深宝园-手动维护）列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "iotStructureResourceDTO", dataType = "IotStructureResourceDTO", required = false, value = "资产结构与资源关系（深宝园-手动维护）对象")})
    @GetMapping("/page/conditions")
    public R<IPage<IotStructureResourceVO>> queryPageByConditions(Page page, IotStructureResourceDTO iotStructureResourceDTO) {
        // 数据权限
        // iotStructureResourceDTO.setTenantId(CommonConverter.dataPermission(iotStructureResourceDTO.getTenantId()));
        return R.ok(iiotStructureResourceService.queryPageByConditions(page, iotStructureResourceDTO));
    }

    /**
     * 数据权限：参数转换
     * 将 tenantId == 1 的系统租户,处理为无 tenantId 条件的情况 - 20.10.12
     * 提示1：若前端同事未提供tenantId参数,但tenantId又有可能作为有用参数,故需要入参进行处理
     * 提示2：此处对比的非租户类型 tenantType
     * 提示3：系统租户唯一性
     * 提示4：构建角色对应资产结构数据权限 - 2021.08.19
     *
     * @param iotStructureResourceDTO 入参
     * @return iotStructureResourceDTO 处理后的入参
     */
    private IotStructureResourceDTO dealParam(IotStructureResourceDTO iotStructureResourceDTO) {
        // 第一层处理:当tenant不传的情况,直接从框架获取对应TenantId数据信息
        if (null == iotStructureResourceDTO.getTenantId()) {
            try {
                IotUser user = SecurityUtils.getUser();
                if (null != user.getTenantId()) {
                    iotStructureResourceDTO.setTenantId(user.getTenantId());
                }
                // 构建角色资产结构数据权限 - 2021.08.19
                // if (null != user.getRoleId()){
                // iotStructureResourceDTO.setAssertIdList(DataScopeComponent.assemblyParam(user.getRoleId()));
                // }
            } catch (Exception e) {
                e.printStackTrace();
                log.info("当前用户登录权限信息获取异常......");
            }
        }
        // 第二层处理:tenant是超级管理员的情况,移除租户边界限制,查询所有
        if (iotStructureResourceDTO.getTenantId() == 1) {
            iotStructureResourceDTO.setTenantId(null);
        }
        return iotStructureResourceDTO;
    }


}
