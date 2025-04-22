package com.cateyes.smart.park.report.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemIndustryQueryDto;
import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentItemIndustryDto;

/**
 * 智慧大屏-手工-招商项目-产业项目分布(SpVtBsInvestmentItemIndustry)Mapper
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:39
 */
@Mapper
public interface VtBsInvestmentItemIndustryMapper extends BaseMapper<VtBsInvestmentItemIndustry> {

    /**
     * 详情查询
     * 
     * @param id 智慧大屏-手工-招商项目-产业项目分布id
     * @return 智慧大屏-手工-招商项目-产业项目分布展示对象RspVtBsInvestmentItemIndustryDto
     */
    RspVtBsInvestmentItemIndustryDto detail(@Param("id") Integer id);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 智慧大屏-手工-招商项目-产业项目分布分页展示对象集合
     */
    IPage<RspVtBsInvestmentItemIndustryDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqVtBsInvestmentItemIndustryQueryDto reqDto);

}
