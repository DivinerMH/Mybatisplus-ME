package com.dfzl.system.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dfzl.system.bean.dto.ReqSysAnnouncementAddDto;
import com.dfzl.system.bean.dto.ReqSysAnnouncementQueryDto;
import com.dfzl.system.bean.dto.ReqSysAnnouncementUpdateDto;
import com.dfzl.system.bean.dto.RspSysAnnouncementDto;
import com.dfzl.system.bean.po.SysAnnouncement;

/**
 * 系统通告表(SysAnnouncement)service
 *
 * @author menghuan
 * @since 2025-09-11 15:01:57
 */

public interface ISysAnnouncementService extends IService<SysAnnouncement> {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    String add(ReqSysAnnouncementAddDto reqDto);

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
    int update(ReqSysAnnouncementUpdateDto reqDto);

    /**
     * 修改-状态
     *
     * @param reqDto 入参Dto
     **/
    // void updateStatus(ReqIdsTypeDto reqDto);

    /**
     * 详情
     * 
     * @param id 主键ID
     * @return RspSysAnnouncementDto展示对象
     */
    RspSysAnnouncementDto detail(String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 系统通告表展示对象集合
     */
    List<RspSysAnnouncementDto> queryList(ReqSysAnnouncementQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspSysAnnouncementDto展示对象 PageInfo
     */
    IPage<RspSysAnnouncementDto> queryPage(ReqSysAnnouncementQueryDto reqDto);

}
