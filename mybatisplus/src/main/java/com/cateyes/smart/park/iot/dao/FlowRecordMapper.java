package com.cateyes.smart.park.iot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.iot.bean.dto.RspflowRecordDto;
import com.cateyes.smart.park.iot.bean.po.flowRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 人流管理-人流记录(SpIotFlowRecord)Mapper
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:52
 */
@Mapper
public interface FlowRecordMapper extends BaseMapper<FlowRecord> {

    /**
     * 根据id查询人流管理-人流记录详情(跨服务)
     * 
     * @param id
     *            人流管理-人流记录id
     * @return 人流管理-人流记录展示对象RspFlowRecordDto
     */
    RspFlowRecordDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询人流管理-人流记录List
     * 
     * @param reqDto
     *            人流管理-人流记录接收入参DTO
     * @return 人流管理-人流记录展示对象集合RspFlowRecordDtoList
     */
    List<RspFlowRecordDto> queryByConditions(@Param("reqDto") ReqFlowRecordDto reqDto);

    /**
     * 条件查询人流管理-人流记录Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            人流管理-人流记录接收入参DTO
     * @return 人流管理-人流记录展示对象集合RspflowRecordDtoList
     */
    IPage<RspFlowRecordDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqFlowRecordDto reqDto);

}
