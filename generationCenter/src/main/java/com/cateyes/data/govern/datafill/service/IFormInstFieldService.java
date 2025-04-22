package com.cateyes.data.govern.datafill.service;

import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstFieldAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstFieldQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstFieldUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspFormInstFieldDto;

/**
 * 表单实例数据(DgFormInstField)service
 *
 * @author CatEyes
 * @since 2023-11-21 10:16:35
 */

public interface IFormInstFieldService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqFormInstFieldAddDto reqDto);

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
    int update(ReqFormInstFieldUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspFormInstFieldDto展示对象
     */
    RspFormInstFieldDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspFormInstFieldDto展示对象 PageInfo
     */
    PageInfo<RspFormInstFieldDto> queryPage(ReqFormInstFieldQueryDto reqDto);

}
