package com.cateyes.smart.park.safe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.safe.bean.dto.RsppatrolStructureDto;
import com.cateyes.smart.park.safe.bean.dto.ReqpatrolStructureDto;
import com.cateyes.smart.park.safe.bean.po.patrolStructure;

/**
 * 构筑物(SpSfPatrolStructure)service
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:31
 */

public interface IPatrolStructureService extends IService<PatrolStructure> {

    /**
     * 构筑物-新增
     * 
     * @param reqDto
     *            构筑物接收入参DTO
     * @return 主键ID
     */
    int savePatrolStructure(ReqPatrolStructureDto reqDto);

    /**
     * 构筑物-删除
     * 
     * @param id
     *            构筑物id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deletePatrolStructure(Integer id);

    /**
     * 构筑物-修改
     * 
     * @param reqDto
     *            构筑物接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updatePatrolStructure(ReqPatrolStructureDto reqDto);

    /**
     * 构筑物-详情
     * 
     * @param id
     *            构筑物id
     * @return RspPatrolStructureDto展示对象
     */
    RspPatrolStructureDto queryDetail(Integer id);

    /**
     * 构筑物-条件查询
     * 
     * @param reqDto
     *            构筑物接收入参DTO
     * @return RspPatrolStructureDto展示对象List
     */
    List<RspPatrolStructureDto> queryList(ReqPatrolStructureDto reqDto);

    /**
     * 构筑物-分页查询
     * 
     * @param reqDto
     *            构筑物接收入参DTO
     * @return RspPatrolStructureDto展示对象IPage
     */
    PageInfo<RspPatrolStructureDto> queryPage(ReqPatrolStructureDto reqDto);

}
