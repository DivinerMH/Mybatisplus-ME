package com.cateyes.smart.park.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.iot.bean.dto.RspmonitorDustDto;
import com.cateyes.smart.park.iot.bean.dto.ReqmonitorDustDto;
import com.cateyes.smart.park.iot.bean.po.monitorDust;

/**
 * 粉尘监测仪(SpIotMonitorDust)service
 *
 * @author CatEyes
 * @since 2023-06-21 18:12:29
 */

public interface IMonitorDustService {

    /**
     * 粉尘监测仪-新增
     * 
     * @param reqDto 粉尘监测仪接收入参DTO
     * @return 主键ID
     */
    int saveMonitorDust(ReqMonitorDustDto reqDto);

    /**
     * 粉尘监测仪-删除
     * 
     * @param id 粉尘监测仪id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteMonitorDust(Integer id);

    /**
     * 粉尘监测仪-修改
     * 
     * @param reqDto 粉尘监测仪接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateMonitorDust(ReqMonitorDustDto reqDto);

    /**
     * 粉尘监测仪-详情
     * 
     * @param id 粉尘监测仪id
     * @return RspMonitorDustDto展示对象
     */
    RspMonitorDustDto queryDetail(Integer id);

    /**
     * 粉尘监测仪-条件查询
     * 
     * @param reqDto 粉尘监测仪接收入参DTO
     * @return RspMonitorDustDto展示对象List
     */
    List<RspMonitorDustDto> queryList(ReqMonitorDustDto reqDto);

    /**
     * 粉尘监测仪-分页查询
     * 
     * @param reqDto 粉尘监测仪接收入参DTO
     * @return RspMonitorDustDto展示对象IPage
     */
    PageInfo<RspMonitorDustDto> queryPage(ReqMonitorDustDto reqDto);

}
