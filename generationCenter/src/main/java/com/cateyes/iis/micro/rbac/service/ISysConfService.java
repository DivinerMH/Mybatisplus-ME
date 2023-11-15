package com.cateyes.iis.micro.rbac.service;

    
    





import com.cateyes.base.dto.ReqIdDto;
import com.cateyes.base.util.PageInfo;
import com.cateyes.iis.micro.rbac.bean.dto.RspSysConfDto;
import com.cateyes.iis.micro.rbac.bean.dto.ReqSysConfAddDto;
import com.cateyes.iis.micro.rbac.bean.dto.ReqSysConfUpdateDto;
import com.cateyes.iis.micro.rbac.bean.dto.ReqSysConfQueryDto;

/**
 * 系统配置表(IisSysConf)service
 *
 * @author CatEyes
 * @since 2023-11-13 13:45:51
 */

public interface ISysConfService {

    /**
     * 新增
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqSysConfAddDto reqDto);

    /**
     * 删除
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int del(ReqIdDto reqDto);

    /**
     * 修改
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int update(ReqSysConfUpdateDto reqDto);

    /**
     * 详情
     * @param reqDto 入参DTO
     * @return RspSysConfDto展示对象
     */
    RspSysConfDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * @param reqDto 入参DTO
     * @return RspSysConfDto展示对象 PageInfo
     */
    PageInfo<RspSysConfDto> queryPage(ReqSysConfQueryDto reqDto);
    
}
