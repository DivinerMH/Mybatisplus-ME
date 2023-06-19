package com.cateyes.smart.park.safe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.safe.bean.dto.RspemergencySupplyDto;
import com.cateyes.smart.park.safe.bean.dto.ReqemergencySupplyDto;
import com.cateyes.smart.park.safe.bean.po.emergencySupply;

/**
 * 应急物资(SpSfEmergencySupply)service
 *
 * @author CatEyes
 * @since 2023-06-05 11:51:27
 */

public interface IEmergencySupplyService extends IService<EmergencySupply> {

    /**
     * 应急物资-新增
     * 
     * @param reqDto
     *            应急物资接收入参DTO
     * @return 主键ID
     */
    int saveEmergencySupply(ReqEmergencySupplyDto reqDto);

    /**
     * 应急物资-删除
     * 
     * @param id
     *            应急物资id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteEmergencySupply(Integer id);

    /**
     * 应急物资-修改
     * 
     * @param reqDto
     *            应急物资接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateEmergencySupply(ReqEmergencySupplyDto reqDto);

    /**
     * 应急物资-详情
     * 
     * @param id
     *            应急物资id
     * @return RspEmergencySupplyDto展示对象
     */
    RspEmergencySupplyDto queryDetail(Integer id);

    /**
     * 应急物资-条件查询
     * 
     * @param reqDto
     *            应急物资接收入参DTO
     * @return RspEmergencySupplyDto展示对象List
     */
    List<RspEmergencySupplyDto> queryList(ReqEmergencySupplyDto reqDto);

    /**
     * 应急物资-分页查询
     * 
     * @param reqDto
     *            应急物资接收入参DTO
     * @return RspEmergencySupplyDto展示对象IPage
     */
    PageInfo<RspEmergencySupplyDto> queryPage(ReqEmergencySupplyDto reqDto);

}
