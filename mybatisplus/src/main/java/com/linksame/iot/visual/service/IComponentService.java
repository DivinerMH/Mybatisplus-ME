package com.linksame.iot.visual.service;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.iot.visual.entity.Component;
import com.linksame.iot.visual.vo.ComponentVO;
import com.linksame.iot.visual.dto.ComponentDTO;

import java.util.List;

/**
 * 组件(Component)表服务接口
 *
 * @author menghuan
 * @since 2021-07-13 11:24:52
 */
public interface IComponentService extends IService<Component> {

    /**
     * 新增组件
     *
     * @param componentDTO 组件接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveComponent(ComponentDTO componentDTO);

    /**
     * 根据id（逻辑）删除组件
     *
     * @param id 组件id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteComponent(Integer id);

    /**
     * 修改组件
     *
     * @param componentDTO 组件接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateComponent(ComponentDTO componentDTO);

    /**
     * 根据id查询组件详情（单服务）
     *
     * @param id 组件id
     * @return 组件展示对象
     */
    ComponentVO queryComponent(Integer id);

    /**
     * 根据id查询组件详情(跨服务)
     *
     * @param id 组件id
     * @return 组件展示对象
     */
    ComponentVO queryComponentDetail(Integer id);

    /**
     * 无参查询查询组件列表
     *
     * @return 组件展示对象集合ComponentVOList
     */
    List<ComponentVO> queryComponentList();

    /**
     * 条件查询查询组件列表
     *
     * @param componentDTO 组件接收入参DTO
     * @return 组件展示对象集合ComponentVOList
     */
    List<ComponentVO> queryListByConditions(ComponentDTO componentDTO);

    /**
     * 分页查询查询组件列表
     *
     * @param componentDTO 组件接收入参DTO
     * @return 组件展示对象集合ComponentVOList
     */
    IPage<ComponentVO> queryPageByConditions(Page page, ComponentDTO componentDTO);

}
