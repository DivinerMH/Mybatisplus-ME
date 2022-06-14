package com.linksame.iot.device.bill.mapper;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.device.bill.entity.DeviceInformationVirtual;
import com.linksame.iot.device.bill.vo.DeviceInformationVirtualVO;
import com.linksame.iot.device.bill.dto.DeviceInformationVirtualDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 虚拟设备台账表(DeviceInformationVirtual)数据库访问层
 *
 * @author menghuan
 * @since 2022-04-11 16:24:28
 */
@Mapper
public interface DeviceInformationVirtualMapper extends BaseMapper<DeviceInformationVirtual> {

    /**
     * 根据id查询虚拟设备台账表详情(多服务)
     *
     * @param id 虚拟设备台账表id
     * @return 虚拟设备台账表展示对象DeviceInformationVirtualVO
     */
    DeviceInformationVirtualVO queryDeviceInformationVirtualDetail(@Param("id") Integer id);

    /**
     * 无参查询虚拟设备台账表List
     *
     * @return 虚拟设备台账表展示对象集合DeviceInformationVirtualVOList
     */
    List<DeviceInformationVirtualVO> queryDeviceInformationVirtualList();

    /**
     * 条件查询虚拟设备台账表List
     *
     * @param deviceInformationVirtualDTO 虚拟设备台账表接收入参DTO
     * @return 虚拟设备台账表展示对象集合DeviceInformationVirtualVOList
     */
    List<DeviceInformationVirtualVO> queryByConditions(@Param("deviceInformationVirtualDTO") DeviceInformationVirtualDTO deviceInformationVirtualDTO);

    /**
     * 分页条件查询虚拟设备台账表Page
     *
     * @param page                        分页参数
     * @param deviceInformationVirtualDTO 虚拟设备台账表接收入参DTO
     * @return 虚拟设备台账表展示对象集合DeviceInformationVirtualVOList
     */
    IPage<DeviceInformationVirtualVO> queryByConditions(@Param("page") Page page, @Param("deviceInformationVirtualDTO") DeviceInformationVirtualDTO deviceInformationVirtualDTO);

}
