package com.cateyes.smart.park.report.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.report.bean.dto.RspbsProjectInvestDto;
import com.cateyes.smart.park.report.bean.dto.ReqbsProjectInvestDto;
import com.cateyes.smart.park.report.bean.po.bsProjectInvest;

/**
 * 智慧大屏-系统-工业投资类项目报表(SpBsProjectInvest)service
 *
 * @author CatEyes
 * @since 2023-06-29 10:51:59
 */

public interface IBsProjectInvestService extends SpBaseService<RspBsProjectInvestDto, ReqBsProjectInvestDto> {

}
