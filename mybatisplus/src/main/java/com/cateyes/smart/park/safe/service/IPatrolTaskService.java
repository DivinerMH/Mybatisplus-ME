package com.cateyes.smart.park.safe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.safe.bean.dto.RsppatrolTaskDto;
import com.cateyes.smart.park.safe.bean.dto.ReqpatrolTaskDto;
import com.cateyes.smart.park.safe.bean.po.patrolTask;

/**
 * 巡检任务(SpSfPatrolTask)service
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:48
 */

public interface IPatrolTaskService extends IService<PatrolTask> {

    /**
     * 巡检任务-新增
     * 
     * @param reqDto
     *            巡检任务接收入参DTO
     * @return 主键ID
     */
    int savePatrolTask(ReqPatrolTaskDto reqDto);

    /**
     * 巡检任务-删除
     * 
     * @param id
     *            巡检任务id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deletePatrolTask(Integer id);

    /**
     * 巡检任务-修改
     * 
     * @param reqDto
     *            巡检任务接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updatePatrolTask(ReqPatrolTaskDto reqDto);

    /**
     * 巡检任务-详情
     * 
     * @param id
     *            巡检任务id
     * @return RspPatrolTaskDto展示对象
     */
    RspPatrolTaskDto queryDetail(Integer id);

    /**
     * 巡检任务-条件查询
     * 
     * @param reqDto
     *            巡检任务接收入参DTO
     * @return RspPatrolTaskDto展示对象List
     */
    List<RspPatrolTaskDto> queryList(ReqPatrolTaskDto reqDto);

    /**
     * 巡检任务-分页查询
     * 
     * @param reqDto
     *            巡检任务接收入参DTO
     * @return RspPatrolTaskDto展示对象IPage
     */
    PageInfo<RspPatrolTaskDto> queryPage(ReqPatrolTaskDto reqDto);

}
