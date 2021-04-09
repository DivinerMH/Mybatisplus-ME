package com.linksame.iot.meeting.controller;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.linksame.iot.meeting.common.core.util.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.meeting.entity.IotMeeting;
import com.linksame.iot.meeting.vo.IotMeetingVO;
import com.linksame.iot.meeting.dto.IotMeetingDTO;
import com.linksame.iot.meeting.service.IIotMeetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会议信息(IotMeeting)表控制层
 *
 * @author menghuan
 * @since 2021-03-31 17:33:09
 */
@AllArgsConstructor
@RestController
@RequestMapping("/iotMeeting")
@Api(value = "IotMeeting", tags = "会议信息模块")
public class IotMeetingController {

    /**
     * 服务对象
     */
    private final IIotMeetingService iiotMeetingService;

    /**
     * 新增会议信息
     *
     * @param iotMeetingDTO 会议信息接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("新增会议信息")
    @ApiOperation(value = "新增会议信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotMeetingDTO", dataType = "IotMeetingDTO", required = true, value = "会议信息对象")})
    @PostMapping
    public R<Boolean> saveIotMeeting(@RequestBody IotMeetingDTO iotMeetingDTO) {
        return R.ok(iiotMeetingService.saveIotMeeting(iotMeetingDTO));
    }

    /**
     * 根据id（逻辑）删除会议信息
     *
     * @param id 会议信息id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("根据id（逻辑）删除会议信息")
    @ApiOperation(value = "根据id（逻辑）删除会议信息")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "会议信息id"))
    public R<Boolean> deleteIotMeeting(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotMeetingService.deleteIotMeeting(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 修改会议信息
     *
     * @param iotMeetingDTO 会议信息接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("修改会议信息")
    @ApiOperation(value = "修改会议信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotMeetingDTO", dataType = "IotMeetingDTO", required = true, value = "会议信息对象")})
    @PutMapping
    public R<Boolean> updateIotMeeting(@RequestBody IotMeetingDTO iotMeetingDTO) {
        return R.ok(iiotMeetingService.updateIotMeeting(iotMeetingDTO));
    }

    /**
     * 根据id查询会议信息详情（单服务）
     *
     * @param id 会议信息id
     * @return 会议信息展示对象IotMeetingVO
     */
    @ApiOperation(value = "根据id查询会议信息详情")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "会议信息id"))
    public R<IotMeetingVO> queryIotMeeting(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotMeetingService.queryIotMeeting(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 根据id查询会议信息详情(跨服务)
     *
     * @param id 会议信息id
     * @return 会议信息展示对象IotMeetingVO
     */
    @ApiOperation(value = "根据id查询会议信息详情(跨服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "会议信息id"))
    public R<IotMeetingVO> queryIotMeetingDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotMeetingService.queryIotMeetingDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * 无参查询会议信息列表
     *
     * @return 会议信息展示对象集合IotMeetingVOList
     */
    @ApiOperation(value = "无参查询会议信息列表")
    @GetMapping("/lists")
    public R<List<IotMeetingVO>> queryIotMeetingList() {
        return R.ok(iiotMeetingService.queryIotMeetingList());
    }

    /**
     * 条件查询会议信息列表
     *
     * @param iotMeetingDTO 会议信息接收入参DTO
     * @return 会议信息展示对象集合IotMeetingVOList
     */
    @ApiOperation(value = "条件查询会议信息列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotMeetingDTO", dataType = "IotMeetingDTO", required = false, value = "会议信息对象")})
    @GetMapping("/lists/conditions")
    public R<List<IotMeetingVO>> queryListByConditions(IotMeetingDTO iotMeetingDTO) {
        return R.ok(iiotMeetingService.queryListByConditions(iotMeetingDTO));
    }

    /**
     * 分页查询查询会议信息列表
     *
     * @param iotMeetingDTO 会议信息接收入参DTO
     * @return 会议信息展示对象集合IotMeetingVOList
     */
    @ApiOperation(value = "分页查询查询会议信息列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "分页条件"),
            @ApiImplicitParam(paramType = "query", name = "iotMeetingDTO", dataType = "IotMeetingDTO", required = false, value = "会议信息对象")})
    @GetMapping("/page/conditions")
    public R<IPage<IotMeetingVO>> queryPageByConditions(Page page, IotMeetingDTO iotMeetingDTO) {
        return R.ok(iiotMeetingService.queryPageByConditions(page, iotMeetingDTO));
    }


}
