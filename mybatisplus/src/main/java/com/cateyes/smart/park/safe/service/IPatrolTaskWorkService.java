package com.cateyes.smart.park.safe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.safe.bean.dto.ReqPatrolTaskWorkDto;
import com.cateyes.smart.park.safe.bean.dto.RspPatrolTaskWorkDto;
import com.cateyes.smart.park.safe.bean.dto.RsppatrolTaskWorkDto;
import com.cateyes.smart.park.safe.bean.dto.ReqpatrolTaskWorkDto;
import com.cateyes.smart.park.safe.bean.po.PatrolTaskWork;
import com.cateyes.smart.park.safe.bean.po.patrolTaskWork;

import java.util.List;

/**
 * 巡检任务工单(SpSfPatrolTaskWork)service
 *
 * @author CatEyes
 * @since 2023-06-12 16:27:02
 */

public interface IPatrolTaskWorkService extends IService<PatrolTaskWork> {

    /**
     * 巡检任务工单-新增
     * 
     * @param reqDto
     *            巡检任务工单接收入参DTO
     * @return 主键ID
     */
    int savePatrolTaskWork(ReqPatrolTaskWorkDto reqDto);

    /**
     * 巡检任务工单-删除
     * 
     * @param id
     *            巡检任务工单id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deletePatrolTaskWork(Integer id);

    /**
     * 巡检任务工单-修改
     * 
     * @param reqDto
     *            巡检任务工单接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updatePatrolTaskWork(ReqPatrolTaskWorkDto reqDto);

    /**
     * 巡检任务工单-详情
     * 
     * @param id
     *            巡检任务工单id
     * @return RspPatrolTaskWorkDto展示对象
     */
    RspPatrolTaskWorkDto queryDetail(Integer id);

    /**
     * 巡检任务工单-条件查询
     * 
     * @param reqDto
     *            巡检任务工单接收入参DTO
     * @return RspPatrolTaskWorkDto展示对象List
     */
    List<RspPatrolTaskWorkDto> queryList(ReqPatrolTaskWorkDto reqDto);

    /**
     * 巡检任务工单-分页查询
     * 
     * @param reqDto
     *            巡检任务工单接收入参DTO
     * @return RspPatrolTaskWorkDto展示对象IPage
     */
    PageInfo<RspPatrolTaskWorkDto> queryPage(ReqPatrolTaskWorkDto reqDto);

}
