package com.material.service;

import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.material.bean.dto.RspAfMaterialApplyDto;
import com.material.bean.dto.ReqAfMaterialApplyAddDto;
import com.material.bean.dto.ReqAfMaterialApplyUpdateDto;
import com.material.bean.dto.ReqAfMaterialApplyQueryDto;
import com.material.bean.po.AfMaterialApply;

/**
 * 物料申请(AfMaterialApply)service
 *
 * @author makejava
 * @since 2025-01-14 18:50:40
 */

public interface IAfMaterialApplyService extends IService<AfMaterialApply> {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    String add(ReqAfMaterialApplyAddDto reqDto);

    /**
     * 删除
     * 
     * @param id 主键ID
     * @return Affect rows
     */
    int delete(String id);

    /**
     * 修改
     * 
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int update(ReqAfMaterialApplyUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param id 主键ID
     * @return RspAfMaterialApplyDto展示对象
     */
    RspAfMaterialApplyDto detail(String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 物料申请展示对象集合
     */
    List<RspAfMaterialApplyDto> queryList(ReqAfMaterialApplyQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspAfMaterialApplyDto展示对象 PageInfo
     */
    IPage<RspAfMaterialApplyDto> queryPage(ReqAfMaterialApplyQueryDto reqDto);

}
