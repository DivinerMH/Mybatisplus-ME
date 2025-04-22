package com.cateyes.smart.park.report.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemQueryDto;
import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentItemDto;
import com.cateyes.smart.park.report.bean.po.VtBsInvestmentItem;

/**
 * 智慧大屏-手工-招商项目(SpVtBsInvestmentItem)Mapper
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:18
 */
@Mapper
public interface VtBsInvestmentItemMapper extends BaseMapper<VtBsInvestmentItem> {

    /**
     * 详情查询
     * 
     * @param id 智慧大屏-手工-招商项目id
     * @return 智慧大屏-手工-招商项目展示对象RspVtBsInvestmentItemDto
     */
    RspVtBsInvestmentItemDto detail(@Param("id") Integer id);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 智慧大屏-手工-招商项目分页展示对象集合
     */
    IPage<RspVtBsInvestmentItemDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqVtBsInvestmentItemQueryDto reqDto);

}
