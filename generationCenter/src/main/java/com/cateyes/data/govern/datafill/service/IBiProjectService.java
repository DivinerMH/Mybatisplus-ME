package com.cateyes.data.govern.datafill.service;

import com.cateyes.data.govern.datafill.bean.dto.ReqBiProjectAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqBiProjectQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqBiProjectUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspBiProjectDto;

/**
 * 项目(DgBiProject)service
 *
 * @author CatEyes
 * @since 2023-12-12 16:05:49
 */

public interface IBiProjectService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqBiProjectAddDto reqDto);

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
    int update(ReqBiProjectUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspBiProjectDto展示对象
     */
    RspBiProjectDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspBiProjectDto展示对象 PageInfo
     */
    PageInfo<RspBiProjectDto> queryPage(ReqBiProjectQueryDto reqDto);

}
