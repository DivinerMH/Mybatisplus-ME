package com.cateyes.smart.park.safe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.safe.bean.dto.RsppatrolStructureDto;
import com.cateyes.smart.park.safe.bean.po.patrolStructure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 构筑物(SpSfPatrolStructure)Mapper
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:30
 */
@Mapper
public interface PatrolStructureMapper extends BaseMapper<PatrolStructure> {

    /**
     * 根据id查询构筑物详情(跨服务)
     * 
     * @param id
     *            构筑物id
     * @return 构筑物展示对象RspPatrolStructureDto
     */
    RspPatrolStructureDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询构筑物List
     * 
     * @param reqDto
     *            构筑物接收入参DTO
     * @return 构筑物展示对象集合RspPatrolStructureDtoList
     */
    List<RspPatrolStructureDto> queryByConditions(@Param("reqDto") ReqPatrolStructureDto reqDto);

    /**
     * 条件查询构筑物Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            构筑物接收入参DTO
     * @return 构筑物展示对象集合RsppatrolStructureDtoList
     */
    IPage<RspPatrolStructureDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqPatrolStructureDto reqDto);

}
