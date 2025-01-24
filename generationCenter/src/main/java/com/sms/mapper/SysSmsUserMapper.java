package com.sms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sms.bean.dto.ReqSysSmsUserQueryDto;
import com.sms.bean.dto.RspSysSmsUserDto;
import com.sms.bean.po.SysSmsUser;

/**
 * 短信发送用户表(SysSmsUser)Mapper
 *
 * @author makejava
 * @since 2025-01-15 15:48:28
 */
@Mapper
public interface SysSmsUserMapper extends BaseMapper<SysSmsUser> {

    /**
     * 详情查询
     * 
     * @param id 短信发送用户表id
     * @return 短信发送用户表展示对象RspSysSmsUserDto
     */
    RspSysSmsUserDto detail(@Param("id") String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 短信发送用户表展示对象集合
     */
    List<RspSysSmsUserDto> queryByConditions(@Param("reqDto") ReqSysSmsUserQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 短信发送用户表分页展示对象集合
     */
    IPage<RspSysSmsUserDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqSysSmsUserQueryDto reqDto);

}
