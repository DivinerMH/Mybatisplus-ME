package com.linksame.iot.meeting.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.iot.meeting.dto.IotPreparationDTO;
import com.linksame.iot.meeting.entity.IotPreparation;
import com.linksame.iot.meeting.vo.IotPreparationVO;

import java.util.List;

/**
 * 会议准备(IotPreparation)表服务接口
 *
 * @author menghuan
 * @since 2021-03-20 16:30:00
 */
public interface IIotPreparationService extends IService<IotPreparation> {

    /**
     * 新增会议准备
     *
     * @param iotPreparationDTO 会议准备接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveIotPreparation(IotPreparationDTO iotPreparationDTO);

    /**
     * 根据id（逻辑）删除会议准备
     *
     * @param id 会议准备id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteIotPreparation(Integer id);

    /**
     * 修改会议准备
     *
     * @param iotPreparationDTO 会议准备接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateIotPreparation(IotPreparationDTO iotPreparationDTO);

    /**
     * 根据id查询会议准备详情（单服务）
     *
     * @param id 会议准备id
     * @return 会议准备展示对象
     */
    IotPreparationVO queryIotPreparation(Integer id);

    /**
     * 根据id查询会议准备详情(跨服务)
     *
     * @param id 会议准备id
     * @return 会议准备展示对象
     */
    IotPreparationVO queryIotPreparationDetail(Integer id);

    /**
     * 无参查询查询会议准备列表
     *
     * @return 会议准备展示对象集合IotPreparationVOList
     */
    List<IotPreparationVO> queryIotPreparationList();

    /**
     * 条件查询查询会议准备列表
     *
     * @param iotPreparationDTO 会议准备接收入参DTO
     * @return 会议准备展示对象集合IotPreparationVOList
     */
    List<IotPreparationVO> queryListByConditions(IotPreparationDTO iotPreparationDTO);

    /**
     * 分页查询查询会议准备列表
     *
     * @param iotPreparationDTO 会议准备接收入参DTO
     * @return 会议准备展示对象集合IotPreparationVOList
     */
    IPage<IotPreparationVO> queryPageByConditions(Page page, IotPreparationDTO iotPreparationDTO);

}