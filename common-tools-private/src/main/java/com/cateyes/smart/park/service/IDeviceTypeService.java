package com.cateyes.smart.park.service;

    
    





import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.bean.dto.RspdeviceTypeDto;
import com.cateyes.smart.park.bean.dto.ReqdeviceTypeDto;
import com.cateyes.smart.park.bean.po.deviceType;

/**
 * (SpIotDeviceType)service
 *
 * @author CatEyes
 * @since 2023-05-19 15:32:56
 */

public interface IDeviceTypeService extends IService<DeviceType> {

    /**
     * -新增
     * @param reqDto 接收入参DTO
     * @return 主键ID
     */
    int saveDeviceType(ReqDeviceTypeDto reqDto);

    /**
     * -删除
     * @param id id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteDeviceType(Integer id);

    /**
     * -修改
     * @param reqDto 接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateDeviceType(ReqDeviceTypeDto reqDto);

    /**
     * -详情
     * @param id id
     * @return RspDeviceTypeDto展示对象
     */
    RspDeviceTypeDto queryDetail(Integer id);

    /**
     * -条件查询
     * @param reqDto 接收入参DTO
     * @return RspDeviceTypeDto展示对象List
     */
    List<RspDeviceTypeDto> queryList(ReqDeviceTypeDto reqDto);

    /**
     * -分页查询
     * @param reqDto 接收入参DTO
     * @return RspDeviceTypeDto展示对象IPage
     */
    PageInfo<RspDeviceTypeDto> queryPage(ReqDeviceTypeDto reqDto);

}
