package com.cateyes.smart.park.safe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.safe.bean.dto.RsppatrolPointDto;
import com.cateyes.smart.park.safe.bean.po.patrolPoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡检点(SpSfPatrolPoint)Mapper
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:15
 */
@Mapper
public interface PatrolPointMapper extends BaseMapper<PatrolPoint> {

    /**
     * 根据id查询巡检点详情(跨服务)
     * 
     * @param id
     *            巡检点id
     * @return 巡检点展示对象RspPatrolPointDto
     */
    RspPatrolPointDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询巡检点List
     * 
     * @param reqDto
     *            巡检点接收入参DTO
     * @return 巡检点展示对象集合RspPatrolPointDtoList
     */
    List<RspPatrolPointDto> queryByConditions(@Param("reqDto") ReqPatrolPointDto reqDto);

    /**
     * 条件查询巡检点Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            巡检点接收入参DTO
     * @return 巡检点展示对象集合RsppatrolPointDtoList
     */
    IPage<RspPatrolPointDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqPatrolPointDto reqDto);

}
