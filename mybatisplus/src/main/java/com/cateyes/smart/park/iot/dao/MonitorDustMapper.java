package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RspmonitorDustDto;
import com.cateyes.smart.park.iot.bean.po.monitorDust;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 粉尘监测仪(SpIotMonitorDust)Mapper
 *
 * @author CatEyes
 * @since 2023-06-21 18:12:29
 */
@Mapper
public interface MonitorDustMapper extends BaseMapper<MonitorDust> {

    /**
     * 根据id查询粉尘监测仪详情(跨服务)
     * 
     * @param id 粉尘监测仪id
     * @return 粉尘监测仪展示对象RspMonitorDustDto
     */
    RspMonitorDustDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询粉尘监测仪List
     * 
     * @param reqDto 粉尘监测仪接收入参DTO
     * @return 粉尘监测仪展示对象集合RspMonitorDustDtoList
     */
    List<RspMonitorDustDto> queryByConditions(@Param("reqDto") ReqMonitorDustDto reqDto);

    /**
     * 条件查询粉尘监测仪Page
     * 
     * @param page 分页参数
     * @param reqDto 粉尘监测仪接收入参DTO
     * @return 粉尘监测仪展示对象集合RspMonitorDustDtoList
     */
    IPage<RspMonitorDustDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqMonitorDustDto reqDto);

}
