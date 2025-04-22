package com.dfzl.sms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dfzl.sms.bean.dto.ReqSysSmsTemplateQueryDto;
import com.dfzl.sms.bean.dto.RspSysSmsTemplateDto;
import com.dfzl.sms.bean.po.SysSmsTemplate;

/**
 * 短信模版表(SysSmsTemplate)Mapper
 *
 * @author makejava
 * @since 2025-01-15 15:47:04
 */
@Mapper
public interface SysSmsTemplateMapper extends BaseMapper<SysSmsTemplate> {

    /**
     * 详情查询
     * 
     * @param id 短信模版表id
     * @return 短信模版表展示对象RspSysSmsTemplateDto
     */
    RspSysSmsTemplateDto detail(@Param("id") String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 短信模版表展示对象集合
     */
    List<RspSysSmsTemplateDto> queryByConditions(@Param("reqDto") ReqSysSmsTemplateQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 短信模版表分页展示对象集合
     */
    IPage<RspSysSmsTemplateDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqSysSmsTemplateQueryDto reqDto);

}
