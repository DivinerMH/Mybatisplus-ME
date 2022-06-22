package com.linksame.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.dto.IotTrdStructureMachineDTO;
import com.linksame.entity.IotTrdStructureMachine;
import com.linksame.vo.IotTrdStructureMachineVO;

import java.util.List;

/**
 * 3D模型组件与资产结构设备关系(IotTrdStructureMachine)表服务接口
 *
 * @author menghuan
 * @since 2022-04-19 14:16:49
 */
public interface IIotTrdStructureMachineService extends IService<IotTrdStructureMachine> {

    /**
     * 新增3D模型组件与资产结构设备关系
     *
     * @param iotTrdStructureMachineDTO 3D模型组件与资产结构设备关系接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveIotTrdStructureMachine(IotTrdStructureMachineDTO iotTrdStructureMachineDTO);

    /**
     * 根据id（逻辑）删除3D模型组件与资产结构设备关系
     *
     * @param id 3D模型组件与资产结构设备关系id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteIotTrdStructureMachine(Integer id);

    /**
     * 修改3D模型组件与资产结构设备关系
     *
     * @param iotTrdStructureMachineDTO 3D模型组件与资产结构设备关系接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateIotTrdStructureMachine(IotTrdStructureMachineDTO iotTrdStructureMachineDTO);

    /**
     * 根据id查询3D模型组件与资产结构设备关系详情(单服务)
     *
     * @param id 3D模型组件与资产结构设备关系id
     * @return 3D模型组件与资产结构设备关系展示对象
     */
    IotTrdStructureMachineVO queryIotTrdStructureMachine(Integer id);

    /**
     * 根据id查询3D模型组件与资产结构设备关系详情(多服务)
     *
     * @param id 3D模型组件与资产结构设备关系id
     * @return 3D模型组件与资产结构设备关系展示对象
     */
    IotTrdStructureMachineVO queryIotTrdStructureMachineDetail(Integer id);

    /**
     * 无参查询3D模型组件与资产结构设备关系列表
     *
     * @return 3D模型组件与资产结构设备关系展示对象集合IotTrdStructureMachineVOList
     */
    List<IotTrdStructureMachineVO> queryIotTrdStructureMachineList();

    /**
     * 条件查询3D模型组件与资产结构设备关系列表
     *
     * @param iotTrdStructureMachineDTO 3D模型组件与资产结构设备关系接收入参DTO
     * @return 3D模型组件与资产结构设备关系展示对象集合IotTrdStructureMachineVOList
     */
    List<IotTrdStructureMachineVO> queryListByConditions(IotTrdStructureMachineDTO iotTrdStructureMachineDTO);

    /**
     * 分页条件查询3D模型组件与资产结构设备关系列表
     *
     * @param iotTrdStructureMachineDTO 3D模型组件与资产结构设备关系接收入参DTO
     * @return 3D模型组件与资产结构设备关系展示对象集合IotTrdStructureMachineVOList
     */
    IPage<IotTrdStructureMachineVO> queryPageByConditions(Page page, IotTrdStructureMachineDTO iotTrdStructureMachineDTO);

}
