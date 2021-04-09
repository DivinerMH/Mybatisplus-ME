package com.linksame.iot.meeting.service;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.iot.meeting.entity.IotMeeting;
import com.linksame.iot.meeting.vo.IotMeetingVO;
import com.linksame.iot.meeting.dto.IotMeetingDTO;

import java.util.List;

/**
 * 会议信息(IotMeeting)表服务接口
 *
 * @author menghuan
 * @since 2021-03-31 17:33:08
 */
public interface IIotMeetingService extends IService<IotMeeting> {

    /**
     * 新增会议信息
     *
     * @param iotMeetingDTO 会议信息接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveIotMeeting(IotMeetingDTO iotMeetingDTO);

    /**
     * 根据id（逻辑）删除会议信息
     *
     * @param id 会议信息id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteIotMeeting(Integer id);

    /**
     * 修改会议信息
     *
     * @param iotMeetingDTO 会议信息接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateIotMeeting(IotMeetingDTO iotMeetingDTO);

    /**
     * 根据id查询会议信息详情（单服务）
     *
     * @param id 会议信息id
     * @return 会议信息展示对象
     */
    IotMeetingVO queryIotMeeting(Integer id);

    /**
     * 根据id查询会议信息详情(跨服务)
     *
     * @param id 会议信息id
     * @return 会议信息展示对象
     */
    IotMeetingVO queryIotMeetingDetail(Integer id);

    /**
     * 无参查询查询会议信息列表
     *
     * @return 会议信息展示对象集合IotMeetingVOList
     */
    List<IotMeetingVO> queryIotMeetingList();

    /**
     * 条件查询查询会议信息列表
     *
     * @param iotMeetingDTO 会议信息接收入参DTO
     * @return 会议信息展示对象集合IotMeetingVOList
     */
    List<IotMeetingVO> queryListByConditions(IotMeetingDTO iotMeetingDTO);

    /**
     * 分页查询查询会议信息列表
     *
     * @param iotMeetingDTO 会议信息接收入参DTO
     * @return 会议信息展示对象集合IotMeetingVOList
     */
    IPage<IotMeetingVO> queryPageByConditions(Page page, IotMeetingDTO iotMeetingDTO);

}
