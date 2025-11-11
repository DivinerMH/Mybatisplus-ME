package com.dfzl.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dfzl.system.bean.dto.ReqSysAnnouncementQueryDto;
import com.dfzl.system.bean.dto.RspSysAnnouncementDto;
import com.dfzl.system.bean.po.SysAnnouncement;

/**
 * 系统通告表(SysAnnouncement)Mapper
 *
 * @author menghuan
 * @since 2025-09-11 15:01:56
 */
@Mapper
public interface SysAnnouncementMapper extends BaseMapper<SysAnnouncement> {

    /**
     * 详情查询
     * 
     * @param id 系统通告表id
     * @return 系统通告表展示对象RspSysAnnouncementDto
     */
    RspSysAnnouncementDto detail(@Param("id") String id);

    /**
     * 条件查询
     * 
     * @param reqDto 入参DTO
     * @return 系统通告表展示对象集合
     */
    List<RspSysAnnouncementDto> queryByConditions(@Param("reqDto") ReqSysAnnouncementQueryDto reqDto);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 系统通告表分页展示对象集合
     */
    IPage<RspSysAnnouncementDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqSysAnnouncementQueryDto reqDto);

}
