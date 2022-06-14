package com.linksame.iot.external.structure.service;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.iot.external.structure.entity.BuildingFloor;
import com.linksame.iot.external.structure.vo.BuildingFloorVO;
import com.linksame.iot.external.structure.dto.BuildingFloorDTO;

import java.util.List;

/**
 * 资源管理-楼层表(BuildingFloor)表服务接口
 *
 * @author menghuan
 * @since 2022-03-11 15:50:30
 */
public interface IBuildingFloorService extends IService<BuildingFloor> {

    /**
     * 新增资源管理-楼层表
     *
     * @param buildingFloorDTO 资源管理-楼层表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveBuildingFloor(BuildingFloorDTO buildingFloorDTO);

    /**
     * 根据id（逻辑）删除资源管理-楼层表
     *
     * @param id 资源管理-楼层表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteBuildingFloor(Integer id);

    /**
     * 修改资源管理-楼层表
     *
     * @param buildingFloorDTO 资源管理-楼层表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateBuildingFloor(BuildingFloorDTO buildingFloorDTO);

    /**
     * 根据id查询资源管理-楼层表详情(单服务)
     *
     * @param id 资源管理-楼层表id
     * @return 资源管理-楼层表展示对象
     */
    BuildingFloorVO queryBuildingFloor(Integer id);

    /**
     * 根据id查询资源管理-楼层表详情(多服务)
     *
     * @param id 资源管理-楼层表id
     * @return 资源管理-楼层表展示对象
     */
    BuildingFloorVO queryBuildingFloorDetail(Integer id);

    /**
     * 无参查询资源管理-楼层表列表
     *
     * @return 资源管理-楼层表展示对象集合BuildingFloorVOList
     */
    List<BuildingFloorVO> queryBuildingFloorList();

    /**
     * 条件查询资源管理-楼层表列表
     *
     * @param buildingFloorDTO 资源管理-楼层表接收入参DTO
     * @return 资源管理-楼层表展示对象集合BuildingFloorVOList
     */
    List<BuildingFloorVO> queryListByConditions(BuildingFloorDTO buildingFloorDTO);

    /**
     * 分页条件查询资源管理-楼层表列表
     *
     * @param buildingFloorDTO 资源管理-楼层表接收入参DTO
     * @return 资源管理-楼层表展示对象集合BuildingFloorVOList
     */
    IPage<BuildingFloorVO> queryPageByConditions(Page page, BuildingFloorDTO buildingFloorDTO);

}
