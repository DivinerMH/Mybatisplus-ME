package com.cateyes.data.govern.datafill.service;

import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicModelDto;

/**
 * 动态表单模型(DgDynamicModel)service
 *
 * @author CatEyes
 * @since 2023-11-20 13:55:44
 */

public interface IDynamicModelService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqDynamicModelAddDto reqDto);

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
    int update(ReqDynamicModelUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspDynamicModelDto展示对象
     */
    RspDynamicModelDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspDynamicModelDto展示对象 PageInfo
     */
    PageInfo<RspDynamicModelDto> queryPage(ReqDynamicModelQueryDto reqDto);

}
