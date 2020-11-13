package com.hzcloud.iot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzcloud.iot.common.core.util.R;
import com.hzcloud.iot.dto.DangerNodeDTO;
import com.hzcloud.iot.service.IDangerNodeService;
import com.hzcloud.iot.utils.BusinessEnum;
import com.hzcloud.iot.vo.DangerNodeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 巡检节点(DangerNode)表控制层
 *
 * @author MH
 * @since 2020-11-13 15:17:26
 */
@AllArgsConstructor
@RestController
@RequestMapping("/dangerNode")
@Api(value = "DangerNode", tags = "巡检节点模块")
public class DangerNodeController {

    /**
     * 服务对象
     */
    private final IDangerNodeService idangerNodeService;

    /**
     * 新增巡检节点
     *
     * @param dangerNodeDTO 巡检节点接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增巡检节点")
    @ApiOperation(value = "新增巡检节点")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "dangerNodeDTO", dataType = "DangerNodeDTO", required = true, value = "巡检节点对象")})
    @PostMapping
    public R<Boolean> saveDangerNode(@RequestBody DangerNodeDTO dangerNodeDTO) {
        return R.ok(idangerNodeService.saveDangerNode(dangerNodeDTO));
    }

    /**
     * 根据id（逻辑）删除巡检节点
     *
     * @param id 巡检节点id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除巡检节点")
    @ApiOperation(value = "根据id（逻辑）删除巡检节点")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "巡检节点id"))
    public R<Boolean> deleteDangerNode(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(idangerNodeService.deleteDangerNode(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改巡检节点
     *
     * @param dangerNodeDTO 巡检节点接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改巡检节点")
    @ApiOperation(value = "修改巡检节点")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "dangerNodeDTO", dataType = "DangerNodeDTO", required = true, value = "巡检节点对象")})
    @PutMapping
    public R<Boolean> updateDangerNode(@RequestBody DangerNodeDTO dangerNodeDTO) {
        return R.ok(idangerNodeService.updateDangerNode(dangerNodeDTO));
    }

    /**
     * 根据id查询巡检节点详情（单服务）
     *
     * @param id 巡检节点id
     * @return 巡检节点展示对象DangerNodeVO
     */
    @ApiOperation(value = "根据id查询巡检节点详情")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "巡检节点id"))
    public R<DangerNodeVO> queryDangerNode(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(idangerNodeService.queryDangerNode(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询巡检节点详情(跨服务)
     *
     * @param id 巡检节点id
     * @return 巡检节点展示对象DangerNodeVO
     */
    @ApiOperation(value = "根据id查询巡检节点详情(跨服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "巡检节点id"))
    public R<DangerNodeVO> queryDangerNodeDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(idangerNodeService.queryDangerNodeDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询巡检节点列表
     *
     * @return 巡检节点展示对象集合DangerNodeVOList
     */
    @ApiOperation(value = "无参查询巡检节点列表")
    @GetMapping("/lists")
    public R<List<DangerNodeVO>> queryDangerNodeList() {
        return R.ok(idangerNodeService.queryDangerNodeList());
    }

    /**
     * 条件查询巡检节点列表
     *
     * @param dangerNodeDTO 巡检节点接收入参DTO
     * @return 巡检节点展示对象集合DangerNodeVOList
     */
    @ApiOperation(value = "条件查询巡检节点列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "dangerNodeDTO", dataType = "DangerNodeDTO", required = false, value = "巡检节点对象")})
    @GetMapping("/lists/conditions")
    public R<List<DangerNodeVO>> queryListByConditions(DangerNodeDTO dangerNodeDTO) {
        return R.ok(idangerNodeService.queryListByConditions(dangerNodeDTO));
    }

    /**
     * 分页查询查询巡检节点列表
     *
     * @param dangerNodeDTO 巡检节点接收入参DTO
     * @return 巡检节点展示对象集合DangerNodeVOList
     */
    @ApiOperation(value = "分页查询查询巡检节点列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "dangerNodeDTO", dataType = "DangerNodeDTO", required = false, value = "巡检节点对象")})
    @GetMapping("/page/conditions")
    public R<IPage<DangerNodeVO>> queryPageByConditions(Page page, DangerNodeDTO dangerNodeDTO) {
        return R.ok(idangerNodeService.queryPageByConditions(page, dangerNodeDTO));
    }


}