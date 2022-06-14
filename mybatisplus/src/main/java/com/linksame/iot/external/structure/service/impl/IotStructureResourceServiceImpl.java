package com.linksame.iot.external.structure.service.impl;


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
import com.linksame.iot.external.structure.entity.IotStructureResource;
import com.linksame.iot.external.structure.vo.IotStructureResourceVO;
import com.linksame.iot.external.structure.dto.IotStructureResourceDTO;
import com.linksame.iot.external.structure.mapper.IotStructureResourceMapper;
import com.linksame.iot.external.structure.service.IIotStructureResourceService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 资产结构与资源关系（深宝园-手动维护）(IotStructureResource)表服务实现类
 *
 * @author menghuan
 * @since 2022-03-11 16:14:07
 */
@AllArgsConstructor
@Service
@Slf4j
public class IotStructureResourceServiceImpl extends ServiceImpl<IotStructureResourceMapper, IotStructureResource> implements IIotStructureResourceService {

    private final IotStructureResourceMapper iotStructureResourceMapper;

    @Override
    public Boolean saveIotStructureResource(IotStructureResourceDTO iotStructureResourceDTO) {
        // 校验：名称是否重复
        checkNameUnity(iotStructureResourceDTO);
        // 业务逻辑
        IotStructureResource iotStructureResource = new IotStructureResource();
        BeanUtils.copyProperties(iotStructureResourceDTO, iotStructureResource);
        iotStructureResource.setStatus(CommonConstants.STATUS_NORMAL);
        iotStructureResource.setDelFlag(CommonConstants.STATUS_NORMAL);
        iotStructureResource.setCreateTime(LocalDateTime.now());
        iotStructureResource.setUpdateTime(iotStructureResource.getCreateTime());
        baseMapper.insert(iotStructureResource);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteIotStructureResource(Integer id) {
        // 校验：资源是否存在
        checkResource(id);
        // 业务逻辑
        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateIotStructureResource(IotStructureResourceDTO iotStructureResourceDTO) {
        // 校验：名称是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(iotStructureResourceDTO.getName())) {
            checkNameUnity(iotStructureResourceDTO);
        }
        // 业务逻辑
        IotStructureResource iotStructureResource = new IotStructureResource();
        BeanUtils.copyProperties(iotStructureResourceDTO, iotStructureResource);
        iotStructureResource.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(iotStructureResource);
        return Boolean.TRUE;
    }

    @Override
    public IotStructureResourceVO queryIotStructureResource(Integer id) {
        IotStructureResource iotStructureResource = iotStructureResourceMapper.selectById(id);
        if (null == iotStructureResource) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        IotStructureResourceVO iotStructureResourceVO = new IotStructureResourceVO();
        BeanUtils.copyProperties(iotStructureResource, iotStructureResourceVO);
        return iotStructureResourceVO;
    }

    @Override
    public IotStructureResourceVO queryIotStructureResourceDetail(Integer id) {
        IotStructureResourceVO iotStructureResourceVO = iotStructureResourceMapper.queryIotStructureResourceDetail(id);
        if (null == iotStructureResourceVO) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return iotStructureResourceVO;
    }

    @Override
    public List<IotStructureResourceVO> queryIotStructureResourceList() {
        List<IotStructureResourceVO> iotStructureResourceVOS = iotStructureResourceMapper.queryIotStructureResourceList();
        return iotStructureResourceVOS;
    }

    @Override
    public List<IotStructureResourceVO> queryListByConditions(IotStructureResourceDTO iotStructureResourceDTO) {
        List<IotStructureResourceVO> iotStructureResourceVOS = iotStructureResourceMapper.queryByConditions(iotStructureResourceDTO);
        return iotStructureResourceVOS;
    }

    @Override
    public IPage<IotStructureResourceVO> queryPageByConditions(Page page, IotStructureResourceDTO iotStructureResourceDTO) {
        IPage<IotStructureResourceVO> iotStructureResourceVOIPage = iotStructureResourceMapper.queryByConditions(page, iotStructureResourceDTO);
        return iotStructureResourceVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        IotStructureResource iotStructureResource = baseMapper.selectById(id);
        if (null == iotStructureResource) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
    }

    /**
     * 校验：新增 / 修改 name 是否重复【多租户版本】
     * 提示：新增时，id请传入为 null，
     * 修改时，id传入相应值，以排除自身数据
     */
    private void checkNameUnity(IotStructureResourceDTO iotStructureResourceDTO) {
        // 使用 .ne() 排除自身重复的情况
        LambdaQueryWrapper<IotStructureResource> queryWrapper =
                Wrappers.<IotStructureResource>lambdaQuery()
                        // .eq(null != IotStructureResourceDTO.getTenantId(), IotStructureResource::getTenantId, IotStructureResourceDTO.getTenantId())
                        .eq(StringUtils.isNotEmpty(iotStructureResourceDTO.getName()), IotStructureResource::getName, iotStructureResourceDTO.getName())
                        .ne(null != iotStructureResourceDTO.getId(), IotStructureResource::getId, iotStructureResourceDTO.getId());
        List<IotStructureResource> iotStructureResourceList = baseMapper.selectList(queryWrapper);
        if (null != iotStructureResourceList && !iotStructureResourceList.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

}
