package com.cateyes.smart.park.report.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.report.bean.dto.RspbsProjectInnovateDto;
import com.cateyes.smart.park.report.bean.po.bsProjectInnovate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 智慧大屏-系统-技改投资类项目报表(SpBsProjectInnovate)Mapper
 *
 * @author CatEyes
 * @since 2023-06-29 10:52:13
 */
@Mapper
public interface BsProjectInnovateMapper extends BaseMapper<BsProjectInnovate> {

}
