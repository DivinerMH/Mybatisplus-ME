package com.dfzl.sms.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfzl.sms.bean.dto.ReqSysSmsUserAddDto;
import com.dfzl.sms.bean.dto.ReqSysSmsUserQueryDto;
import com.dfzl.sms.bean.dto.ReqSysSmsUserUpdateDto;
import com.dfzl.sms.bean.dto.RspSysSmsUserDto;
import com.dfzl.sms.bean.po.SysSmsUser;

/**
 * 短信发送用户表(SysSmsUser)service
 *
 * @author makejava
 * @since 2025-01-15 15:48:28
 */

public interface ISysSmsUserService extends IService<SysSmsUser> {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    String add(ReqSysSmsUserAddDto reqDto);

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
    int update(ReqSysSmsUserUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param id 主键ID
     * @return RspSysSmsUserDto展示对象
     */
    RspSysSmsUserDto detail(String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 短信发送用户表展示对象集合
     */
    List<RspSysSmsUserDto> queryList(ReqSysSmsUserQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspSysSmsUserDto展示对象 PageInfo
     */
    IPage<RspSysSmsUserDto> queryPage(ReqSysSmsUserQueryDto reqDto);

}
