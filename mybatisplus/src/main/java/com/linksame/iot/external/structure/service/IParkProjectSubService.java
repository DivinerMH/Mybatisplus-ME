package com.linksame.iot.external.structure.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.iot.external.structure.dto.ParkProjectSubDTO;
import com.linksame.iot.external.structure.entity.ParkProjectSub;
import com.linksame.iot.external.structure.vo.ParkProjectSubVO;

import java.util.List;

/**
 * 资源管理-项目分期表(ParkProjectSub)表服务接口
 *
 * @author menghuan
 * @since 2022-03-11 15:39:04
 */
public interface IParkProjectSubService extends IService<ParkProjectSub> {

    /**
     * 新增资源管理-项目分期表
     *
     * @param parkProjectSubDTO 资源管理-项目分期表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveParkProjectSub(ParkProjectSubDTO parkProjectSubDTO);

    /**
     * 根据id（逻辑）删除资源管理-项目分期表
     *
     * @param id 资源管理-项目分期表id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteParkProjectSub(Integer id);

    /**
     * 修改资源管理-项目分期表
     *
     * @param parkProjectSubDTO 资源管理-项目分期表接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateParkProjectSub(ParkProjectSubDTO parkProjectSubDTO);

    /**
     * 根据id查询资源管理-项目分期表详情(单服务)
     *
     * @param id 资源管理-项目分期表id
     * @return 资源管理-项目分期表展示对象
     */
    ParkProjectSubVO queryParkProjectSub(Integer id);

    /**
     * 根据id查询资源管理-项目分期表详情(多服务)
     *
     * @param id 资源管理-项目分期表id
     * @return 资源管理-项目分期表展示对象
     */
    ParkProjectSubVO queryParkProjectSubDetail(Integer id);

    /**
     * 无参查询资源管理-项目分期表列表
     *
     * @return 资源管理-项目分期表展示对象集合ParkProjectSubVOList
     */
    List<ParkProjectSubVO> queryParkProjectSubList();

    /**
     * 条件查询资源管理-项目分期表列表
     *
     * @param parkProjectSubDTO 资源管理-项目分期表接收入参DTO
     * @return 资源管理-项目分期表展示对象集合ParkProjectSubVOList
     */
    List<ParkProjectSubVO> queryListByConditions(ParkProjectSubDTO parkProjectSubDTO);

    /**
     * 分页条件查询资源管理-项目分期表列表
     *
     * @param parkProjectSubDTO 资源管理-项目分期表接收入参DTO
     * @return 资源管理-项目分期表展示对象集合ParkProjectSubVOList
     */
    IPage<ParkProjectSubVO> queryPageByConditions(Page page, ParkProjectSubDTO parkProjectSubDTO);

}
