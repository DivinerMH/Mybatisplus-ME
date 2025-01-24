package com.sms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sms.bean.dto.ReqSysSmsQueryDto;
import com.sms.bean.dto.RspSysSmsDto;
import com.sms.bean.po.SysSms;

/**
 * 短信表(SysSms)Mapper
 *
 * @author menghuan
 * @since 2025-01-22 09:49:08
 */
@Mapper
public interface SysSmsMapper extends BaseMapper<SysSms> {

    /**
     * 详情查询
     * 
     * @param id 短信表id
     * @return 短信表展示对象RspSysSmsDto
     */
    RspSysSmsDto detail(@Param("id") String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 短信表展示对象集合
     */
    List<RspSysSmsDto> queryByConditions(@Param("reqDto") ReqSysSmsQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 短信表分页展示对象集合
     */
    IPage<RspSysSmsDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqSysSmsQueryDto reqDto);

}
