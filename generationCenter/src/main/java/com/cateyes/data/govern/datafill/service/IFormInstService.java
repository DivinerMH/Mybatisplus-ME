package com.cateyes.data.govern.datafill.service;

import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspFormInstDto;

/**
 * 表单实例(DgFormInst)service
 *
 * @author CatEyes
 * @since 2023-11-21 10:16:01
 */

public interface IFormInstService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqFormInstAddDto reqDto);

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
    int update(ReqFormInstUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspFormInstDto展示对象
     */
    RspFormInstDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspFormInstDto展示对象 PageInfo
     */
    PageInfo<RspFormInstDto> queryPage(ReqFormInstQueryDto reqDto);

}
