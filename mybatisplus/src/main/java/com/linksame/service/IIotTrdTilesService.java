package com.linksame.service;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.entity.IotTrdTiles;
import com.linksame.vo.IotTrdTilesVO;
import com.linksame.dto.IotTrdTilesDTO;

import java.util.List;

/**
 * 3d-tiles 文件数据表(IotTrdTiles)表服务接口
 *
 * @author menghuan
 * @since 2022-08-26 10:47:25
 */
public interface IIotTrdTilesService extends IService<IotTrdTiles> {

    /**
     * 新增3d-tiles 文件数据表
     *
     * @param iotTrdTilesDTO 3d-tiles 文件数据表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveIotTrdTiles(IotTrdTilesDTO iotTrdTilesDTO);

    /**
     * 根据id（逻辑）删除3d-tiles 文件数据表
     *
     * @param id 3d-tiles 文件数据表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteIotTrdTiles(Integer id);

    /**
     * 修改3d-tiles 文件数据表
     *
     * @param iotTrdTilesDTO 3d-tiles 文件数据表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateIotTrdTiles(IotTrdTilesDTO iotTrdTilesDTO);

    /**
     * 根据id查询3d-tiles 文件数据表详情(单服务)
     *
     * @param id 3d-tiles 文件数据表id
     * @return 3d-tiles 文件数据表展示对象
     */
    IotTrdTilesVO queryIotTrdTiles(Integer id);

    /**
     * 根据id查询3d-tiles 文件数据表详情(多服务)
     *
     * @param id 3d-tiles 文件数据表id
     * @return 3d-tiles 文件数据表展示对象
     */
    IotTrdTilesVO queryIotTrdTilesDetail(Integer id);

    /**
     * 无参查询3d-tiles 文件数据表列表
     *
     * @return 3d-tiles 文件数据表展示对象集合IotTrdTilesVOList
     */
    List<IotTrdTilesVO> queryIotTrdTilesList();

    /**
     * 条件查询3d-tiles 文件数据表列表
     *
     * @param iotTrdTilesDTO 3d-tiles 文件数据表接收入参DTO
     * @return 3d-tiles 文件数据表展示对象集合IotTrdTilesVOList
     */
    List<IotTrdTilesVO> queryListByConditions(IotTrdTilesDTO iotTrdTilesDTO);

    /**
     * 分页条件查询3d-tiles 文件数据表列表
     *
     * @param iotTrdTilesDTO 3d-tiles 文件数据表接收入参DTO
     * @return 3d-tiles 文件数据表展示对象集合IotTrdTilesVOList
     */
    IPage<IotTrdTilesVO> queryPageByConditions(Page page, IotTrdTilesDTO iotTrdTilesDTO);

}
