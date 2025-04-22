package com.cateyes.dis.micro.oper.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseMuBenefitQueryDto;
import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseMuBenefitDto;

/**
 * 企业亩均效益(DisEnterpriseMuBenefit)Mapper
 *
 * @author CatEyes
 * @since 2024-02-01 18:31:31
 */
@Mapper
public interface EnterpriseMuBenefitMapper extends BaseMapper<EnterpriseMuBenefit> {

    /**
     * 详情查询
     * 
     * @param id 企业亩均效益id
     * @return 企业亩均效益展示对象RspEnterpriseMuBenefitDto
     */
    RspEnterpriseMuBenefitDto detail(@Param("id") Integer id);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 企业亩均效益分页展示对象集合
     */
    IPage<RspEnterpriseMuBenefitDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqEnterpriseMuBenefitQueryDto reqDto);

}
