package com.cateyes.data.govern.bi.service;

import com.cateyes.data.govern.bi.bean.dto.ReqBiParamAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiParamQueryDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiParamUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.RspBiParamDto;

/**
 * 參數(DgBiParam)service
 *
 * @author CatEyes
 * @since 2024-01-23 12:01:19
 */

public interface IBiParamService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqBiParamAddDto reqDto);

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
    int update(ReqBiParamUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspBiParamDto展示对象
     */
    RspBiParamDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspBiParamDto展示对象 PageInfo
     */
    PageInfo<RspBiParamDto> queryPage(ReqBiParamQueryDto reqDto);

}
