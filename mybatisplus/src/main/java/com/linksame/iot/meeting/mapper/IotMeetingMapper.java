package com.linksame.iot.meeting.mapper;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.meeting.entity.IotMeeting;
import com.linksame.iot.meeting.vo.IotMeetingVO;
import com.linksame.iot.meeting.dto.IotMeetingDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 会议信息(IotMeeting)数据库访问层
 *
 * @author menghuan
 * @since 2021-03-31 17:33:06
 */
@Mapper
public interface IotMeetingMapper extends BaseMapper<IotMeeting> {

    /**
     * 根据id查询会议信息详情(跨服务)
     *
     * @param id 会议信息id
     * @return 会议信息展示对象IotMeetingVO
     */
    IotMeetingVO queryIotMeetingDetail(@Param("id") Integer id);

    /**
     * 无参查询会议信息List
     *
     * @return 资会议信息展示对象集合IotMeetingVOList
     */
    List<IotMeetingVO> queryIotMeetingList();

    /**
     * 条件查询会议信息List
     *
     * @param iotMeetingDTO 会议信息接收入参DTO
     * @return 会议信息展示对象集合IotMeetingVOList
     */
    List<IotMeetingVO> queryByConditions(@Param("iotMeetingDTO") IotMeetingDTO iotMeetingDTO);

    /**
     * 条件查询会议信息Page
     *
     * @param page          分页参数
     * @param iotMeetingDTO 会议信息接收入参DTO
     * @return 会议信息展示对象集合IotMeetingVOList
     */
    IPage<IotMeetingVO> queryByConditions(@Param("page") Page page, @Param("iotMeetingDTO") IotMeetingDTO iotMeetingDTO);

}
