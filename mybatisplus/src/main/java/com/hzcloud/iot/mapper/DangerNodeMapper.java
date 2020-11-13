package com.hzcloud.iot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzcloud.iot.dto.DangerNodeDTO;
import com.hzcloud.iot.entity.DangerNode;
import com.hzcloud.iot.vo.DangerNodeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡检节点(DangerNode)数据库访问层
 *
 * @author MH
 * @since 2020-11-13 15:17:25
 */
public interface DangerNodeMapper extends BaseMapper<DangerNode> {

    /**
     * 根据id查询巡检节点详情(跨服务)
     *
     * @param id 巡检节点id
     * @return 巡检节点展示对象DangerNodeVO
     */
    DangerNodeVO queryDangerNodeDetail(@Param("id") Integer id);

    /**
     * 无参查询巡检节点List
     *
     * @return 资巡检节点展示对象集合DangerNodeVOList
     */
    List<DangerNodeVO> queryDangerNodeList();

    /**
     * 条件查询巡检节点List
     *
     * @param dangerNodeDTO 巡检节点接收入参DTO
     * @return 巡检节点展示对象集合DangerNodeVOList
     */
    List<DangerNodeVO> queryByConditions(@Param("dangerNodeDTO") DangerNodeDTO dangerNodeDTO);

    /**
     * 条件查询巡检节点Page
     *
     * @param page          分页参数
     * @param dangerNodeDTO 巡检节点接收入参DTO
     * @return 巡检节点展示对象集合DangerNodeVOList
     */
    IPage<DangerNodeVO> queryByConditions(@Param("page") Page page, @Param("dangerNodeDTO") DangerNodeDTO dangerNodeDTO);

}