package com.cateyes.smart.park.safe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.safe.bean.dto.RsppatrolTaskWorkDto;
import com.cateyes.smart.park.safe.bean.po.patrolTaskWork;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡检任务工单(SpSfPatrolTaskWork)Mapper
 *
 * @author CatEyes
 * @since 2023-06-12 16:27:01
 */
@Mapper
public interface PatrolTaskWorkMapper extends BaseMapper<PatrolTaskWork> {

    /**
     * 根据id查询巡检任务工单详情(跨服务)
     * 
     * @param id
     *            巡检任务工单id
     * @return 巡检任务工单展示对象RspPatrolTaskWorkDto
     */
    RspPatrolTaskWorkDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询巡检任务工单List
     * 
     * @param reqDto
     *            巡检任务工单接收入参DTO
     * @return 巡检任务工单展示对象集合RspPatrolTaskWorkDtoList
     */
    List<RspPatrolTaskWorkDto> queryByConditions(@Param("reqDto") ReqPatrolTaskWorkDto reqDto);

    /**
     * 条件查询巡检任务工单Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            巡检任务工单接收入参DTO
     * @return 巡检任务工单展示对象集合RsppatrolTaskWorkDtoList
     */
    IPage<RspPatrolTaskWorkDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqPatrolTaskWorkDto reqDto);

}
