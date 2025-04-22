package com.cateyes.dis.micro.oper.service;

import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseTechAchieveAddDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseTechAchieveQueryDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseTechAchieveUpdateDto;
import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseTechAchieveDto;

/**
 * 企业科技成果(DisEnterpriseTechAchieve)service
 *
 * @author CatEyes
 * @since 2024-02-01 19:22:46
 */

public interface IEnterpriseTechAchieveService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqEnterpriseTechAchieveAddDto reqDto);

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
    int update(ReqEnterpriseTechAchieveUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspEnterpriseTechAchieveDto展示对象
     */
    RspEnterpriseTechAchieveDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspEnterpriseTechAchieveDto展示对象 PageInfo
     */
    PageInfo<RspEnterpriseTechAchieveDto> queryPage(ReqEnterpriseTechAchieveQueryDto reqDto);

}
