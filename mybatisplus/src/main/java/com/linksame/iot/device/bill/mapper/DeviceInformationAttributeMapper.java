package com.linksame.iot.device.bill.mapper;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.device.bill.entity.DeviceInformationAttribute;
import com.linksame.iot.device.bill.vo.DeviceInformationAttributeVO;
import com.linksame.iot.device.bill.dto.DeviceInformationAttributeDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 虚拟设备台账属性表(DeviceInformationAttribute)数据库访问层
 *
 * @author menghuan
 * @since 2022-04-11 16:24:00
 */
@Mapper
public interface DeviceInformationAttributeMapper extends BaseMapper<DeviceInformationAttribute> {

    /**
     * 根据id查询虚拟设备台账属性表详情(多服务)
     *
     * @param id 虚拟设备台账属性表id
     * @return 虚拟设备台账属性表展示对象DeviceInformationAttributeVO
     */
    DeviceInformationAttributeVO queryDeviceInformationAttributeDetail(@Param("id") Integer id);

    /**
     * 无参查询虚拟设备台账属性表List
     *
     * @return 虚拟设备台账属性表展示对象集合DeviceInformationAttributeVOList
     */
    List<DeviceInformationAttributeVO> queryDeviceInformationAttributeList();

    /**
     * 条件查询虚拟设备台账属性表List
     *
     * @param deviceInformationAttributeDTO 虚拟设备台账属性表接收入参DTO
     * @return 虚拟设备台账属性表展示对象集合DeviceInformationAttributeVOList
     */
    List<DeviceInformationAttributeVO> queryByConditions(@Param("deviceInformationAttributeDTO") DeviceInformationAttributeDTO deviceInformationAttributeDTO);

    /**
     * 分页条件查询虚拟设备台账属性表Page
     *
     * @param page                          分页参数
     * @param deviceInformationAttributeDTO 虚拟设备台账属性表接收入参DTO
     * @return 虚拟设备台账属性表展示对象集合DeviceInformationAttributeVOList
     */
    IPage<DeviceInformationAttributeVO> queryByConditions(@Param("page") Page page, @Param("deviceInformationAttributeDTO") DeviceInformationAttributeDTO deviceInformationAttributeDTO);

}
