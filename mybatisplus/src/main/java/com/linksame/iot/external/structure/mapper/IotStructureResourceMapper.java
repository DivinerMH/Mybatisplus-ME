package com.linksame.iot.external.structure.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.external.structure.dto.IotStructureResourceDTO;
import com.linksame.iot.external.structure.entity.IotStructureResource;
import com.linksame.iot.external.structure.vo.IotStructureResourceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资产结构与资源关系（深宝园-手动维护）(IotStructureResource)数据库访问层
 *
 * @author menghuan
 * @since 2022-03-11 16:14:07
 */
@Mapper
public interface IotStructureResourceMapper extends BaseMapper<IotStructureResource> {

    /**
     * 根据id查询资产结构与资源关系（深宝园-手动维护）详情(多服务)
     *
     * @param id 资产结构与资源关系（深宝园-手动维护）id
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象IotStructureResourceVO
     */
    IotStructureResourceVO queryIotStructureResourceDetail(@Param("id") Integer id);

    /**
     * 无参查询资产结构与资源关系（深宝园-手动维护）List
     *
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象集合IotStructureResourceVOList
     */
    List<IotStructureResourceVO> queryIotStructureResourceList();

    /**
     * 条件查询资产结构与资源关系（深宝园-手动维护）List
     *
     * @param iotStructureResourceDTO 资产结构与资源关系（深宝园-手动维护）接收入参DTO
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象集合IotStructureResourceVOList
     */
    List<IotStructureResourceVO> queryByConditions(@Param("iotStructureResourceDTO") IotStructureResourceDTO iotStructureResourceDTO);

    /**
     * 分页条件查询资产结构与资源关系（深宝园-手动维护）Page
     *
     * @param page                    分页参数
     * @param iotStructureResourceDTO 资产结构与资源关系（深宝园-手动维护）接收入参DTO
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象集合IotStructureResourceVOList
     */
    IPage<IotStructureResourceVO> queryByConditions(@Param("page") Page page, @Param("iotStructureResourceDTO") IotStructureResourceDTO iotStructureResourceDTO);

}
