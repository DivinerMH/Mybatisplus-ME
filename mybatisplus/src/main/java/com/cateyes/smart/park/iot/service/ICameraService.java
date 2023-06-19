package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RspcameraDto;
import com.cateyes.smart.park.iot.bean.dto.ReqcameraDto;
import com.cateyes.smart.park.iot.bean.po.camera;

/**
 * 摄像头(SpIotCamera)service
 *
 * @author CatEyes
 * @since 2023-06-19 16:30:50
 */

public interface ICameraService extends IService<Camera> {

    /**
     * 摄像头-新增
     * 
     * @param reqDto
     *            摄像头接收入参DTO
     * @return 主键ID
     */
    int saveCamera(ReqCameraDto reqDto);

    /**
     * 摄像头-删除
     * 
     * @param id
     *            摄像头id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteCamera(Integer id);

    /**
     * 摄像头-修改
     * 
     * @param reqDto
     *            摄像头接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateCamera(ReqCameraDto reqDto);

    /**
     * 摄像头-详情
     * 
     * @param id
     *            摄像头id
     * @return RspCameraDto展示对象
     */
    RspCameraDto queryDetail(Integer id);

    /**
     * 摄像头-条件查询
     * 
     * @param reqDto
     *            摄像头接收入参DTO
     * @return RspCameraDto展示对象List
     */
    List<RspCameraDto> queryList(ReqCameraDto reqDto);

    /**
     * 摄像头-分页查询
     * 
     * @param reqDto
     *            摄像头接收入参DTO
     * @return RspCameraDto展示对象IPage
     */
    PageInfo<RspCameraDto> queryPage(ReqCameraDto reqDto);

}
