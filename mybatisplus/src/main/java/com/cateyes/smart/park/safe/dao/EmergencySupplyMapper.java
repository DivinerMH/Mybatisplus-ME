package com.cateyes.smart.park.safe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.safe.bean.dto.RspemergencySupplyDto;
import com.cateyes.smart.park.safe.bean.po.emergencySupply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 应急物资(SpSfEmergencySupply)Mapper
 *
 * @author CatEyes
 * @since 2023-06-05 11:51:26
 */
@Mapper
public interface EmergencySupplyMapper extends BaseMapper<EmergencySupply> {

    /**
     * 根据id查询应急物资详情(跨服务)
     * 
     * @param id
     *            应急物资id
     * @return 应急物资展示对象RspEmergencySupplyDto
     */
    RspEmergencySupplyDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询应急物资List
     * 
     * @param reqDto
     *            应急物资接收入参DTO
     * @return 应急物资展示对象集合RspEmergencySupplyDtoList
     */
    List<RspEmergencySupplyDto> queryByConditions(@Param("reqDto") ReqEmergencySupplyDto reqDto);

    /**
     * 条件查询应急物资Page
     * 
     * @param page
     *            分页参数
     * @param reqDto
     *            应急物资接收入参DTO
     * @return 应急物资展示对象集合RspemergencySupplyDtoList
     */
    IPage<RspEmergencySupplyDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqEmergencySupplyDto reqDto);

}
