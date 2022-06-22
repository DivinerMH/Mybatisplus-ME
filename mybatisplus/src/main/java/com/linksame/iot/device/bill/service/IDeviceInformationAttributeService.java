package com.linksame.iot.device.bill.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.iot.device.bill.dto.DeviceInformationAttributeDTO;
import com.linksame.iot.device.bill.entity.DeviceInformationAttribute;
import com.linksame.iot.device.bill.vo.DeviceInformationAttributeVO;

import java.util.List;

/**
 * 虚拟设备台账属性表(DeviceInformationAttribute)表服务接口
 *
 * @author menghuan
 * @since 2022-04-11 16:24:00
 */
public interface IDeviceInformationAttributeService extends IService<DeviceInformationAttribute> {

    /**
     * 新增虚拟设备台账属性表
     *
     * @param deviceInformationAttributeDTO 虚拟设备台账属性表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveDeviceInformationAttribute(DeviceInformationAttributeDTO deviceInformationAttributeDTO);

    /**
     * 根据id（逻辑）删除虚拟设备台账属性表
     *
     * @param id 虚拟设备台账属性表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteDeviceInformationAttribute(Integer id);

    /**
     * 修改虚拟设备台账属性表
     *
     * @param deviceInformationAttributeDTO 虚拟设备台账属性表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateDeviceInformationAttribute(DeviceInformationAttributeDTO deviceInformationAttributeDTO);

    /**
     * 根据id查询虚拟设备台账属性表详情(单服务)
     *
     * @param id 虚拟设备台账属性表id
     * @return 虚拟设备台账属性表展示对象
     */
    DeviceInformationAttributeVO queryDeviceInformationAttribute(Integer id);

    /**
     * 根据id查询虚拟设备台账属性表详情(多服务)
     *
     * @param id 虚拟设备台账属性表id
     * @return 虚拟设备台账属性表展示对象
     */
    DeviceInformationAttributeVO queryDeviceInformationAttributeDetail(Integer id);

    /**
     * 无参查询虚拟设备台账属性表列表
     *
     * @return 虚拟设备台账属性表展示对象集合DeviceInformationAttributeVOList
     */
    List<DeviceInformationAttributeVO> queryDeviceInformationAttributeList();

    /**
     * 条件查询虚拟设备台账属性表列表
     *
     * @param deviceInformationAttributeDTO 虚拟设备台账属性表接收入参DTO
     * @return 虚拟设备台账属性表展示对象集合DeviceInformationAttributeVOList
     */
    List<DeviceInformationAttributeVO> queryListByConditions(DeviceInformationAttributeDTO deviceInformationAttributeDTO);

    /**
     * 分页条件查询虚拟设备台账属性表列表
     *
     * @param deviceInformationAttributeDTO 虚拟设备台账属性表接收入参DTO
     * @return 虚拟设备台账属性表展示对象集合DeviceInformationAttributeVOList
     */
    IPage<DeviceInformationAttributeVO> queryPageByConditions(Page page, DeviceInformationAttributeDTO deviceInformationAttributeDTO);

}
