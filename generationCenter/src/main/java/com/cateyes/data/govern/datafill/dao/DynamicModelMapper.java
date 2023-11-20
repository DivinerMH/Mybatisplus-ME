package com.cateyes.data.govern.datafill.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicModelDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 动态表单模型(DgDynamicModel)Mapper
 *
 * @author CatEyes
 * @since 2023-11-20 13:55:43
 */
@Mapper
public interface DynamicModelMapper extends BaseMapper<DynamicModel> {

    /**
     * 详情查询
     * 
     * @param id 动态表单模型id
     * @return 动态表单模型展示对象RspDynamicModelDto
     */
    RspDynamicModelDto detail(@Param("id") Integer id);

    /**
     * 条件查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 动态表单模型分页展示对象集合
     */
    IPage<RspDynamicModelDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqDynamicModelQueryDto reqDto);

}
