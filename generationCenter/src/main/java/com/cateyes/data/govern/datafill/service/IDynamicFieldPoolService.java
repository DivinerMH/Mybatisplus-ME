package com.cateyes.data.govern.datafill.service;

import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldPoolDto;

/**
 * 动态表单字段池(DgDynamicFieldPool)service
 *
 * @author CatEyes
 * @since 2023-11-20 10:50:49
 */

public interface IDynamicFieldPoolService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqDynamicFieldPoolAddDto reqDto);

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
    int update(ReqDynamicFieldPoolUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspDynamicFieldPoolDto展示对象
     */
    RspDynamicFieldPoolDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspDynamicFieldPoolDto展示对象 PageInfo
     */
    PageInfo<RspDynamicFieldPoolDto> queryPage(ReqDynamicFieldPoolQueryDto reqDto);

}
