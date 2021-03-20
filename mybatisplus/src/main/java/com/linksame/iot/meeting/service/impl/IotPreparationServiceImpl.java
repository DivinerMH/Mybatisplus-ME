package com.linksame.iot.meeting.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linksame.iot.meeting.dto.IotPreparationDTO;
import com.linksame.iot.meeting.entity.IotPreparation;
import com.linksame.iot.meeting.mapper.IotPreparationMapper;
import com.linksame.iot.meeting.service.IIotPreparationService;
import com.linksame.iot.meeting.vo.IotPreparationVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 会议准备(IotPreparation)表服务实现类
 *
 * @author menghuan
 * @since 2021-03-20 16:30:01
 */
@AllArgsConstructor
@Service
@Slf4j
public class IotPreparationServiceImpl extends ServiceImpl<IotPreparationMapper, IotPreparation> implements IIotPreparationService {

    private final IotPreparationMapper iotPreparationMapper;

    @Override
    public Boolean saveIotPreparation(IotPreparationDTO iotPreparationDTO) {
        // 校验：name 是否重复
        checkNameUnity(iotPreparationDTO.getName());

        IotPreparation iotPreparation = new IotPreparation();
        BeanUtils.copyProperties(iotPreparationDTO, iotPreparation);
        iotPreparation.setStatus(CommonConstants.STATUS_NORMAL);
        iotPreparation.setDelFlag(CommonConstants.STATUS_NORMAL);
        iotPreparation.setCreateTime(LocalDateTime.now());
        iotPreparation.setUpdateTime(iotPreparation.getCreateTime());
        baseMapper.insert(iotPreparation);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteIotPreparation(Integer id) {
        // 校验：资源是否存在
        checkResource(id);

        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateIotPreparation(IotPreparationDTO iotPreparationDTO) {
        // 校验：name 是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(iotPreparationDTO.getName())) {
            checkNameUnity(iotPreparationDTO);
        }

        IotPreparation iotPreparation = new IotPreparation();
        BeanUtils.copyProperties(iotPreparationDTO, iotPreparation);
        iotPreparation.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(iotPreparation);
        return Boolean.TRUE;
    }

    @Override
    public IotPreparationVO queryIotPreparation(Integer id) {
        IotPreparation iotPreparation = iotPreparationMapper.selectById(id);
        if (null == iotPreparation) {
            throw new IotRepositoryException("应资源不存在,请核实后输入");
        }
        IotPreparationVO iotPreparationVO = new IotPreparationVO();
        BeanUtils.copyProperties(iotPreparation, iotPreparationVO);
        return iotPreparationVO;
    }

    @Override
    public IotPreparationVO queryIotPreparationDetail(Integer id) {
        IotPreparationVO iotPreparationVO = iotPreparationMapper.queryIotPreparationDetail(id);
        if (null == iotPreparationVO) {
            throw new IotRepositoryException("应资源不存在,请核实后输入");
        }
        return iotPreparationVO;
    }

    @Override
    public List<IotPreparationVO> queryIotPreparationList() {
        List<IotPreparationVO> iotPreparationVOS = iotPreparationMapper.queryIotPreparationList();
        return iotPreparationVOS;
    }

    @Override
    public List<IotPreparationVO> queryListByConditions(IotPreparationDTO iotPreparationDTO) {
        List<IotPreparationVO> iotPreparationVOS = iotPreparationMapper.queryByConditions(iotPreparationDTO);
        return iotPreparationVOS;
    }

    @Override
    public IPage<IotPreparationVO> queryPageByConditions(Page page, IotPreparationDTO iotPreparationDTO) {
        IPage<IotPreparationVO> iotPreparationVOIPage = iotPreparationMapper.queryByConditions(page, iotPreparationDTO);
        return iotPreparationVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        IotPreparation iotPreparation = baseMapper.selectById(id);
        if (null == iotPreparation) {
            throw new IotRepositoryException("应资源不存在,请核实后输入");
        }
    }

    // 校验：name 是否重复
    private void checkNameUnity(String name) {
        LambdaQueryWrapper<IotPreparation> queryWrapper =
                Wrappers.<IotPreparation>lambdaQuery()
                        .eq(StringUtils.isNotEmpty(name), IotPreparation::getName, name);
        List<IotPreparation> iotPreparations = baseMapper.selectList(queryWrapper);
        if (null != iotPreparations && !iotPreparations.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

    // 校验：name 是否重复（修改时,排除自身重复的情况）
    private void checkNameUnity(IotPreparationDTO iotPreparationDTO) {
        LambdaQueryWrapper<IotPreparation> queryWrapper =
                Wrappers.<IotPreparation>lambdaQuery()
                        .eq(StringUtils.isNotEmpty(iotPreparationDTO.getName()), IotPreparation::getName, iotPreparationDTO.getName());
        List<IotPreparation> iotPreparationList = baseMapper.selectList(queryWrapper);
        // 排除自身重复的情况
        if (null != iotPreparationList && !iotPreparationList.isEmpty()) {
            for (IotPreparation iotPreparation : iotPreparationList) {
                // 若非修改自身且名称还存在重复，则抛出异常
                if (!iotPreparation.getId().equals(iotPreparationDTO.getId()) && iotPreparation.getName().equals(iotPreparationDTO.getName())) {
                    throw new IotRepositoryException("名称已存在，请核实后输入");
                }
            }
        }
    }


}