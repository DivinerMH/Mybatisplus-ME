package com.linksame.iot.visual.service.impl;


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
import com.linksame.iot.visual.entity.Component;
import com.linksame.iot.visual.vo.ComponentVO;
import com.linksame.iot.visual.dto.ComponentDTO;
import com.linksame.iot.visual.mapper.ComponentMapper;
import com.linksame.iot.visual.service.IComponentService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 组件(Component)表服务实现类
 *
 * @author menghuan
 * @since 2021-07-13 11:24:52
 */
@AllArgsConstructor
@Service
@Slf4j
public class ComponentServiceImpl extends ServiceImpl<ComponentMapper, Component> implements IComponentService {

    private final ComponentMapper componentMapper;

    @Override
    public Boolean saveComponent(ComponentDTO componentDTO) {
        // 校验：name 是否重复
        checkNameUnity(componentDTO.getName());

        Component component = new Component();
        BeanUtils.copyProperties(componentDTO, component);
        component.setStatus(CommonConstants.STATUS_NORMAL);
        component.setDelFlag(CommonConstants.STATUS_NORMAL);
        component.setCreateTime(LocalDateTime.now());
        component.setUpdateTime(component.getCreateTime());
        baseMapper.insert(component);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteComponent(Integer id) {
        // 校验：资源是否存在
        checkResource(id);

        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateComponent(ComponentDTO componentDTO) {
        // 校验：name 是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(componentDTO.getName())) {
            checkNameUnity(componentDTO);
        }

        Component component = new Component();
        BeanUtils.copyProperties(componentDTO, component);
        component.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(component);
        return Boolean.TRUE;
    }

    @Override
    public ComponentVO queryComponent(Integer id) {
        Component component = componentMapper.selectById(id);
        if (null == component) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        ComponentVO componentVO = new ComponentVO();
        BeanUtils.copyProperties(component, componentVO);
        return componentVO;
    }

    @Override
    public ComponentVO queryComponentDetail(Integer id) {
        ComponentVO componentVO = componentMapper.queryComponentDetail(id);
        if (null == componentVO) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return componentVO;
    }

    @Override
    public List<ComponentVO> queryComponentList() {
        List<ComponentVO> componentVOS = componentMapper.queryComponentList();
        return componentVOS;
    }

    @Override
    public List<ComponentVO> queryListByConditions(ComponentDTO componentDTO) {
        List<ComponentVO> componentVOS = componentMapper.queryByConditions(componentDTO);
        return componentVOS;
    }

    @Override
    public IPage<ComponentVO> queryPageByConditions(Page page, ComponentDTO componentDTO) {
        IPage<ComponentVO> componentVOIPage = componentMapper.queryByConditions(page, componentDTO);
        return componentVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        Component component = baseMapper.selectById(id);
        if (null == component) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
    }

    // 校验：name 是否重复
    private void checkNameUnity(String name) {
        LambdaQueryWrapper<Component> queryWrapper =
                Wrappers.<Component>lambdaQuery()
                        .eq(StringUtils.isNotEmpty(name), Component::getName, name);
        List<Component> components = baseMapper.selectList(queryWrapper);
        if (null != components && !components.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

    // 校验：name 是否重复（修改时,排除自身重复的情况）
    private void checkNameUnity(ComponentDTO componentDTO) {
        LambdaQueryWrapper<Component> queryWrapper =
                Wrappers.<Component>lambdaQuery()
                        .eq(StringUtils.isNotEmpty(componentDTO.getName()), Component::getName, componentDTO.getName())
                        .ne(null != componentDTO.getId(), Component::getId, componentDTO.getId());
        List<Component> componentList = baseMapper.selectList(queryWrapper);
        // 排除自身重复的情况
        if (null != componentList && !componentList.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }


}
