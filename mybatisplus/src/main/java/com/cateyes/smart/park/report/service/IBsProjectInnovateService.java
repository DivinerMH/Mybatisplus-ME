package com.cateyes.smart.park.report.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.report.bean.dto.RspbsProjectInnovateDto;
import com.cateyes.smart.park.report.bean.dto.ReqbsProjectInnovateDto;
import com.cateyes.smart.park.report.bean.po.bsProjectInnovate;

/**
 * 智慧大屏-系统-技改投资类项目报表(SpBsProjectInnovate)service
 *
 * @author CatEyes
 * @since 2023-06-29 10:52:13
 */

public interface IBsProjectInnovateService extends SpBaseService<RspBsProjectInnovateDto, ReqBsProjectInnovateDto> {

}
