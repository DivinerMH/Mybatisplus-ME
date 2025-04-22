package com.dfzl.material.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dfzl.material.bean.dto.ReqAfMaterialApplyQueryDto;
import com.dfzl.material.bean.dto.RspAfMaterialApplyDto;
import com.dfzl.material.bean.po.AfMaterialApply;

/**
 * 物料申请(AfMaterialApply)Mapper
 *
 * @author makejava
 * @since 2025-01-14 18:44:33
 */
@Mapper
public interface AfMaterialApplyMapper extends BaseMapper<AfMaterialApply> {

    /**
     * 详情查询
     * 
     * @param id 物料申请id
     * @return 物料申请展示对象RspAfMaterialApplyDto
     */
    RspAfMaterialApplyDto detail(@Param("id") String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 物料申请展示对象集合
     */
    List<RspAfMaterialApplyDto> queryByConditions(@Param("reqDto") ReqAfMaterialApplyQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 物料申请分页展示对象集合
     */
    IPage<RspAfMaterialApplyDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqAfMaterialApplyQueryDto reqDto);

}
