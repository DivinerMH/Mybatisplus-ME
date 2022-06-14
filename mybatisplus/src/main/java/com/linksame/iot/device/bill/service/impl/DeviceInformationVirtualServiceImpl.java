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
import com.linksame.iot.device.bill.entity.DeviceInformationVirtual;
import com.linksame.iot.device.bill.vo.DeviceInformationVirtualVO;
import com.linksame.iot.device.bill.dto.DeviceInformationVirtualDTO;
import com.linksame.iot.device.bill.mapper.DeviceInformationVirtualMapper;
import com.linksame.iot.device.bill.service.IDeviceInformationVirtualService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 虚拟设备台账表(DeviceInformationVirtual)表服务实现类
 *
 * @author menghuan
 * @since 2022-04-11 16:24:28
 */
@AllArgsConstructor
@Service
@Slf4j
public class DeviceInformationVirtualServiceImpl extends ServiceImpl<DeviceInformationVirtualMapper, DeviceInformationVirtual> implements IDeviceInformationVirtualService {

    private final DeviceInformationVirtualMapper deviceInformationVirtualMapper;

    @Override
    public Boolean saveDeviceInformationVirtual(DeviceInformationVirtualDTO deviceInformationVirtualDTO) {
        // 校验：名称是否重复
        checkNameUnity(deviceInformationVirtualDTO);
        // 业务逻辑
        DeviceInformationVirtual deviceInformationVirtual = new DeviceInformationVirtual();
        BeanUtils.copyProperties(deviceInformationVirtualDTO, deviceInformationVirtual);
        deviceInformationVirtual.setStatus(CommonConstants.STATUS_NORMAL);
        deviceInformationVirtual.setDelFlag(CommonConstants.STATUS_NORMAL);
        deviceInformationVirtual.setCreateTime(LocalDateTime.now());
        deviceInformationVirtual.setUpdateTime(deviceInformationVirtual.getCreateTime());
        baseMapper.insert(deviceInformationVirtual);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteDeviceInformationVirtual(Integer id) {
        // 校验：资源是否存在
        checkResource(id);
        // 业务逻辑
        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateDeviceInformationVirtual(DeviceInformationVirtualDTO deviceInformationVirtualDTO) {
        // 校验：名称是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(deviceInformationVirtualDTO.getName())) {
            checkNameUnity(deviceInformationVirtualDTO);
        }
        // 业务逻辑
        DeviceInformationVirtual deviceInformationVirtual = new DeviceInformationVirtual();
        BeanUtils.copyProperties(deviceInformationVirtualDTO, deviceInformationVirtual);
        deviceInformationVirtual.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(deviceInformationVirtual);
        return Boolean.TRUE;
    }

    @Override
    public DeviceInformationVirtualVO queryDeviceInformationVirtual(Integer id) {
        DeviceInformationVirtual deviceInformationVirtual = deviceInformationVirtualMapper.selectById(id);
        if (null == deviceInformationVirtual) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        DeviceInformationVirtualVO deviceInformationVirtualVO = new DeviceInformationVirtualVO();
        BeanUtils.copyProperties(deviceInformationVirtual, deviceInformationVirtualVO);
        return deviceInformationVirtualVO;
    }

    @Override
    public DeviceInformationVirtualVO queryDeviceInformationVirtualDetail(Integer id) {
        DeviceInformationVirtualVO deviceInformationVirtualVO = deviceInformationVirtualMapper.queryDeviceInformationVirtualDetail(id);
        if (null == deviceInformationVirtualVO) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return deviceInformationVirtualVO;
    }

    @Override
    public List<DeviceInformationVirtualVO> queryDeviceInformationVirtualList() {
        List<DeviceInformationVirtualVO> deviceInformationVirtualVOS = deviceInformationVirtualMapper.queryDeviceInformationVirtualList();
        return deviceInformationVirtualVOS;
    }

    @Override
    public List<DeviceInformationVirtualVO> queryListByConditions(DeviceInformationVirtualDTO deviceInformationVirtualDTO) {
        List<DeviceInformationVirtualVO> deviceInformationVirtualVOS = deviceInformationVirtualMapper.queryByConditions(deviceInformationVirtualDTO);
        return deviceInformationVirtualVOS;
    }

    @Override
    public IPage<DeviceInformationVirtualVO> queryPageByConditions(Page page, DeviceInformationVirtualDTO deviceInformationVirtualDTO) {
        IPage<DeviceInformationVirtualVO> deviceInformationVirtualVOIPage = deviceInformationVirtualMapper.queryByConditions(page, deviceInformationVirtualDTO);
        return deviceInformationVirtualVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        DeviceInformationVirtual deviceInformationVirtual = baseMapper.selectById(id);
        if (null == deviceInformationVirtual) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
    }

    /**
     * 校验：新增 / 修改 name 是否重复【多租户版本】
     * 提示：新增时，id请传入为 null，
     * 修改时，id传入相应值，以排除自身数据
     */
    private void checkNameUnity(DeviceInformationVirtualDTO deviceInformationVirtualDTO) {
        // 使用 .ne() 排除自身重复的情况
        LambdaQueryWrapper<DeviceInformationVirtual> queryWrapper =
                Wrappers.<DeviceInformationVirtual>lambdaQuery()
                        // .eq(null != DeviceInformationVirtualDTO.getTenantId(), DeviceInformationVirtual::getTenantId, DeviceInformationVirtualDTO.getTenantId())
                        .eq(StringUtils.isNotEmpty(deviceInformationVirtualDTO.getName()), DeviceInformationVirtual::getName, deviceInformationVirtualDTO.getName())
                        .ne(null != deviceInformationVirtualDTO.getId(), DeviceInformationVirtual::getId, deviceInformationVirtualDTO.getId());
        List<DeviceInformationVirtual> deviceInformationVirtualList = baseMapper.selectList(queryWrapper);
        if (null != deviceInformationVirtualList && !deviceInformationVirtualList.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

}
