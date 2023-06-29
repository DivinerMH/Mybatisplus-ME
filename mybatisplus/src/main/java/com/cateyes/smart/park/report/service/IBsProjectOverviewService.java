package com.cateyes.smart.park.report.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.report.bean.dto.RspbsProjectOverviewDto;
import com.cateyes.smart.park.report.bean.dto.ReqbsProjectOverviewDto;
import com.cateyes.smart.park.report.bean.po.bsProjectOverview;

/**
 * 智慧大屏-系统-工程项目总览(SpBsProjectOverview)service
 *
 * @author CatEyes
 * @since 2023-06-29 10:41:07
 */

public interface IBsProjectOverviewService extends SpBaseService<RspBsProjectOverviewDto, ReqBsProjectOverviewDto> {

}
