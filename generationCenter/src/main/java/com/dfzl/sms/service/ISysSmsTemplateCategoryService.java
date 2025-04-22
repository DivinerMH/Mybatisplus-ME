package com.dfzl.sms.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfzl.sms.bean.dto.ReqSysSmsTemplateCategoryAddDto;
import com.dfzl.sms.bean.dto.ReqSysSmsTemplateCategoryQueryDto;
import com.dfzl.sms.bean.dto.ReqSysSmsTemplateCategoryUpdateDto;
import com.dfzl.sms.bean.dto.RspSysSmsTemplateCategoryDto;
import com.dfzl.sms.bean.po.SysSmsTemplateCategory;

/**
 * 短信模板分类(SysSmsTemplateCategory)service
 *
 * @author makejava
 * @since 2025-01-15 15:47:55
 */

public interface ISysSmsTemplateCategoryService extends IService<SysSmsTemplateCategory> {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    String add(ReqSysSmsTemplateCategoryAddDto reqDto);

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
    int update(ReqSysSmsTemplateCategoryUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param id 主键ID
     * @return RspSysSmsTemplateCategoryDto展示对象
     */
    RspSysSmsTemplateCategoryDto detail(String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 短信模板分类展示对象集合
     */
    List<RspSysSmsTemplateCategoryDto> queryList(ReqSysSmsTemplateCategoryQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspSysSmsTemplateCategoryDto展示对象 PageInfo
     */
    IPage<RspSysSmsTemplateCategoryDto> queryPage(ReqSysSmsTemplateCategoryQueryDto reqDto);

}
