package com.cateyes.data.govern.datafill.service;

import com.cateyes.data.govern.datafill.bean.dto.RspDynamicModelFieldDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelFieldAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelFieldUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelFieldQueryDto;

/**
 * 动态表单字段(DgDynamicModelField)service
 *
 * @author CatEyes
 * @since 2023-11-20 13:56:08
 */

public interface IDynamicModelFieldService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqDynamicModelFieldAddDto reqDto);

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
    int update(ReqDynamicModelFieldUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspDynamicModelFieldDto展示对象
     */
    RspDynamicModelFieldDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspDynamicModelFieldDto展示对象 PageInfo
     */
    PageInfo<RspDynamicModelFieldDto> queryPage(ReqDynamicModelFieldQueryDto reqDto);

}
