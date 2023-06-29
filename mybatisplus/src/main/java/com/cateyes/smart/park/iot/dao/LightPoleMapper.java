package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RsplightPoleDto;
import com.cateyes.smart.park.iot.bean.po.lightPole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 灯杆(SpIotLightPole)Mapper
 *
 * @author CatEyes
 * @since 2023-06-25 14:28:35
 */
@Mapper
public interface LightPoleMapper extends BaseMapper<LightPole> {

    /**
     * 根据id查询灯杆详情(跨服务)
     * 
     * @param id 灯杆id
     * @return 灯杆展示对象RspLightPoleDto
     */
    RspLightPoleDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询灯杆List
     * 
     * @param reqDto 灯杆接收入参DTO
     * @return 灯杆展示对象集合RspLightPoleDtoList
     */
    List<RspLightPoleDto> queryByConditions(@Param("reqDto") ReqLightPoleDto reqDto);

    /**
     * 条件查询灯杆Page
     * 
     * @param page 分页参数
     * @param reqDto 灯杆接收入参DTO
     * @return 灯杆展示对象集合RspLightPoleDtoList
     */
    IPage<RspLightPoleDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqLightPoleDto reqDto);

}
