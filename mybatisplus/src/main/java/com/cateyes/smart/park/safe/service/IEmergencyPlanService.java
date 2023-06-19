package com.cateyes.smart.park.safe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.safe.bean.dto.RspemergencyPlanDto;
import com.cateyes.smart.park.safe.bean.dto.ReqemergencyPlanDto;
import com.cateyes.smart.park.safe.bean.po.emergencyPlan;

/**
 * 应急预案(SpSfEmergencyPlan)service
 *
 * @author CatEyes
 * @since 2023-06-05 11:50:34
 */

public interface IEmergencyPlanService extends IService<EmergencyPlan> {

    /**
     * 应急预案-新增
     * 
     * @param reqDto
     *            应急预案接收入参DTO
     * @return 主键ID
     */
    int saveEmergencyPlan(ReqEmergencyPlanDto reqDto);

    /**
     * 应急预案-删除
     * 
     * @param id
     *            应急预案id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteEmergencyPlan(Integer id);

    /**
     * 应急预案-修改
     * 
     * @param reqDto
     *            应急预案接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateEmergencyPlan(ReqEmergencyPlanDto reqDto);

    /**
     * 应急预案-详情
     * 
     * @param id
     *            应急预案id
     * @return RspEmergencyPlanDto展示对象
     */
    RspEmergencyPlanDto queryDetail(Integer id);

    /**
     * 应急预案-条件查询
     * 
     * @param reqDto
     *            应急预案接收入参DTO
     * @return RspEmergencyPlanDto展示对象List
     */
    List<RspEmergencyPlanDto> queryList(ReqEmergencyPlanDto reqDto);

    /**
     * 应急预案-分页查询
     * 
     * @param reqDto
     *            应急预案接收入参DTO
     * @return RspEmergencyPlanDto展示对象IPage
     */
    PageInfo<RspEmergencyPlanDto> queryPage(ReqEmergencyPlanDto reqDto);

}
