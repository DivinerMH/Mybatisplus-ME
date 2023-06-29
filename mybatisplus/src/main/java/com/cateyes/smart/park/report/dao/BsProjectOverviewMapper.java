package com.cateyes.smart.park.report.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.report.bean.dto.RspbsProjectOverviewDto;
import com.cateyes.smart.park.report.bean.po.bsProjectOverview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 智慧大屏-系统-工程项目总览(SpBsProjectOverview)Mapper
 *
 * @author CatEyes
 * @since 2023-06-29 10:41:07
 */
@Mapper
public interface BsProjectOverviewMapper extends BaseMapper<BsProjectOverview> {

}
