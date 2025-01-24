package com.sms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sms.bean.dto.ReqSysSmsTemplateCategoryQueryDto;
import com.sms.bean.dto.RspSysSmsTemplateCategoryDto;
import com.sms.bean.po.SysSmsTemplateCategory;

/**
 * 短信模板分类(SysSmsTemplateCategory)Mapper
 *
 * @author makejava
 * @since 2025-01-15 15:47:55
 */
@Mapper
public interface SysSmsTemplateCategoryMapper extends BaseMapper<SysSmsTemplateCategory> {

    /**
     * 详情查询
     * 
     * @param id 短信模板分类id
     * @return 短信模板分类展示对象RspSysSmsTemplateCategoryDto
     */
    RspSysSmsTemplateCategoryDto detail(@Param("id") String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 短信模板分类展示对象集合
     */
    List<RspSysSmsTemplateCategoryDto> queryByConditions(@Param("reqDto") ReqSysSmsTemplateCategoryQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 短信模板分类分页展示对象集合
     */
    IPage<RspSysSmsTemplateCategoryDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqSysSmsTemplateCategoryQueryDto reqDto);

}
