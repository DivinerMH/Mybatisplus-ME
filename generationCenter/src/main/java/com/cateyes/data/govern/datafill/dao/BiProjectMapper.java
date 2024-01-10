package com.cateyes.data.govern.datafill.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.RspBiProjectDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqBiProjectQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目(DgBiProject)Mapper
 *
 * @author CatEyes
 * @since 2023-12-12 16:05:48
 */
@Mapper
public interface BiProjectMapper extends BaseMapper<BiProject> {

    /**
     * 详情查询
     * 
     * @param id 项目id
     * @return 项目展示对象RspBiProjectDto
     */
    RspBiProjectDto detail(@Param("id") Integer id);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 项目分页展示对象集合
     */
    IPage<RspBiProjectDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqBiProjectQueryDto reqDto);

}
