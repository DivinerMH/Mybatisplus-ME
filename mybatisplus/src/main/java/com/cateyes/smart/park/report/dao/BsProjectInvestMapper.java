package com.cateyes.smart.park.report.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.report.bean.dto.RspbsProjectInvestDto;
import com.cateyes.smart.park.report.bean.po.bsProjectInvest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 智慧大屏-系统-工业投资类项目报表(SpBsProjectInvest)Mapper
 *
 * @author CatEyes
 * @since 2023-06-29 10:51:58
 */
@Mapper
public interface BsProjectInvestMapper extends BaseMapper<BsProjectInvest> {

}
