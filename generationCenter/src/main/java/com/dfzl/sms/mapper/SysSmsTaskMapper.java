package com.dfzl.sms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dfzl.sms.bean.dto.ReqSysSmsTaskQueryDto;
import com.dfzl.sms.bean.dto.RspSysSmsTaskDto;
import com.dfzl.sms.bean.po.SysSmsTask;

/**
 * 短信发送任务表(SysSmsTask)Mapper
 *
 * @author makejava
 * @since 2025-01-15 15:46:31
 */
@Mapper
public interface SysSmsTaskMapper extends BaseMapper<SysSmsTask> {

    /**
     * 详情查询
     * 
     * @param id 短信发送任务表id
     * @return 短信发送任务表展示对象RspSysSmsTaskDto
     */
    RspSysSmsTaskDto detail(@Param("id") String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 短信发送任务表展示对象集合
     */
    List<RspSysSmsTaskDto> queryByConditions(@Param("reqDto") ReqSysSmsTaskQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 短信发送任务表分页展示对象集合
     */
    IPage<RspSysSmsTaskDto> queryByConditions(@Param("page") Page page, @Param("reqDto") ReqSysSmsTaskQueryDto reqDto);

}
