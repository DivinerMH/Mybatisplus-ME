package com.linksame.iot.meeting.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.meeting.common.core.util.R;
import com.linksame.iot.meeting.dto.IotPreparationDTO;
import com.linksame.iot.meeting.service.IIotPreparationService;
import com.linksame.iot.meeting.vo.IotPreparationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会议准备(IotPreparation)表控制层
 *
 * @author menghuan
 * @since 2021-03-20 16:30:02
 */
@AllArgsConstructor
@RestController
@RequestMapping("/iotPreparation")
@Api(value = "IotPreparation", tags = "会议准备模块")
public class IotPreparationController {

    /**
     * 服务对象
     */
    private final IIotPreparationService iiotPreparationService;

    /**
     * 新增会议准备
     *
     * @param iotPreparationDTO 会议准备接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增会议准备")
    @ApiOperation(value = "新增会议准备")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotPreparationDTO", dataType = "IotPreparationDTO", required = true, value = "会议准备对象")})
    @PostMapping
    public R<Boolean> saveIotPreparation(@RequestBody IotPreparationDTO iotPreparationDTO) {
        return R.ok(iiotPreparationService.saveIotPreparation(iotPreparationDTO));
    }

    /**
     * 根据id（逻辑）删除会议准备
     *
     * @param id 会议准备id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除会议准备")
    @ApiOperation(value = "根据id（逻辑）删除会议准备")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "会议准备id"))
    public R<Boolean> deleteIotPreparation(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotPreparationService.deleteIotPreparation(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改会议准备
     *
     * @param iotPreparationDTO 会议准备接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改会议准备")
    @ApiOperation(value = "修改会议准备")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotPreparationDTO", dataType = "IotPreparationDTO", required = true, value = "会议准备对象")})
    @PutMapping
    public R<Boolean> updateIotPreparation(@RequestBody IotPreparationDTO iotPreparationDTO) {
        return R.ok(iiotPreparationService.updateIotPreparation(iotPreparationDTO));
    }

    /**
     * 根据id查询会议准备详情（单服务）
     *
     * @param id 会议准备id
     * @return 会议准备展示对象IotPreparationVO
     */
    @ApiOperation(value = "根据id查询会议准备详情")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "会议准备id"))
    public R<IotPreparationVO> queryIotPreparation(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotPreparationService.queryIotPreparation(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询会议准备详情(跨服务)
     *
     * @param id 会议准备id
     * @return 会议准备展示对象IotPreparationVO
     */
    @ApiOperation(value = "根据id查询会议准备详情(跨服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "会议准备id"))
    public R<IotPreparationVO> queryIotPreparationDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotPreparationService.queryIotPreparationDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询会议准备列表
     *
     * @return 会议准备展示对象集合IotPreparationVOList
     */
    @ApiOperation(value = "无参查询会议准备列表")
    @GetMapping("/lists")
    public R<List<IotPreparationVO>> queryIotPreparationList() {
        return R.ok(iiotPreparationService.queryIotPreparationList());
    }

    /**
     * 条件查询会议准备列表
     *
     * @param iotPreparationDTO 会议准备接收入参DTO
     * @return 会议准备展示对象集合IotPreparationVOList
     */
    @ApiOperation(value = "条件查询会议准备列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotPreparationDTO", dataType = "IotPreparationDTO", required = false, value = "会议准备对象")})
    @GetMapping("/lists/conditions")
    public R<List<IotPreparationVO>> queryListByConditions(IotPreparationDTO iotPreparationDTO) {
        return R.ok(iiotPreparationService.queryListByConditions(iotPreparationDTO));
    }

    /**
     * 分页查询查询会议准备列表
     *
     * @param iotPreparationDTO 会议准备接收入参DTO
     * @return 会议准备展示对象集合IotPreparationVOList
     */
    @ApiOperation(value = "分页查询查询会议准备列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "iotPreparationDTO", dataType = "IotPreparationDTO", required = false, value = "会议准备对象")})
    @GetMapping("/page/conditions")
    public R<IPage<IotPreparationVO>> queryPageByConditions(Page page, IotPreparationDTO iotPreparationDTO) {
        return R.ok(iiotPreparationService.queryPageByConditions(page, iotPreparationDTO));
    }


}