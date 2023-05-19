package com.cateyes.smart.park.resource.dao;

    
    







import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.resource.bean.dto.RspspEnterpriseOutputDto;
import com.cateyes.smart.park.resource.bean.po.spEnterpriseOutput;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业产值(SpEnterpriseOutput)Mapper
 *
 * @author CatEyes
 * @since 2023-05-19 10:23:19
 */
@Mapper
public interface SpEnterpriseOutput extends BaseMapper<spEnterpriseOutput> {

    /**
     * 根据id查询企业产值详情(跨服务)
     * @param id 企业产值id
     * @return 企业产值展示对象RspspEnterpriseOutputDto
     */
    RspspEnterpriseOutputDto queryDetail(@Param("id") Integer id);

    /**
     * 条件查询企业产值List
     * @param reqDto 企业产值接收入参DTO
     * @return 企业产值展示对象集合RspspEnterpriseOutputDtoList
     */
    List<RspspEnterpriseOutputDto> queryByConditions(@Param("reqDto") ReqspEnterpriseOutputDto reqDto);

    /**
     * 条件查询企业产值Page
     * @param page 分页参数
     * @param reqDto 企业产值接收入参DTO
     * @return 企业产值展示对象集合RspspEnterpriseOutputDtoList
     */
    IPage<RspspEnterpriseOutputDto> queryByConditions(@Param("page")Page page, @Param("reqDto") ReqspEnterpriseOutputDto reqDto);
    
}
