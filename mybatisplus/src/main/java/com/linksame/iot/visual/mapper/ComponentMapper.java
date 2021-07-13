package com.linksame.iot.visual.mapper;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.visual.entity.Component;
import com.linksame.iot.visual.vo.ComponentVO;
import com.linksame.iot.visual.dto.ComponentDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 组件(Component)数据库访问层
 *
 * @author menghuan
 * @since 2021-07-13 11:24:51
 */
@Mapper
public interface ComponentMapper extends BaseMapper<Component> {

    /**
     * 根据id查询组件详情(跨服务)
     *
     * @param id 组件id
     * @return 组件展示对象ComponentVO
     */
    ComponentVO queryComponentDetail(@Param("id") Integer id);

    /**
     * 无参查询组件List
     *
     * @return 组件展示对象集合ComponentVOList
     */
    List<ComponentVO> queryComponentList();

    /**
     * 条件查询组件List
     *
     * @param componentDTO 组件接收入参DTO
     * @return 组件展示对象集合ComponentVOList
     */
    List<ComponentVO> queryByConditions(@Param("componentDTO") ComponentDTO componentDTO);

    /**
     * 条件查询组件Page
     *
     * @param page         分页参数
     * @param componentDTO 组件接收入参DTO
     * @return 组件展示对象集合ComponentVOList
     */
    IPage<ComponentVO> queryByConditions(@Param("page") Page page, @Param("componentDTO") ComponentDTO componentDTO);

}
