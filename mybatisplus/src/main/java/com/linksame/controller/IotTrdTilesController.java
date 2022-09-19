package com.linksame.controller;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.linksame.iot.common.core.constant.enums.BusinessEnum;
import com.linksame.iot.common.core.util.R;
import com.linksame.iot.common.log.annotation.SysLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.entity.IotTrdTiles;
import com.linksame.vo.IotTrdTilesVO;
import com.linksame.dto.IotTrdTilesDTO;
import com.linksame.service.IIotTrdTilesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 3d-tiles 文件数据表(IotTrdTiles)表控制层
 *
 * @author menghuan
 * @since 2022-08-26 10:47:27
 */
@AllArgsConstructor
@RestController
@RequestMapping("/iotTrdTiles")
@Api(value = "IotTrdTiles", tags = "3d-tiles 文件数据表模块")
public class IotTrdTilesController {

    /**
     * 服务对象
     */
    private final IIotTrdTilesService iiotTrdTilesService;

    /**
     * 新增3d-tiles 文件数据表
     *
     * @param iotTrdTilesDTO 3d-tiles 文件数据表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增3d-tiles 文件数据表")
    @ApiOperation(value = "新增3d-tiles 文件数据表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotTrdTilesDTO", dataType = "IotTrdTilesDTO", required = true, value = "3d-tiles 文件数据表对象")})
    @PostMapping
    public R<Boolean> saveIotTrdTiles(@RequestBody IotTrdTilesDTO iotTrdTilesDTO) {
        return R.ok(iiotTrdTilesService.saveIotTrdTiles(iotTrdTilesDTO));
    }

    /**
     * 根据id（逻辑）删除3d-tiles 文件数据表
     *
     * @param id 3d-tiles 文件数据表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除3d-tiles 文件数据表")
    @ApiOperation(value = "根据id（逻辑）删除3d-tiles 文件数据表")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "3d-tiles 文件数据表id"))
    public R<Boolean> deleteIotTrdTiles(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotTrdTilesService.deleteIotTrdTiles(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改3d-tiles 文件数据表
     *
     * @param iotTrdTilesDTO 3d-tiles 文件数据表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改3d-tiles 文件数据表")
    @ApiOperation(value = "修改3d-tiles 文件数据表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotTrdTilesDTO", dataType = "IotTrdTilesDTO", required = true, value = "3d-tiles 文件数据表对象")})
    @PutMapping
    public R<Boolean> updateIotTrdTiles(@RequestBody IotTrdTilesDTO iotTrdTilesDTO) {
        return R.ok(iiotTrdTilesService.updateIotTrdTiles(iotTrdTilesDTO));
    }

    /**
     * 根据id查询3d-tiles 文件数据表详情(单服务)
     *
     * @param id 3d-tiles 文件数据表id
     * @return 3d-tiles 文件数据表展示对象IotTrdTilesVO
     */
    @ApiOperation(value = "根据id查询3d-tiles 文件数据表详情(单服务)")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "3d-tiles 文件数据表id"))
    public R<IotTrdTilesVO> queryIotTrdTiles(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotTrdTilesService.queryIotTrdTiles(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询3d-tiles 文件数据表详情(多服务)
     *
     * @param id 3d-tiles 文件数据表id
     * @return 3d-tiles 文件数据表展示对象IotTrdTilesVO
     */
    @ApiOperation(value = "根据id查询3d-tiles 文件数据表详情(多服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "3d-tiles 文件数据表id"))
    public R<IotTrdTilesVO> queryIotTrdTilesDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotTrdTilesService.queryIotTrdTilesDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询3d-tiles 文件数据表列表
     *
     * @return 3d-tiles 文件数据表展示对象集合IotTrdTilesVOList
     */
    @ApiOperation(value = "无参查询3d-tiles 文件数据表列表")
    @GetMapping("/lists")
    public R<List<IotTrdTilesVO>> queryIotTrdTilesList() {
        return R.ok(iiotTrdTilesService.queryIotTrdTilesList());
    }

    /**
     * 条件查询3d-tiles 文件数据表列表
     *
     * @param iotTrdTilesDTO 3d-tiles 文件数据表接收入参DTO
     * @return 3d-tiles 文件数据表展示对象集合IotTrdTilesVOList
     */
    @ApiOperation(value = "条件查询3d-tiles 文件数据表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotTrdTilesDTO", dataType = "IotTrdTilesDTO", required = false, value = "3d-tiles 文件数据表对象")})
    @PostMapping("/lists/conditions")
    public R<List<IotTrdTilesVO>> queryListByConditions(@RequestBody IotTrdTilesDTO iotTrdTilesDTO) {
        // 数据权限
        // iotTrdTilesDTO.setTenantId(CommonConverter.dataPermission(iotTrdTilesDTO.getTenantId()));
        return R.ok(iiotTrdTilesService.queryListByConditions(iotTrdTilesDTO));
    }

    /**
     * 分页条件查询3d-tiles 文件数据表列表
     *
     * @param iotTrdTilesDTO 3d-tiles 文件数据表接收入参DTO
     * @return 3d-tiles 文件数据表展示对象集合IotTrdTilesVOList
     */
    @ApiOperation(value = "分页条件查询3d-tiles 文件数据表列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "iotTrdTilesDTO", dataType = "IotTrdTilesDTO", required = false, value = "3d-tiles 文件数据表对象")})
    @GetMapping("/page/conditions")
    public R<IPage<IotTrdTilesVO>> queryPageByConditions(Page page, IotTrdTilesDTO iotTrdTilesDTO) {
        // 数据权限
        // iotTrdTilesDTO.setTenantId(CommonConverter.dataPermission(iotTrdTilesDTO.getTenantId()));
        return R.ok(iiotTrdTilesService.queryPageByConditions(page, iotTrdTilesDTO));
    }

    /**
     * 数据权限：参数转换
     * 将 tenantId == 1 的系统租户,处理为无 tenantId 条件的情况 - 20.10.12
     * 提示1：若前端同事未提供tenantId参数,但tenantId又有可能作为有用参数,故需要入参进行处理
     * 提示2：此处对比的非租户类型 tenantType
     * 提示3：系统租户唯一性
     * 提示4：构建角色对应资产结构数据权限 - 2021.08.19
     *
     * @param iotTrdTilesDTO 入参
     * @return iotTrdTilesDTO 处理后的入参
     */
    private IotTrdTilesDTO dealParam(IotTrdTilesDTO iotTrdTilesDTO) {
        // 第一层处理:当tenant不传的情况,直接从框架获取对应TenantId数据信息
        if (null == iotTrdTilesDTO.getTenantId()) {
            try {
                IotUser user = SecurityUtils.getUser();
                if (null != user.getTenantId()) {
                    iotTrdTilesDTO.setTenantId(user.getTenantId());
                }
                // 构建角色资产结构数据权限 - 2021.08.19
                // if (null != user.getRoleId()){
                // iotTrdTilesDTO.setAssertIdList(DataScopeComponent.assemblyParam(user.getRoleId()));
                // }
            } catch (Exception e) {
                e.printStackTrace();
                log.info("当前用户登录权限信息获取异常......");
            }
        }
        // 第二层处理:tenant是超级管理员的情况,移除租户边界限制,查询所有
        if (iotTrdTilesDTO.getTenantId() == 1) {
            iotTrdTilesDTO.setTenantId(null);
        }
        return iotTrdTilesDTO;
    }


}
