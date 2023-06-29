package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RsplightPoleDto;
import com.cateyes.smart.park.iot.bean.dto.ReqlightPoleDto;
import com.cateyes.smart.park.iot.bean.po.lightPole;

/**
 * 灯杆(SpIotLightPole)service
 *
 * @author CatEyes
 * @since 2023-06-25 14:28:36
 */

public interface ILightPoleService {

    /**
     * 灯杆-新增
     * 
     * @param reqDto 灯杆接收入参DTO
     * @return 主键ID
     */
    int saveLightPole(ReqLightPoleDto reqDto);

    /**
     * 灯杆-删除
     * 
     * @param id 灯杆id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteLightPole(Integer id);

    /**
     * 灯杆-修改
     * 
     * @param reqDto 灯杆接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateLightPole(ReqLightPoleDto reqDto);

    /**
     * 灯杆-详情
     * 
     * @param id 灯杆id
     * @return RspLightPoleDto展示对象
     */
    RspLightPoleDto queryDetail(Integer id);

    /**
     * 灯杆-条件查询
     * 
     * @param reqDto 灯杆接收入参DTO
     * @return RspLightPoleDto展示对象List
     */
    List<RspLightPoleDto> queryList(ReqLightPoleDto reqDto);

    /**
     * 灯杆-分页查询
     * 
     * @param reqDto 灯杆接收入参DTO
     * @return RspLightPoleDto展示对象IPage
     */
    PageInfo<RspLightPoleDto> queryPage(ReqLightPoleDto reqDto);

}
