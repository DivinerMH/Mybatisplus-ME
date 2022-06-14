package com.linksame.iot.external.structure.mapper;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.external.structure.entity.BuildingFloor;
import com.linksame.iot.external.structure.vo.BuildingFloorVO;
import com.linksame.iot.external.structure.dto.BuildingFloorDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 资源管理-楼层表(BuildingFloor)数据库访问层
 *
 * @author menghuan
 * @since 2022-03-11 15:50:30
 */
@Mapper
public interface BuildingFloorMapper extends BaseMapper<BuildingFloor> {

    /**
     * 根据id查询资源管理-楼层表详情(多服务)
     *
     * @param id 资源管理-楼层表id
     * @return 资源管理-楼层表展示对象BuildingFloorVO
     */
    BuildingFloorVO queryBuildingFloorDetail(@Param("id") Integer id);

    /**
     * 无参查询资源管理-楼层表List
     *
     * @return 资源管理-楼层表展示对象集合BuildingFloorVOList
     */
    List<BuildingFloorVO> queryBuildingFloorList();

    /**
     * 条件查询资源管理-楼层表List
     *
     * @param buildingFloorDTO 资源管理-楼层表接收入参DTO
     * @return 资源管理-楼层表展示对象集合BuildingFloorVOList
     */
    List<BuildingFloorVO> queryByConditions(@Param("buildingFloorDTO") BuildingFloorDTO buildingFloorDTO);

    /**
     * 分页条件查询资源管理-楼层表Page
     *
     * @param page             分页参数
     * @param buildingFloorDTO 资源管理-楼层表接收入参DTO
     * @return 资源管理-楼层表展示对象集合BuildingFloorVOList
     */
    IPage<BuildingFloorVO> queryByConditions(@Param("page") Page page, @Param("buildingFloorDTO") BuildingFloorDTO buildingFloorDTO);

}
