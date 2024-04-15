package com.cateyes.smart.park.report.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentResourcesDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentResourcesQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 智慧大屏-手工-招商资源(SpVtBsInvestmentResources)Mapper
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:47
 */
@Mapper
public interface VtBsInvestmentResourcesMapper extends BaseMapper<VtBsInvestmentResources> {

    /**
     * 详情查询
     * 
     * @param id 智慧大屏-手工-招商资源id
     * @return 智慧大屏-手工-招商资源展示对象RspVtBsInvestmentResourcesDto
     */
    RspVtBsInvestmentResourcesDto detail(@Param("id") Integer id);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 智慧大屏-手工-招商资源分页展示对象集合
     */
    IPage<RspVtBsInvestmentResourcesDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqVtBsInvestmentResourcesQueryDto reqDto);

}
