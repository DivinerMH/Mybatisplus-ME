package com.cateyes.data.govern.bi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.bi.bean.dto.ReqBiParamQueryDto;
import com.cateyes.data.govern.bi.bean.dto.RspBiParamDto;
import com.cateyes.data.govern.bi.bean.po.BiParam;

/**
 * 參數(DgBiParam)Mapper
 *
 * @author CatEyes
 * @since 2024-01-23 12:01:19
 */
@Mapper
public interface BiParamMapper extends BaseMapper<BiParam> {

    /**
     * 详情查询
     * 
     * @param id 參數id
     * @return 參數展示对象RspBiParamDto
     */
    RspBiParamDto detail(@Param("id") Integer id);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 參數分页展示对象集合
     */
    IPage<RspBiParamDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqBiParamQueryDto reqDto);

}
