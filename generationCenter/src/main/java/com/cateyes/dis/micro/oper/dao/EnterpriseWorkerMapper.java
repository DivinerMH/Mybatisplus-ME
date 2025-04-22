package com.cateyes.dis.micro.oper.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseWorkerQueryDto;
import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseWorkerDto;

/**
 * 企业用工(DisEnterpriseWorker)Mapper
 *
 * @author CatEyes
 * @since 2024-02-01 19:30:35
 */
@Mapper
public interface EnterpriseWorkerMapper extends BaseMapper<EnterpriseWorker> {

    /**
     * 详情查询
     * 
     * @param id 企业用工id
     * @return 企业用工展示对象RspEnterpriseWorkerDto
     */
    RspEnterpriseWorkerDto detail(@Param("id") Integer id);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 企业用工分页展示对象集合
     */
    IPage<RspEnterpriseWorkerDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqEnterpriseWorkerQueryDto reqDto);

}
