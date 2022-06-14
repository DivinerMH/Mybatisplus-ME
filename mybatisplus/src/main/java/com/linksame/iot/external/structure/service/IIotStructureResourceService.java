package com.linksame.iot.external.structure.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.iot.external.structure.entity.IotStructureResource;
import com.linksame.iot.external.structure.vo.IotStructureResourceVO;
import com.linksame.iot.external.structure.dto.IotStructureResourceDTO;

import java.util.List;

/**
 * 资产结构与资源关系（深宝园-手动维护）(IotStructureResource)表服务接口
 *
 * @author menghuan
 * @since 2022-03-11 16:14:07
 */
public interface IIotStructureResourceService extends IService<IotStructureResource> {

    /**
     * 新增资产结构与资源关系（深宝园-手动维护）
     *
     * @param iotStructureResourceDTO 资产结构与资源关系（深宝园-手动维护）接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveIotStructureResource(IotStructureResourceDTO iotStructureResourceDTO);

    /**
     * 根据id（逻辑）删除资产结构与资源关系（深宝园-手动维护）
     *
     * @param id 资产结构与资源关系（深宝园-手动维护）id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteIotStructureResource(Integer id);

    /**
     * 修改资产结构与资源关系（深宝园-手动维护）
     *
     * @param iotStructureResourceDTO 资产结构与资源关系（深宝园-手动维护）接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateIotStructureResource(IotStructureResourceDTO iotStructureResourceDTO);

    /**
     * 根据id查询资产结构与资源关系（深宝园-手动维护）详情(单服务)
     *
     * @param id 资产结构与资源关系（深宝园-手动维护）id
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象
     */
    IotStructureResourceVO queryIotStructureResource(Integer id);

    /**
     * 根据id查询资产结构与资源关系（深宝园-手动维护）详情(多服务)
     *
     * @param id 资产结构与资源关系（深宝园-手动维护）id
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象
     */
    IotStructureResourceVO queryIotStructureResourceDetail(Integer id);

    /**
     * 无参查询资产结构与资源关系（深宝园-手动维护）列表
     *
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象集合IotStructureResourceVOList
     */
    List<IotStructureResourceVO> queryIotStructureResourceList();

    /**
     * 条件查询资产结构与资源关系（深宝园-手动维护）列表
     *
     * @param iotStructureResourceDTO 资产结构与资源关系（深宝园-手动维护）接收入参DTO
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象集合IotStructureResourceVOList
     */
    List<IotStructureResourceVO> queryListByConditions(IotStructureResourceDTO iotStructureResourceDTO);

    /**
     * 分页条件查询资产结构与资源关系（深宝园-手动维护）列表
     *
     * @param iotStructureResourceDTO 资产结构与资源关系（深宝园-手动维护）接收入参DTO
     * @return 资产结构与资源关系（深宝园-手动维护）展示对象集合IotStructureResourceVOList
     */
    IPage<IotStructureResourceVO> queryPageByConditions(Page page, IotStructureResourceDTO iotStructureResourceDTO);

}
