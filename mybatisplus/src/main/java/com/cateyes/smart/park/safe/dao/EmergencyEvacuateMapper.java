package com.cateyes.smart.park.safe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.safe.bean.dto.RspemergencyEvacuateDto;
import com.cateyes.smart.park.safe.bean.po.emergencyEvacuate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 应急疏散表(SpSfEmergencyEvacuate)Mapper
 *
 * @author CatEyes
 * @since 2023-06-07 17:27:53
 */
@Mapper
public interface EmergencyEvacuateMapper extends BaseMapper<EmergencyEvacuate> {

    /**
     * 根据id查询应急疏散表详情(跨服务)
     * 
     * @param id
     *            应急疏散表id
     * @return 应急疏散表展示对象RspEmergencyEvacuateDto
     */
    RspEmergencyEvacuateDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询应急疏散表List
     * 
     * @param reqDto
     *            应急疏散表接收入参DTO
     * @return 应急疏散表展示对象集合RspEmergencyEvacuateDtoList
     */
    List<RspEmergencyEvacuateDto> queryByConditions(@Param("reqDto") ReqEmergencyEvacuateDto reqDto);

    /**
     * 条件查询应急疏散表Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            应急疏散表接收入参DTO
     * @return 应急疏散表展示对象集合RspemergencyEvacuateDtoList
     */
    IPage<RspEmergencyEvacuateDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqEmergencyEvacuateDto reqDto);

}
