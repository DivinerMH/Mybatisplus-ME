package com.linksame.mapper;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.entity.IotTrdTiles;
import com.linksame.vo.IotTrdTilesVO;
import com.linksame.dto.IotTrdTilesDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 3d-tiles 文件数据表(IotTrdTiles)数据库访问层
 *
 * @author menghuan
 * @since 2022-08-26 10:47:24
 */
@Mapper
public interface IotTrdTilesMapper extends BaseMapper<IotTrdTiles> {

    /**
     * 根据id查询3d-tiles 文件数据表详情(多服务)
     *
     * @param id 3d-tiles 文件数据表id
     * @return 3d-tiles 文件数据表展示对象IotTrdTilesVO
     */
    IotTrdTilesVO queryIotTrdTilesDetail(@Param("id") Integer id);

    /**
     * 无参查询3d-tiles 文件数据表List
     *
     * @return 3d-tiles 文件数据表展示对象集合IotTrdTilesVOList
     */
    List<IotTrdTilesVO> queryIotTrdTilesList();

    /**
     * 条件查询3d-tiles 文件数据表List
     *
     * @param iotTrdTilesDTO 3d-tiles 文件数据表接收入参DTO
     * @return 3d-tiles 文件数据表展示对象集合IotTrdTilesVOList
     */
    List<IotTrdTilesVO> queryByConditions(@Param("iotTrdTilesDTO") IotTrdTilesDTO iotTrdTilesDTO);

    /**
     * 分页条件查询3d-tiles 文件数据表Page
     *
     * @param page           分页参数
     * @param iotTrdTilesDTO 3d-tiles 文件数据表接收入参DTO
     * @return 3d-tiles 文件数据表展示对象集合IotTrdTilesVOList
     */
    IPage<IotTrdTilesVO> queryByConditions(@Param("page") Page page, @Param("iotTrdTilesDTO") IotTrdTilesDTO iotTrdTilesDTO);

}
