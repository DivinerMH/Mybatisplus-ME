package com.cateyes.smart.park.resource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.base.valid.SpBaseService;
import com.cateyes.smart.park.resource.bean.dto.ReqEnterpriseMuBenefitAnalysisDto;
import com.cateyes.smart.park.resource.bean.dto.RspEnterpriseMuBenefitAnalysisDto;
import com.cateyes.smart.park.resource.bean.dto.RspenterpriseMuBenefitAnalysisDto;
import com.cateyes.smart.park.resource.bean.dto.ReqenterpriseMuBenefitAnalysisDto;
import com.cateyes.smart.park.resource.bean.po.enterpriseMuBenefitAnalysis;

/**
 * 企业亩均效益分析-企业得分(SpEnterpriseMuBenefitAnalysis)service
 *
 * @author CatEyes
 * @since 2023-07-25 15:55:45
 */

public interface IEnterpriseMuBenefitAnalysisService
    extends SpBaseService<RspEnterpriseMuBenefitAnalysisDto, ReqEnterpriseMuBenefitAnalysisDto> {

}
