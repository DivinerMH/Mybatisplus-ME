package com.hzcloud.iot.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hzcloud.iot.dto.DangerNodeDTO;
import com.hzcloud.iot.entity.DangerNode;
import com.hzcloud.iot.vo.DangerNodeVO;

import java.util.List;

/**
 * 巡检节点(DangerNode)表服务接口
 *
 * @author MH
 * @since 2020-11-13 15:17:25
 */
public interface IDangerNodeService extends IService<DangerNode> {

    /**
     * 新增巡检节点
     *
     * @param dangerNodeDTO 巡检节点接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveDangerNode(DangerNodeDTO dangerNodeDTO);

    /**
     * 根据id（逻辑）删除巡检节点
     *
     * @param id 巡检节点id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteDangerNode(Integer id);

    /**
     * 修改巡检节点
     *
     * @param dangerNodeDTO 巡检节点接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateDangerNode(DangerNodeDTO dangerNodeDTO);

    /**
     * 根据id查询巡检节点详情（单服务）
     *
     * @param id 巡检节点id
     * @return 巡检节点展示对象
     */
    DangerNodeVO queryDangerNode(Integer id);

    /**
     * 根据id查询巡检节点详情(跨服务)
     *
     * @param id 巡检节点id
     * @return 巡检节点展示对象
     */
    DangerNodeVO queryDangerNodeDetail(Integer id);

    /**
     * 无参查询查询巡检节点列表
     *
     * @return 巡检节点展示对象集合DangerNodeVOList
     */
    List<DangerNodeVO> queryDangerNodeList();

    /**
     * 条件查询查询巡检节点列表
     *
     * @param dangerNodeDTO 巡检节点接收入参DTO
     * @return 巡检节点展示对象集合DangerNodeVOList
     */
    List<DangerNodeVO> queryListByConditions(DangerNodeDTO dangerNodeDTO);

    /**
     * 分页查询查询巡检节点列表
     *
     * @param dangerNodeDTO 巡检节点接收入参DTO
     * @return 巡检节点展示对象集合DangerNodeVOList
     */
    IPage<DangerNodeVO> queryPageByConditions(Page page, DangerNodeDTO dangerNodeDTO);

}