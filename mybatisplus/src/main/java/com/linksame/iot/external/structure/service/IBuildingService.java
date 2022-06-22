package com.linksame.iot.external.structure.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.iot.external.structure.dto.BuildingDTO;
import com.linksame.iot.external.structure.entity.Building;
import com.linksame.iot.external.structure.vo.BuildingVO;

import java.util.List;

/**
 * 资源管理-楼宇表(Building)表服务接口
 *
 * @author menghuan
 * @since 2022-03-11 15:50:14
 */
public interface IBuildingService extends IService<Building> {

    /**
     * 新增资源管理-楼宇表
     *
     * @param buildingDTO 资源管理-楼宇表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveBuilding(BuildingDTO buildingDTO);

    /**
     * 根据id（逻辑）删除资源管理-楼宇表
     *
     * @param id 资源管理-楼宇表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteBuilding(Integer id);

    /**
     * 修改资源管理-楼宇表
     *
     * @param buildingDTO 资源管理-楼宇表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateBuilding(BuildingDTO buildingDTO);

    /**
     * 根据id查询资源管理-楼宇表详情(单服务)
     *
     * @param id 资源管理-楼宇表id
     * @return 资源管理-楼宇表展示对象
     */
    BuildingVO queryBuilding(Integer id);

    /**
     * 根据id查询资源管理-楼宇表详情(多服务)
     *
     * @param id 资源管理-楼宇表id
     * @return 资源管理-楼宇表展示对象
     */
    BuildingVO queryBuildingDetail(Integer id);

    /**
     * 无参查询资源管理-楼宇表列表
     *
     * @return 资源管理-楼宇表展示对象集合BuildingVOList
     */
    List<BuildingVO> queryBuildingList();

    /**
     * 条件查询资源管理-楼宇表列表
     *
     * @param buildingDTO 资源管理-楼宇表接收入参DTO
     * @return 资源管理-楼宇表展示对象集合BuildingVOList
     */
    List<BuildingVO> queryListByConditions(BuildingDTO buildingDTO);

    /**
     * 分页条件查询资源管理-楼宇表列表
     *
     * @param buildingDTO 资源管理-楼宇表接收入参DTO
     * @return 资源管理-楼宇表展示对象集合BuildingVOList
     */
    IPage<BuildingVO> queryPageByConditions(Page page, BuildingDTO buildingDTO);

}
