package com.cateyes.smart.park.invest.service;

    
    





import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.invest.bean.dto.RspcameraEventTypeDto;
import com.cateyes.smart.park.invest.bean.dto.ReqcameraEventTypeDto;
import com.cateyes.smart.park.invest.bean.po.cameraEventType;

/**
 * (SpIotCameraEventType)service
 *
 * @author CatEyes
 * @since 2023-05-19 15:20:42
 */

public interface ICameraEventTypeService extends IService<CameraEventType> {

    /**
     * -新增
     * @param reqDto 接收入参DTO
     * @return 主键ID
     */
    int saveCameraEventType(ReqCameraEventTypeDto reqDto);

    /**
     * -删除
     * @param id id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteCameraEventType(Integer id);

    /**
     * -修改
     * @param reqDto 接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateCameraEventType(ReqCameraEventTypeDto reqDto);

    /**
     * -详情
     * @param id id
     * @return RspCameraEventTypeDto展示对象
     */
    RspCameraEventTypeDto queryDetail(Integer id);

    /**
     * -条件查询
     * @param reqDto 接收入参DTO
     * @return RspCameraEventTypeDto展示对象List
     */
    List<RspCameraEventTypeDto> queryList(ReqCameraEventTypeDto reqDto);

    /**
     * -分页查询
     * @param reqDto 接收入参DTO
     * @return RspCameraEventTypeDto展示对象IPage
     */
    PageInfo<RspCameraEventTypeDto> queryPage(ReqCameraEventTypeDto reqDto);

}
