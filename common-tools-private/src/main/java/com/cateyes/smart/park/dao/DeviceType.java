package com.cateyes.smart.park.dao;

    
    







import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.bean.dto.RspdeviceTypeDto;
import com.cateyes.smart.park.bean.po.deviceType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SpIotDeviceType)Mapper
 *
 * @author CatEyes
 * @since 2023-05-19 15:48:32
 */
@Mapper
public interface DeviceTypeMapper extends BaseMapper<DeviceType> {

    /**
     * 根据id查询详情(跨服务)
     * @param id id
     * @return 展示对象RspDeviceTypeDto
     */
    RspDeviceTypeDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询List
     * @param reqDto 接收入参DTO
     * @return 展示对象集合RspDeviceTypeDtoList
     */
    List<RspDeviceTypeDto> queryByConditions(@Param("reqDto") ReqDeviceTypeDto reqDto);

    /**
     * 条件查询Page
     * @param page 分页参数
     * @param reqDto 接收入参DTO
     * @return 展示对象集合RspdeviceTypeDtoList
     */
    IPage<RspDeviceTypeDto> queryByConditions(@Param("page")Page page, @Param("reqDto") ReqDeviceTypeDto reqDto);
    
}
