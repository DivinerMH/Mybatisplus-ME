package com.linksame.iot.device.bill.service.impl;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.linksame.iot.device.bill.entity.DeviceInformationAttribute;
import com.linksame.iot.device.bill.vo.DeviceInformationAttributeVO;
import com.linksame.iot.device.bill.dto.DeviceInformationAttributeDTO;
import com.linksame.iot.device.bill.mapper.DeviceInformationAttributeMapper;
import com.linksame.iot.device.bill.service.IDeviceInformationAttributeService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 虚拟设备台账属性表(DeviceInformationAttribute)表服务实现类
 *
 * @author menghuan
 * @since 2022-04-11 16:24:01
 */
@AllArgsConstructor
@Service
@Slf4j
public class DeviceInformationAttributeServiceImpl extends ServiceImpl<DeviceInformationAttributeMapper, DeviceInformationAttribute> implements IDeviceInformationAttributeService {

    private final DeviceInformationAttributeMapper deviceInformationAttributeMapper;

    @Override
    public Boolean saveDeviceInformationAttribute(DeviceInformationAttributeDTO deviceInformationAttributeDTO) {
        // 校验：名称是否重复
        checkNameUnity(deviceInformationAttributeDTO);
        // 业务逻辑
        DeviceInformationAttribute deviceInformationAttribute = new DeviceInformationAttribute();
        BeanUtils.copyProperties(deviceInformationAttributeDTO, deviceInformationAttribute);
        deviceInformationAttribute.setStatus(CommonConstants.STATUS_NORMAL);
        deviceInformationAttribute.setDelFlag(CommonConstants.STATUS_NORMAL);
        deviceInformationAttribute.setCreateTime(LocalDateTime.now());
        deviceInformationAttribute.setUpdateTime(deviceInformationAttribute.getCreateTime());
        baseMapper.insert(deviceInformationAttribute);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteDeviceInformationAttribute(Integer id) {
        // 校验：资源是否存在
        checkResource(id);
        // 业务逻辑
        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateDeviceInformationAttribute(DeviceInformationAttributeDTO deviceInformationAttributeDTO) {
        // 校验：名称是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(deviceInformationAttributeDTO.getName())) {
            checkNameUnity(deviceInformationAttributeDTO);
        }
        // 业务逻辑
        DeviceInformationAttribute deviceInformationAttribute = new DeviceInformationAttribute();
        BeanUtils.copyProperties(deviceInformationAttributeDTO, deviceInformationAttribute);
        deviceInformationAttribute.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(deviceInformationAttribute);
        return Boolean.TRUE;
    }

    @Override
    public DeviceInformationAttributeVO queryDeviceInformationAttribute(Integer id) {
        DeviceInformationAttribute deviceInformationAttribute = deviceInformationAttributeMapper.selectById(id);
        if (null == deviceInformationAttribute) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        DeviceInformationAttributeVO deviceInformationAttributeVO = new DeviceInformationAttributeVO();
        BeanUtils.copyProperties(deviceInformationAttribute, deviceInformationAttributeVO);
        return deviceInformationAttributeVO;
    }

    @Override
    public DeviceInformationAttributeVO queryDeviceInformationAttributeDetail(Integer id) {
        DeviceInformationAttributeVO deviceInformationAttributeVO = deviceInformationAttributeMapper.queryDeviceInformationAttributeDetail(id);
        if (null == deviceInformationAttributeVO) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return deviceInformationAttributeVO;
    }

    @Override
    public List<DeviceInformationAttributeVO> queryDeviceInformationAttributeList() {
        List<DeviceInformationAttributeVO> deviceInformationAttributeVOS = deviceInformationAttributeMapper.queryDeviceInformationAttributeList();
        return deviceInformationAttributeVOS;
    }

    @Override
    public List<DeviceInformationAttributeVO> queryListByConditions(DeviceInformationAttributeDTO deviceInformationAttributeDTO) {
        List<DeviceInformationAttributeVO> deviceInformationAttributeVOS = deviceInformationAttributeMapper.queryByConditions(deviceInformationAttributeDTO);
        return deviceInformationAttributeVOS;
    }

    @Override
    public IPage<DeviceInformationAttributeVO> queryPageByConditions(Page page, DeviceInformationAttributeDTO deviceInformationAttributeDTO) {
        IPage<DeviceInformationAttributeVO> deviceInformationAttributeVOIPage = deviceInformationAttributeMapper.queryByConditions(page, deviceInformationAttributeDTO);
        return deviceInformationAttributeVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        DeviceInformationAttribute deviceInformationAttribute = baseMapper.selectById(id);
        if (null == deviceInformationAttribute) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
    }

    /**
     * 校验：新增 / 修改 name 是否重复【多租户版本】
     * 提示：新增时，id请传入为 null，
     * 修改时，id传入相应值，以排除自身数据
     */
    private void checkNameUnity(DeviceInformationAttributeDTO deviceInformationAttributeDTO) {
        // 使用 .ne() 排除自身重复的情况
        LambdaQueryWrapper<DeviceInformationAttribute> queryWrapper =
                Wrappers.<DeviceInformationAttribute>lambdaQuery()
                        // .eq(null != DeviceInformationAttributeDTO.getTenantId(), DeviceInformationAttribute::getTenantId, DeviceInformationAttributeDTO.getTenantId())
                        .eq(StringUtils.isNotEmpty(deviceInformationAttributeDTO.getName()), DeviceInformationAttribute::getName, deviceInformationAttributeDTO.getName())
                        .ne(null != deviceInformationAttributeDTO.getId(), DeviceInformationAttribute::getId, deviceInformationAttributeDTO.getId());
        List<DeviceInformationAttribute> deviceInformationAttributeList = baseMapper.selectList(queryWrapper);
        if (null != deviceInformationAttributeList && !deviceInformationAttributeList.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

}
