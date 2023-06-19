package com.cateyes.smart.park.safe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.safe.bean.dto.RspemergencyEvacuateDto;
import com.cateyes.smart.park.safe.bean.dto.ReqemergencyEvacuateDto;
import com.cateyes.smart.park.safe.bean.po.emergencyEvacuate;

/**
 * 应急疏散表(SpSfEmergencyEvacuate)service
 *
 * @author CatEyes
 * @since 2023-06-07 17:27:55
 */

public interface IEmergencyEvacuateService extends IService<EmergencyEvacuate> {

    /**
     * 应急疏散表-新增
     * 
     * @param reqDto
     *            应急疏散表接收入参DTO
     * @return 主键ID
     */
    int saveEmergencyEvacuate(ReqEmergencyEvacuateDto reqDto);

    /**
     * 应急疏散表-删除
     * 
     * @param id
     *            应急疏散表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteEmergencyEvacuate(Integer id);

    /**
     * 应急疏散表-修改
     * 
     * @param reqDto
     *            应急疏散表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateEmergencyEvacuate(ReqEmergencyEvacuateDto reqDto);

    /**
     * 应急疏散表-详情
     * 
     * @param id
     *            应急疏散表id
     * @return RspEmergencyEvacuateDto展示对象
     */
    RspEmergencyEvacuateDto queryDetail(Integer id);

    /**
     * 应急疏散表-条件查询
     * 
     * @param reqDto
     *            应急疏散表接收入参DTO
     * @return RspEmergencyEvacuateDto展示对象List
     */
    List<RspEmergencyEvacuateDto> queryList(ReqEmergencyEvacuateDto reqDto);

    /**
     * 应急疏散表-分页查询
     * 
     * @param reqDto
     *            应急疏散表接收入参DTO
     * @return RspEmergencyEvacuateDto展示对象IPage
     */
    PageInfo<RspEmergencyEvacuateDto> queryPage(ReqEmergencyEvacuateDto reqDto);

}
