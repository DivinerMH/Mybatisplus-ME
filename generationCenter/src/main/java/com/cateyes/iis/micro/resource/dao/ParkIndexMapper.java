package com.cateyes.iis.micro.resource.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.iis.micro.resource.bean.dto.RspparkIndexDto;
import com.cateyes.iis.micro.resource.bean.po.parkIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (IisParkIndex)Mapper
 *
 * @author CatEyes
 * @since 2023-10-17 11:11:51
 */
@Mapper
public interface ParkIndexMapper extends BaseMapper<ParkIndex> {

    /**
     * 条件查询List
     * 
     * @param reqDto 接收入参DTO
     * @return 展示对象集合RspParkIndexDtoList
     */
    List<RspParkIndexDto> queryByConditions(@Param("reqDto") ReqParkIndexDto reqDto);

    /**
     * 条件查询Page
     * 
     * @param page 分页参数
     * @param reqDto 接收入参DTO
     * @return 展示对象集合RspParkIndexDtoList
     */
    IPage<RspParkIndexDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqParkIndexDto reqDto);

}
