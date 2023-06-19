package com.cateyes.smart.park.safe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.safe.bean.dto.RspemergencyPlanDto;
import com.cateyes.smart.park.safe.bean.po.emergencyPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 应急预案(SpSfEmergencyPlan)Mapper
 *
 * @author CatEyes
 * @since 2023-06-05 11:50:33
 */
@Mapper
public interface EmergencyPlanMapper extends BaseMapper<EmergencyPlan> {

    /**
     * 根据id查询应急预案详情(跨服务)
     * 
     * @param id
     *            应急预案id
     * @return 应急预案展示对象RspEmergencyPlanDto
     */
    RspEmergencyPlanDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询应急预案List
     * 
     * @param reqDto
     *            应急预案接收入参DTO
     * @return 应急预案展示对象集合RspEmergencyPlanDtoList
     */
    List<RspEmergencyPlanDto> queryByConditions(@Param("reqDto") ReqEmergencyPlanDto reqDto);

    /**
     * 条件查询应急预案Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            应急预案接收入参DTO
     * @return 应急预案展示对象集合RspemergencyPlanDtoList
     */
    IPage<RspEmergencyPlanDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqEmergencyPlanDto reqDto);

}
