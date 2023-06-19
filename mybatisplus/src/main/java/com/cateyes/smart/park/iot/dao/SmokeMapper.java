package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RspsmokeDto;
import com.cateyes.smart.park.iot.bean.po.smoke;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 烟感设备(SpIotSmoke)Mapper
 *
 * @author CatEyes
 * @since 2023-06-19 16:57:48
 */
@Mapper
public interface SmokeMapper extends BaseMapper<Smoke> {

    /**
     * 根据id查询烟感设备详情(跨服务)
     * 
     * @param id
     *            烟感设备id
     * @return 烟感设备展示对象RspSmokeDto
     */
    RspSmokeDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询烟感设备List
     * 
     * @param reqDto
     *            烟感设备接收入参DTO
     * @return 烟感设备展示对象集合RspSmokeDtoList
     */
    List<RspSmokeDto> queryByConditions(@Param("reqDto") ReqSmokeDto reqDto);

    /**
     * 条件查询烟感设备Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            烟感设备接收入参DTO
     * @return 烟感设备展示对象集合RspsmokeDtoList
     */
    IPage<RspSmokeDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqSmokeDto reqDto);

}
