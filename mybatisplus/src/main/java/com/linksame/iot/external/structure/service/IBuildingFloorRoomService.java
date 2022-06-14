package com.linksame.iot.external.structure.service;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.iot.external.structure.entity.BuildingFloorRoom;
import com.linksame.iot.external.structure.vo.BuildingFloorRoomVO;
import com.linksame.iot.external.structure.dto.BuildingFloorRoomDTO;

import java.util.List;

/**
 * 资源管理-单元(房源)表(BuildingFloorRoom)表服务接口
 *
 * @author menghuan
 * @since 2022-03-11 15:50:52
 */
public interface IBuildingFloorRoomService extends IService<BuildingFloorRoom> {

    /**
     * 新增资源管理-单元(房源)表
     *
     * @param buildingFloorRoomDTO 资源管理-单元(房源)表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveBuildingFloorRoom(BuildingFloorRoomDTO buildingFloorRoomDTO);

    /**
     * 根据id（逻辑）删除资源管理-单元(房源)表
     *
     * @param id 资源管理-单元(房源)表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteBuildingFloorRoom(Integer id);

    /**
     * 修改资源管理-单元(房源)表
     *
     * @param buildingFloorRoomDTO 资源管理-单元(房源)表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateBuildingFloorRoom(BuildingFloorRoomDTO buildingFloorRoomDTO);

    /**
     * 根据id查询资源管理-单元(房源)表详情(单服务)
     *
     * @param id 资源管理-单元(房源)表id
     * @return 资源管理-单元(房源)表展示对象
     */
    BuildingFloorRoomVO queryBuildingFloorRoom(Integer id);

    /**
     * 根据id查询资源管理-单元(房源)表详情(多服务)
     *
     * @param id 资源管理-单元(房源)表id
     * @return 资源管理-单元(房源)表展示对象
     */
    BuildingFloorRoomVO queryBuildingFloorRoomDetail(Integer id);

    /**
     * 无参查询资源管理-单元(房源)表列表
     *
     * @return 资源管理-单元(房源)表展示对象集合BuildingFloorRoomVOList
     */
    List<BuildingFloorRoomVO> queryBuildingFloorRoomList();

    /**
     * 条件查询资源管理-单元(房源)表列表
     *
     * @param buildingFloorRoomDTO 资源管理-单元(房源)表接收入参DTO
     * @return 资源管理-单元(房源)表展示对象集合BuildingFloorRoomVOList
     */
    List<BuildingFloorRoomVO> queryListByConditions(BuildingFloorRoomDTO buildingFloorRoomDTO);

    /**
     * 分页条件查询资源管理-单元(房源)表列表
     *
     * @param buildingFloorRoomDTO 资源管理-单元(房源)表接收入参DTO
     * @return 资源管理-单元(房源)表展示对象集合BuildingFloorRoomVOList
     */
    IPage<BuildingFloorRoomVO> queryPageByConditions(Page page, BuildingFloorRoomDTO buildingFloorRoomDTO);

}
