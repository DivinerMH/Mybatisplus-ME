package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RspcameraDto;
import com.cateyes.smart.park.iot.bean.po.camera;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 摄像头(SpIotCamera)Mapper
 *
 * @author CatEyes
 * @since 2023-06-19 16:30:48
 */
@Mapper
public interface CameraMapper extends BaseMapper<Camera> {

    /**
     * 根据id查询摄像头详情(跨服务)
     * 
     * @param id
     *            摄像头id
     * @return 摄像头展示对象RspCameraDto
     */
    RspCameraDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询摄像头List
     * 
     * @param reqDto
     *            摄像头接收入参DTO
     * @return 摄像头展示对象集合RspCameraDtoList
     */
    List<RspCameraDto> queryByConditions(@Param("reqDto") ReqCameraDto reqDto);

    /**
     * 条件查询摄像头Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            摄像头接收入参DTO
     * @return 摄像头展示对象集合RspcameraDtoList
     */
    IPage<RspCameraDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqCameraDto reqDto);

}
