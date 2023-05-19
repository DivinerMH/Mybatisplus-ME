package com.cateyes.smart.park.invest.dao;

    
    







import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.invest.bean.dto.ReqCameraEventTypeDto;
import com.cateyes.smart.park.invest.bean.dto.RspCameraEventTypeDto;
import com.cateyes.smart.park.invest.bean.dto.RspcameraEventTypeDto;
import com.cateyes.smart.park.invest.bean.po.CameraEventType;
import com.cateyes.smart.park.invest.bean.po.cameraEventType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SpIotCameraEventType)Mapper
 *
 * @author CatEyes
 * @since 2023-05-19 15:54:40
 */
@Mapper
public interface CameraEventTypeMapper extends BaseMapper<CameraEventType> {

    /**
     * 根据id查询详情(跨服务)
     * @param id id
     * @return 展示对象RspCameraEventTypeDto
     */
    RspCameraEventTypeDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询List
     * @param reqDto 接收入参DTO
     * @return 展示对象集合RspCameraEventTypeDtoList
     */
    List<RspCameraEventTypeDto> queryByConditions(@Param("reqDto") ReqCameraEventTypeDto reqDto);

    /**
     * 条件查询Page
     * @param page 分页参数
     * @param reqDto 接收入参DTO
     * @return 展示对象集合RspcameraEventTypeDtoList
     */
    IPage<RspCameraEventTypeDto> queryByConditions(@Param("page")Page page, @Param("reqDto") ReqCameraEventTypeDto reqDto);
    
}
