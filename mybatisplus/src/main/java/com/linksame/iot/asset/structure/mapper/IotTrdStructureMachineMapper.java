package com.linksame.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.dto.IotTrdStructureMachineDTO;
import com.linksame.entity.IotTrdStructureMachine;
import com.linksame.vo.IotTrdStructureMachineVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 3D模型组件与资产结构设备关系(IotTrdStructureMachine)数据库访问层
 *
 * @author menghuan
 * @since 2022-04-19 14:16:48
 */
@Mapper
public interface IotTrdStructureMachineMapper extends BaseMapper<IotTrdStructureMachine> {

    /**
     * 根据id查询3D模型组件与资产结构设备关系详情(多服务)
     *
     * @param id 3D模型组件与资产结构设备关系id
     * @return 3D模型组件与资产结构设备关系展示对象IotTrdStructureMachineVO
     */
    IotTrdStructureMachineVO queryIotTrdStructureMachineDetail(@Param("id") Integer id);

    /**
     * 无参查询3D模型组件与资产结构设备关系List
     *
     * @return 3D模型组件与资产结构设备关系展示对象集合IotTrdStructureMachineVOList
     */
    List<IotTrdStructureMachineVO> queryIotTrdStructureMachineList();

    /**
     * 条件查询3D模型组件与资产结构设备关系List
     *
     * @param iotTrdStructureMachineDTO 3D模型组件与资产结构设备关系接收入参DTO
     * @return 3D模型组件与资产结构设备关系展示对象集合IotTrdStructureMachineVOList
     */
    List<IotTrdStructureMachineVO> queryByConditions(@Param("iotTrdStructureMachineDTO") IotTrdStructureMachineDTO iotTrdStructureMachineDTO);

    /**
     * 分页条件查询3D模型组件与资产结构设备关系Page
     *
     * @param page                      分页参数
     * @param iotTrdStructureMachineDTO 3D模型组件与资产结构设备关系接收入参DTO
     * @return 3D模型组件与资产结构设备关系展示对象集合IotTrdStructureMachineVOList
     */
    IPage<IotTrdStructureMachineVO> queryByConditions(@Param("page") Page page, @Param("iotTrdStructureMachineDTO") IotTrdStructureMachineDTO iotTrdStructureMachineDTO);

}
