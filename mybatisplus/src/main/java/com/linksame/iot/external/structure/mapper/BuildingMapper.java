package com.linksame.iot.external.structure.mapper;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.external.structure.entity.Building;
import com.linksame.iot.external.structure.vo.BuildingVO;
import com.linksame.iot.external.structure.dto.BuildingDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 资源管理-楼宇表(Building)数据库访问层
 *
 * @author menghuan
 * @since 2022-03-11 15:50:14
 */
@Mapper
public interface BuildingMapper extends BaseMapper<Building> {

    /**
     * 根据id查询资源管理-楼宇表详情(多服务)
     *
     * @param id 资源管理-楼宇表id
     * @return 资源管理-楼宇表展示对象BuildingVO
     */
    BuildingVO queryBuildingDetail(@Param("id") Integer id);

    /**
     * 无参查询资源管理-楼宇表List
     *
     * @return 资源管理-楼宇表展示对象集合BuildingVOList
     */
    List<BuildingVO> queryBuildingList();

    /**
     * 条件查询资源管理-楼宇表List
     *
     * @param buildingDTO 资源管理-楼宇表接收入参DTO
     * @return 资源管理-楼宇表展示对象集合BuildingVOList
     */
    List<BuildingVO> queryByConditions(@Param("buildingDTO") BuildingDTO buildingDTO);

    /**
     * 分页条件查询资源管理-楼宇表Page
     *
     * @param page        分页参数
     * @param buildingDTO 资源管理-楼宇表接收入参DTO
     * @return 资源管理-楼宇表展示对象集合BuildingVOList
     */
    IPage<BuildingVO> queryByConditions(@Param("page") Page page, @Param("buildingDTO") BuildingDTO buildingDTO);

}
