package com.cateyes.smart.park.resource.service;

    
    





import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.smart.park.resource.bean.dto.RspspEnterpriseOutputDto;
import com.cateyes.smart.park.resource.bean.dto.ReqspEnterpriseOutputDto;
import com.cateyes.smart.park.resource.bean.po.spEnterpriseOutput;

/**
 * 企业产值(SpEnterpriseOutput)service
 *
 * @author CatEyes
 * @since 2023-05-19 10:23:20
 */

public interface ISpEnterpriseOutputService extends IService<SpEnterpriseOutput> {

    /**
     * 企业产值-新增
     * @param reqDto 企业产值接收入参DTO
     * @return 主键ID
     */
    int saveSpEnterpriseOutput(ReqSpEnterpriseOutputDto reqDto);

    /**
     * 企业产值-删除
     * @param id 企业产值id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteSpEnterpriseOutput(Integer id);

    /**
     * 企业产值-修改
     * @param reqDto 企业产值接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateSpEnterpriseOutput(ReqSpEnterpriseOutputDto reqDto);

    /**
     * 企业产值-详情
     * @param id 企业产值id
     * @return RspSpEnterpriseOutputDto展示对象
     */
    RspSpEnterpriseOutputDto queryDetail(Integer id);

    /**
     * 企业产值-条件查询
     * @param reqDto 企业产值接收入参DTO
     * @return RspSpEnterpriseOutputDto展示对象List
     */
    List<RspSpEnterpriseOutputDto> queryList(ReqSpEnterpriseOutputDto reqDto);

    /**
     * 企业产值-分页查询
     * @param reqDto 企业产值接收入参DTO
     * @return RspSpEnterpriseOutputDto展示对象IPage
     */
    PageInfo<RspSpEnterpriseOutputDto> queryPage(ReqSpEnterpriseOutputDto reqDto);

}
