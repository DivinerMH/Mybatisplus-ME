package com.cateyes.smart.park.safe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.safe.bean.dto.RsppatrolPointDto;
import com.cateyes.smart.park.safe.bean.dto.ReqpatrolPointDto;
import com.cateyes.smart.park.safe.bean.po.patrolPoint;

/**
 * 巡检点(SpSfPatrolPoint)service
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:15
 */

public interface IPatrolPointService extends IService<PatrolPoint> {

    /**
     * 巡检点-新增
     * 
     * @param reqDto
     *            巡检点接收入参DTO
     * @return 主键ID
     */
    int savePatrolPoint(ReqPatrolPointDto reqDto);

    /**
     * 巡检点-删除
     * 
     * @param id
     *            巡检点id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deletePatrolPoint(Integer id);

    /**
     * 巡检点-修改
     * 
     * @param reqDto
     *            巡检点接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updatePatrolPoint(ReqPatrolPointDto reqDto);

    /**
     * 巡检点-详情
     * 
     * @param id
     *            巡检点id
     * @return RspPatrolPointDto展示对象
     */
    RspPatrolPointDto queryDetail(Integer id);

    /**
     * 巡检点-条件查询
     * 
     * @param reqDto
     *            巡检点接收入参DTO
     * @return RspPatrolPointDto展示对象List
     */
    List<RspPatrolPointDto> queryList(ReqPatrolPointDto reqDto);

    /**
     * 巡检点-分页查询
     * 
     * @param reqDto
     *            巡检点接收入参DTO
     * @return RspPatrolPointDto展示对象IPage
     */
    PageInfo<RspPatrolPointDto> queryPage(ReqPatrolPointDto reqDto);

}
