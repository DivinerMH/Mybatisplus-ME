package com.linksame.iot.device.bill.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.iot.device.bill.dto.DeviceInformationVirtualDTO;
import com.linksame.iot.device.bill.entity.DeviceInformationVirtual;
import com.linksame.iot.device.bill.vo.DeviceInformationVirtualVO;

import java.util.List;

/**
 * 虚拟设备台账表(DeviceInformationVirtual)表服务接口
 *
 * @author menghuan
 * @since 2022-04-11 16:24:28
 */
public interface IDeviceInformationVirtualService extends IService<DeviceInformationVirtual> {

    /**
     * 新增虚拟设备台账表
     *
     * @param deviceInformationVirtualDTO 虚拟设备台账表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveDeviceInformationVirtual(DeviceInformationVirtualDTO deviceInformationVirtualDTO);

    /**
     * 根据id（逻辑）删除虚拟设备台账表
     *
     * @param id 虚拟设备台账表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteDeviceInformationVirtual(Integer id);

    /**
     * 修改虚拟设备台账表
     *
     * @param deviceInformationVirtualDTO 虚拟设备台账表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateDeviceInformationVirtual(DeviceInformationVirtualDTO deviceInformationVirtualDTO);

    /**
     * 根据id查询虚拟设备台账表详情(单服务)
     *
     * @param id 虚拟设备台账表id
     * @return 虚拟设备台账表展示对象
     */
    DeviceInformationVirtualVO queryDeviceInformationVirtual(Integer id);

    /**
     * 根据id查询虚拟设备台账表详情(多服务)
     *
     * @param id 虚拟设备台账表id
     * @return 虚拟设备台账表展示对象
     */
    DeviceInformationVirtualVO queryDeviceInformationVirtualDetail(Integer id);

    /**
     * 无参查询虚拟设备台账表列表
     *
     * @return 虚拟设备台账表展示对象集合DeviceInformationVirtualVOList
     */
    List<DeviceInformationVirtualVO> queryDeviceInformationVirtualList();

    /**
     * 条件查询虚拟设备台账表列表
     *
     * @param deviceInformationVirtualDTO 虚拟设备台账表接收入参DTO
     * @return 虚拟设备台账表展示对象集合DeviceInformationVirtualVOList
     */
    List<DeviceInformationVirtualVO> queryListByConditions(DeviceInformationVirtualDTO deviceInformationVirtualDTO);

    /**
     * 分页条件查询虚拟设备台账表列表
     *
     * @param deviceInformationVirtualDTO 虚拟设备台账表接收入参DTO
     * @return 虚拟设备台账表展示对象集合DeviceInformationVirtualVOList
     */
    IPage<DeviceInformationVirtualVO> queryPageByConditions(Page page, DeviceInformationVirtualDTO deviceInformationVirtualDTO);

}
