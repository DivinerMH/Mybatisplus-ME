package com.dfzl.sms.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfzl.sms.bean.dto.ReqSysSmsAddDto;
import com.dfzl.sms.bean.dto.ReqSysSmsQueryDto;
import com.dfzl.sms.bean.dto.ReqSysSmsUpdateDto;
import com.dfzl.sms.bean.dto.RspSysSmsDto;
import com.dfzl.sms.bean.po.SysSms;

/**
 * 短信表(SysSms)service
 *
 * @author menghuan
 * @since 2025-01-22 09:49:08
 */

public interface ISysSmsService extends IService<SysSms> {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    String add(ReqSysSmsAddDto reqDto);

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
    int update(ReqSysSmsUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param id 主键ID
     * @return RspSysSmsDto展示对象
     */
    RspSysSmsDto detail(String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 短信表展示对象集合
     */
    List<RspSysSmsDto> queryList(ReqSysSmsQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspSysSmsDto展示对象 PageInfo
     */
    IPage<RspSysSmsDto> queryPage(ReqSysSmsQueryDto reqDto);

}
