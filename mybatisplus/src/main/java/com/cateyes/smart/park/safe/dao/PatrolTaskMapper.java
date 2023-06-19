package com.cateyes.smart.park.safe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.safe.bean.dto.RsppatrolTaskDto;
import com.cateyes.smart.park.safe.bean.po.patrolTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡检任务(SpSfPatrolTask)Mapper
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:47
 */
@Mapper
public interface PatrolTaskMapper extends BaseMapper<PatrolTask> {

    /**
     * 根据id查询巡检任务详情(跨服务)
     * 
     * @param id
     *            巡检任务id
     * @return 巡检任务展示对象RspPatrolTaskDto
     */
    RspPatrolTaskDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询巡检任务List
     * 
     * @param reqDto
     *            巡检任务接收入参DTO
     * @return 巡检任务展示对象集合RspPatrolTaskDtoList
     */
    List<RspPatrolTaskDto> queryByConditions(@Param("reqDto") ReqPatrolTaskDto reqDto);

    /**
     * 条件查询巡检任务Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            巡检任务接收入参DTO
     * @return 巡检任务展示对象集合RsppatrolTaskDtoList
     */
    IPage<RspPatrolTaskDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqPatrolTaskDto reqDto);

}
