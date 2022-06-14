package com.linksame.iot.external.structure.mapper;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.external.structure.entity.BuildingFloorRoom;
import com.linksame.iot.external.structure.vo.BuildingFloorRoomVO;
import com.linksame.iot.external.structure.dto.BuildingFloorRoomDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 资源管理-单元(房源)表(BuildingFloorRoom)数据库访问层
 *
 * @author menghuan
 * @since 2022-03-11 15:50:52
 */
@Mapper
public interface BuildingFloorRoomMapper extends BaseMapper<BuildingFloorRoom> {

    /**
     * 根据id查询资源管理-单元(房源)表详情(多服务)
     *
     * @param id 资源管理-单元(房源)表id
     * @return 资源管理-单元(房源)表展示对象BuildingFloorRoomVO
     */
    BuildingFloorRoomVO queryBuildingFloorRoomDetail(@Param("id") Integer id);

    /**
     * 无参查询资源管理-单元(房源)表List
     *
     * @return 资源管理-单元(房源)表展示对象集合BuildingFloorRoomVOList
     */
    List<BuildingFloorRoomVO> queryBuildingFloorRoomList();

    /**
     * 条件查询资源管理-单元(房源)表List
     *
     * @param buildingFloorRoomDTO 资源管理-单元(房源)表接收入参DTO
     * @return 资源管理-单元(房源)表展示对象集合BuildingFloorRoomVOList
     */
    List<BuildingFloorRoomVO> queryByConditions(@Param("buildingFloorRoomDTO") BuildingFloorRoomDTO buildingFloorRoomDTO);

    /**
     * 分页条件查询资源管理-单元(房源)表Page
     *
     * @param page                 分页参数
     * @param buildingFloorRoomDTO 资源管理-单元(房源)表接收入参DTO
     * @return 资源管理-单元(房源)表展示对象集合BuildingFloorRoomVOList
     */
    IPage<BuildingFloorRoomVO> queryByConditions(@Param("page") Page page, @Param("buildingFloorRoomDTO") BuildingFloorRoomDTO buildingFloorRoomDTO);

}
