package com.sms.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sms.bean.dto.ReqSysSmsTemplateAddDto;
import com.sms.bean.dto.ReqSysSmsTemplateQueryDto;
import com.sms.bean.dto.ReqSysSmsTemplateUpdateDto;
import com.sms.bean.dto.RspSysSmsTemplateDto;
import com.sms.bean.po.SysSmsTemplate;

/**
 * 短信模版表(SysSmsTemplate)service
 *
 * @author makejava
 * @since 2025-01-15 15:47:04
 */

public interface ISysSmsTemplateService extends IService<SysSmsTemplate> {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    String add(ReqSysSmsTemplateAddDto reqDto);

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
    int update(ReqSysSmsTemplateUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param id 主键ID
     * @return RspSysSmsTemplateDto展示对象
     */
    RspSysSmsTemplateDto detail(String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 短信模版表展示对象集合
     */
    List<RspSysSmsTemplateDto> queryList(ReqSysSmsTemplateQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspSysSmsTemplateDto展示对象 PageInfo
     */
    IPage<RspSysSmsTemplateDto> queryPage(ReqSysSmsTemplateQueryDto reqDto);

}
