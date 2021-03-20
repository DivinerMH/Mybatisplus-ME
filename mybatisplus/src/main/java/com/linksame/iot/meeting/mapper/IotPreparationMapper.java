package com.linksame.iot.meeting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.meeting.dto.IotPreparationDTO;
import com.linksame.iot.meeting.entity.IotPreparation;
import com.linksame.iot.meeting.vo.IotPreparationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会议准备(IotPreparation)数据库访问层
 *
 * @author menghuan
 * @since 2021-03-20 16:30:00
 */
@Mapper
public interface IotPreparationMapper extends BaseMapper<IotPreparation> {

    /**
     * 根据id查询会议准备详情(跨服务)
     *
     * @param id 会议准备id
     * @return 会议准备展示对象IotPreparationVO
     */
    IotPreparationVO queryIotPreparationDetail(@Param("id") Integer id);

    /**
     * 无参查询会议准备List
     *
     * @return 资会议准备展示对象集合IotPreparationVOList
     */
    List<IotPreparationVO> queryIotPreparationList();

    /**
     * 条件查询会议准备List
     *
     * @param iotPreparationDTO 会议准备接收入参DTO
     * @return 会议准备展示对象集合IotPreparationVOList
     */
    List<IotPreparationVO> queryByConditions(@Param("iotPreparationDTO") IotPreparationDTO iotPreparationDTO);

    /**
     * 条件查询会议准备Page
     *
     * @param page              分页参数
     * @param iotPreparationDTO 会议准备接收入参DTO
     * @return 会议准备展示对象集合IotPreparationVOList
     */
    IPage<IotPreparationVO> queryByConditions(@Param("page") Page page, @Param("iotPreparationDTO") IotPreparationDTO iotPreparationDTO);

}