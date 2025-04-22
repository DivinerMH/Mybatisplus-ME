package com.cateyes.data.govern.bi.service;

import com.cateyes.data.govern.bi.bean.dto.ReqBiDatasetFieldAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiDatasetFieldQueryDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiDatasetFieldUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.RspBiDatasetFieldDto;

/**
 * 数据集-字段管理(DgBiDatasetField)service
 *
 * @author CatEyes
 * @since 2023-12-21 14:40:45
 */

public interface IBiDatasetFieldService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqBiDatasetFieldAddDto reqDto);

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
    int update(ReqBiDatasetFieldUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspBiDatasetFieldDto展示对象
     */
    RspBiDatasetFieldDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspBiDatasetFieldDto展示对象 PageInfo
     */
    PageInfo<RspBiDatasetFieldDto> queryPage(ReqBiDatasetFieldQueryDto reqDto);

}
