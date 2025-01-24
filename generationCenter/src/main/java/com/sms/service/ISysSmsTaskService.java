package com.sms.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sms.bean.dto.ReqSysSmsTaskAddDto;
import com.sms.bean.dto.ReqSysSmsTaskQueryDto;
import com.sms.bean.dto.ReqSysSmsTaskUpdateDto;
import com.sms.bean.dto.RspSysSmsTaskDto;
import com.sms.bean.po.SysSmsTask;

/**
 * 短信发送任务表(SysSmsTask)service
 *
 * @author makejava
 * @since 2025-01-15 15:46:31
 */

public interface ISysSmsTaskService extends IService<SysSmsTask> {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    String add(ReqSysSmsTaskAddDto reqDto);

    /**
     * 删除
     * 
     * @param id 主键ID
     * @return Affect rows
     */
    int delete(String id);

    /**
     * 修改
     * 
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int update(ReqSysSmsTaskUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param id 主键ID
     * @return RspSysSmsTaskDto展示对象
     */
    RspSysSmsTaskDto detail(String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 短信发送任务表展示对象集合
     */
    List<RspSysSmsTaskDto> queryList(ReqSysSmsTaskQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspSysSmsTaskDto展示对象 PageInfo
     */
    IPage<RspSysSmsTaskDto> queryPage(ReqSysSmsTaskQueryDto reqDto);

}
