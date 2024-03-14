package com.cateyes.dis.micro.oper.service;

import com.cateyes.base.dto.ReqIdDto;
import com.cateyes.base.util.PageInfo;
import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseMuBenefitDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseMuBenefitAddDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseMuBenefitUpdateDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseMuBenefitQueryDto;

/**
 * 企业亩均效益(DisEnterpriseMuBenefit)service
 *
 * @author CatEyes
 * @since 2024-02-01 18:31:33
 */

public interface IEnterpriseMuBenefitService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqEnterpriseMuBenefitAddDto reqDto);

    /**
     * 删除
     * 
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int del(ReqIdDto reqDto);

    /**
     * 修改
     * 
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int update(ReqEnterpriseMuBenefitUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspEnterpriseMuBenefitDto展示对象
     */
    RspEnterpriseMuBenefitDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspEnterpriseMuBenefitDto展示对象 PageInfo
     */
    PageInfo<RspEnterpriseMuBenefitDto> queryPage(ReqEnterpriseMuBenefitQueryDto reqDto);

}
