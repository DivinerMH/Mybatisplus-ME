package com.cateyes.smart.park.resource.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 企业亩均效益分析-企业得分(SpEnterpriseMuBenefitAnalysis)Mapper
 *
 * @author CatEyes
 * @since 2023-07-25 15:55:44
 */
@Mapper
public interface EnterpriseMuBenefitAnalysisMapper extends BaseMapper<EnterpriseMuBenefitAnalysis> {

    /**
     * 条件查询企业亩均效益分析-企业得分List
     * 
     * @param reqDto 企业亩均效益分析-企业得分接收入参DTO
     * @return 企业亩均效益分析-企业得分展示对象集合RspEnterpriseMuBenefitAnalysisDtoList
     */
    List<RspEnterpriseMuBenefitAnalysisDto>
        queryByConditions(@Param("reqDto") ReqEnterpriseMuBenefitAnalysisDto reqDto);

    /**
     * 条件查询企业亩均效益分析-企业得分Page
     * 
     * @param page 分页参数
     * @param reqDto 企业亩均效益分析-企业得分接收入参DTO
     * @return 企业亩均效益分析-企业得分展示对象集合RspEnterpriseMuBenefitAnalysisDtoList
     */
    IPage<RspEnterpriseMuBenefitAnalysisDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqEnterpriseMuBenefitAnalysisDto reqDto);

}
