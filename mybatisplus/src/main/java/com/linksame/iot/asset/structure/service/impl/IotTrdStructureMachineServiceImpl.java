package com.linksame.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.linksame.entity.IotTrdStructureMachine;
import com.linksame.vo.IotTrdStructureMachineVO;
import com.linksame.dto.IotTrdStructureMachineDTO;
import com.linksame.mapper.IotTrdStructureMachineMapper;
import com.linksame.service.IIotTrdStructureMachineService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 3D模型组件与资产结构设备关系(IotTrdStructureMachine)表服务实现类
 *
 * @author menghuan
 * @since 2022-04-19 14:16:49
 */
@AllArgsConstructor
@Service
@Slf4j
public class IotTrdStructureMachineServiceImpl extends ServiceImpl<IotTrdStructureMachineMapper, IotTrdStructureMachine> implements IIotTrdStructureMachineService {

    private final IotTrdStructureMachineMapper iotTrdStructureMachineMapper;

    @Override
    public Boolean saveIotTrdStructureMachine(IotTrdStructureMachineDTO iotTrdStructureMachineDTO) {
        // 校验：名称是否重复
        checkNameUnity(iotTrdStructureMachineDTO);
        // 业务逻辑
        IotTrdStructureMachine iotTrdStructureMachine = new IotTrdStructureMachine();
        BeanUtils.copyProperties(iotTrdStructureMachineDTO, iotTrdStructureMachine);
        iotTrdStructureMachine.setStatus(CommonConstants.STATUS_NORMAL);
        iotTrdStructureMachine.setDelFlag(CommonConstants.STATUS_NORMAL);
        iotTrdStructureMachine.setCreateTime(LocalDateTime.now());
        iotTrdStructureMachine.setUpdateTime(iotTrdStructureMachine.getCreateTime());
        baseMapper.insert(iotTrdStructureMachine);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteIotTrdStructureMachine(Integer id) {
        // 校验：资源是否存在
        checkResource(id);
        // 业务逻辑
        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateIotTrdStructureMachine(IotTrdStructureMachineDTO iotTrdStructureMachineDTO) {
        // 校验：名称是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(iotTrdStructureMachineDTO.getName())) {
            checkNameUnity(iotTrdStructureMachineDTO);
        }
        // 业务逻辑
        IotTrdStructureMachine iotTrdStructureMachine = new IotTrdStructureMachine();
        BeanUtils.copyProperties(iotTrdStructureMachineDTO, iotTrdStructureMachine);
        iotTrdStructureMachine.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(iotTrdStructureMachine);
        return Boolean.TRUE;
    }

    @Override
    public IotTrdStructureMachineVO queryIotTrdStructureMachine(Integer id) {
        IotTrdStructureMachine iotTrdStructureMachine = iotTrdStructureMachineMapper.selectById(id);
        if (null == iotTrdStructureMachine) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        IotTrdStructureMachineVO iotTrdStructureMachineVO = new IotTrdStructureMachineVO();
        BeanUtils.copyProperties(iotTrdStructureMachine, iotTrdStructureMachineVO);
        return iotTrdStructureMachineVO;
    }

    @Override
    public IotTrdStructureMachineVO queryIotTrdStructureMachineDetail(Integer id) {
        IotTrdStructureMachineVO iotTrdStructureMachineVO = iotTrdStructureMachineMapper.queryIotTrdStructureMachineDetail(id);
        if (null == iotTrdStructureMachineVO) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return iotTrdStructureMachineVO;
    }

    @Override
    public List<IotTrdStructureMachineVO> queryIotTrdStructureMachineList() {
        List<IotTrdStructureMachineVO> iotTrdStructureMachineVOS = iotTrdStructureMachineMapper.queryIotTrdStructureMachineList();
        return iotTrdStructureMachineVOS;
    }

    @Override
    public List<IotTrdStructureMachineVO> queryListByConditions(IotTrdStructureMachineDTO iotTrdStructureMachineDTO) {
        List<IotTrdStructureMachineVO> iotTrdStructureMachineVOS = iotTrdStructureMachineMapper.queryByConditions(iotTrdStructureMachineDTO);
        return iotTrdStructureMachineVOS;
    }

    @Override
    public IPage<IotTrdStructureMachineVO> queryPageByConditions(Page page, IotTrdStructureMachineDTO iotTrdStructureMachineDTO) {
        IPage<IotTrdStructureMachineVO> iotTrdStructureMachineVOIPage = iotTrdStructureMachineMapper.queryByConditions(page, iotTrdStructureMachineDTO);
        return iotTrdStructureMachineVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private IotTrdStructureMachine checkResource(Integer id) {
        IotTrdStructureMachine iotTrdStructureMachine = baseMapper.selectById(id);
        if (null == iotTrdStructureMachine) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return iotTrdStructureMachine;
    }

    /**
     * 校验：新增 / 修改 name 是否重复【多租户版本】
     * 提示：新增时，id请传入为 null，
     * 修改时，id传入相应值，以排除自身数据
     */
    private void checkNameUnity(IotTrdStructureMachineDTO iotTrdStructureMachineDTO) {
        // 使用 .ne() 排除自身重复的情况
        LambdaQueryWrapper<IotTrdStructureMachine> queryWrapper =
                Wrappers.<IotTrdStructureMachine>lambdaQuery()
                        // .eq(null != IotTrdStructureMachineDTO.getTenantId(), IotTrdStructureMachine::getTenantId, IotTrdStructureMachineDTO.getTenantId())
                        .eq(StringUtils.isNotEmpty(iotTrdStructureMachineDTO.getName()), IotTrdStructureMachine::getName, iotTrdStructureMachineDTO.getName())
                        .ne(null != iotTrdStructureMachineDTO.getId(), IotTrdStructureMachine::getId, iotTrdStructureMachineDTO.getId());
        List<IotTrdStructureMachine> iotTrdStructureMachineList = baseMapper.selectList(queryWrapper);
        if (null != iotTrdStructureMachineList && !iotTrdStructureMachineList.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

}
