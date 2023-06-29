package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RspflowEntranceDto;
import com.cateyes.smart.park.iot.bean.po.flowEntrance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 人流管理-门禁设备(SpIotFlowEntrance)Mapper
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:25
 */
@Mapper
public interface FlowEntranceMapper extends BaseMapper<FlowEntrance> {

    /**
     * 根据id查询人流管理-门禁设备详情(跨服务)
     * 
     * @param id
     *            人流管理-门禁设备id
     * @return 人流管理-门禁设备展示对象RspFlowEntranceDto
     */
    RspFlowEntranceDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询人流管理-门禁设备List
     * 
     * @param reqDto
     *            人流管理-门禁设备接收入参DTO
     * @return 人流管理-门禁设备展示对象集合RspFlowEntranceDtoList
     */
    List<RspFlowEntranceDto> queryByConditions(@Param("reqDto") ReqFlowEntranceDto reqDto);

    /**
     * 条件查询人流管理-门禁设备Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            人流管理-门禁设备接收入参DTO
     * @return 人流管理-门禁设备展示对象集合RspflowEntranceDtoList
     */
    IPage<RspFlowEntranceDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqFlowEntranceDto reqDto);

}
