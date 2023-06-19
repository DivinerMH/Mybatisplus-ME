package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RspsmokeDto;
import com.cateyes.smart.park.iot.bean.dto.ReqsmokeDto;
import com.cateyes.smart.park.iot.bean.po.smoke;

/**
 * 烟感设备(SpIotSmoke)service
 *
 * @author CatEyes
 * @since 2023-06-19 16:57:49
 */

public interface ISmokeService extends IService<Smoke> {

    /**
     * 烟感设备-新增
     * 
     * @param reqDto
     *            烟感设备接收入参DTO
     * @return 主键ID
     */
    int saveSmoke(ReqSmokeDto reqDto);

    /**
     * 烟感设备-删除
     * 
     * @param id
     *            烟感设备id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteSmoke(Integer id);

    /**
     * 烟感设备-修改
     * 
     * @param reqDto
     *            烟感设备接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateSmoke(ReqSmokeDto reqDto);

    /**
     * 烟感设备-详情
     * 
     * @param id
     *            烟感设备id
     * @return RspSmokeDto展示对象
     */
    RspSmokeDto queryDetail(Integer id);

    /**
     * 烟感设备-条件查询
     * 
     * @param reqDto
     *            烟感设备接收入参DTO
     * @return RspSmokeDto展示对象List
     */
    List<RspSmokeDto> queryList(ReqSmokeDto reqDto);

    /**
     * 烟感设备-分页查询
     * 
     * @param reqDto
     *            烟感设备接收入参DTO
     * @return RspSmokeDto展示对象IPage
     */
    PageInfo<RspSmokeDto> queryPage(ReqSmokeDto reqDto);

}
