package com.linksame.iot.external.structure.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.iot.external.structure.dto.ParkProjectSubDTO;
import com.linksame.iot.external.structure.entity.ParkProjectSub;
import com.linksame.iot.external.structure.vo.ParkProjectSubVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源管理-项目分期表(ParkProjectSub)数据库访问层
 *
 * @author menghuan
 * @since 2022-03-11 15:39:03
 */
@Mapper
public interface ParkProjectSubMapper extends BaseMapper<ParkProjectSub> {

    /**
     * 根据id查询资源管理-项目分期表详情(多服务)
     *
     * @param id 资源管理-项目分期表id
     * @return 资源管理-项目分期表展示对象ParkProjectSubVO
     */
    ParkProjectSubVO queryParkProjectSubDetail(@Param("id") Integer id);

    /**
     * 无参查询资源管理-项目分期表List
     *
     * @return 资源管理-项目分期表展示对象集合ParkProjectSubVOList
     */
    List<ParkProjectSubVO> queryParkProjectSubList();

    /**
     * 条件查询资源管理-项目分期表List
     *
     * @param parkProjectSubDTO 资源管理-项目分期表接收入参DTO
     * @return 资源管理-项目分期表展示对象集合ParkProjectSubVOList
     */
    List<ParkProjectSubVO> queryByConditions(@Param("parkProjectSubDTO") ParkProjectSubDTO parkProjectSubDTO);

    /**
     * 分页条件查询资源管理-项目分期表Page
     *
     * @param page              分页参数
     * @param parkProjectSubDTO 资源管理-项目分期表接收入参DTO
     * @return 资源管理-项目分期表展示对象集合ParkProjectSubVOList
     */
    IPage<ParkProjectSubVO> queryByConditions(@Param("page") Page page, @Param("parkProjectSubDTO") ParkProjectSubDTO parkProjectSubDTO);

}
