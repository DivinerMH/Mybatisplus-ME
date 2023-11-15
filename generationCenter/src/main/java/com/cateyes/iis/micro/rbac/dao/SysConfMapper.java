package com.cateyes.iis.micro.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.iis.micro.rbac.bean.dto.ReqSysConfQueryDto;
import com.cateyes.iis.micro.rbac.bean.dto.RspSysConfDto;
import com.cateyes.iis.micro.rbac.bean.po.SysConf;

/**
 * 系统配置表(IisSysConf)Mapper
 *
 * @author CatEyes
 * @since 2023-11-13 13:45:49
 */
@Mapper
public interface SysConfMapper extends BaseMapper<SysConf> {

    /**
     * 详情查询
     * 
     * @param id 系统配置表id
     * @return 系统配置表展示对象RspSysConfDto
     */
    RspSysConfDto detail(@Param("id") Integer id);

    /**
     * 条件查询系统配置表Page
     * 
     * @param page 分页参数
     * @param reqDto 系统配置表接收入参DTO
     * @return 系统配置表展示对象集合RspSysConfDtoList
     */
    IPage<RspSysConfDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqSysConfQueryDto reqDto);

}
