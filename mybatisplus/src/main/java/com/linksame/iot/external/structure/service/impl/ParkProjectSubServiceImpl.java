package com.linksame.iot.external.structure.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linksame.iot.external.structure.dto.ParkProjectSubDTO;
import com.linksame.iot.external.structure.entity.ParkProjectSub;
import com.linksame.iot.external.structure.mapper.ParkProjectSubMapper;
import com.linksame.iot.external.structure.service.IParkProjectSubService;
import com.linksame.iot.external.structure.vo.ParkProjectSubVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 资源管理-项目分期表(ParkProjectSub)表服务实现类
 *
 * @author menghuan
 * @since 2022-03-11 15:39:05
 */
@AllArgsConstructor
@Service
@Slf4j
public class ParkProjectSubServiceImpl extends ServiceImpl<ParkProjectSubMapper, ParkProjectSub> implements IParkProjectSubService {

    private final ParkProjectSubMapper parkProjectSubMapper;

    @Override
    public Boolean saveParkProjectSub(ParkProjectSubDTO parkProjectSubDTO) {
        // 校验：名称是否重复
        checkNameUnity(parkProjectSubDTO);
        // 业务逻辑
        ParkProjectSub parkProjectSub = new ParkProjectSub();
        BeanUtils.copyProperties(parkProjectSubDTO, parkProjectSub);
        parkProjectSub.setStatus(CommonConstants.STATUS_NORMAL);
        parkProjectSub.setDelFlag(CommonConstants.STATUS_NORMAL);
        parkProjectSub.setCreateTime(LocalDateTime.now());
        parkProjectSub.setUpdateTime(parkProjectSub.getCreateTime());
        baseMapper.insert(parkProjectSub);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteParkProjectSub(Integer id) {
        // 校验：资源是否存在
        checkResource(id);
        // 业务逻辑
        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateParkProjectSub(ParkProjectSubDTO parkProjectSubDTO) {
        // 校验：名称是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(parkProjectSubDTO.getName())) {
            checkNameUnity(parkProjectSubDTO);
        }
        // 业务逻辑
        ParkProjectSub parkProjectSub = new ParkProjectSub();
        BeanUtils.copyProperties(parkProjectSubDTO, parkProjectSub);
        parkProjectSub.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(parkProjectSub);
        return Boolean.TRUE;
    }

    @Override
    public ParkProjectSubVO queryParkProjectSub(Integer id) {
        ParkProjectSub parkProjectSub = parkProjectSubMapper.selectById(id);
        if (null == parkProjectSub) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        ParkProjectSubVO parkProjectSubVO = new ParkProjectSubVO();
        BeanUtils.copyProperties(parkProjectSub, parkProjectSubVO);
        return parkProjectSubVO;
    }

    @Override
    public ParkProjectSubVO queryParkProjectSubDetail(Integer id) {
        ParkProjectSubVO parkProjectSubVO = parkProjectSubMapper.queryParkProjectSubDetail(id);
        if (null == parkProjectSubVO) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return parkProjectSubVO;
    }

    @Override
    public List<ParkProjectSubVO> queryParkProjectSubList() {
        List<ParkProjectSubVO> parkProjectSubVOS = parkProjectSubMapper.queryParkProjectSubList();
        return parkProjectSubVOS;
    }

    @Override
    public List<ParkProjectSubVO> queryListByConditions(ParkProjectSubDTO parkProjectSubDTO) {
        List<ParkProjectSubVO> parkProjectSubVOS = parkProjectSubMapper.queryByConditions(parkProjectSubDTO);
        return parkProjectSubVOS;
    }

    @Override
    public IPage<ParkProjectSubVO> queryPageByConditions(Page page, ParkProjectSubDTO parkProjectSubDTO) {
        IPage<ParkProjectSubVO> parkProjectSubVOIPage = parkProjectSubMapper.queryByConditions(page, parkProjectSubDTO);
        return parkProjectSubVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        ParkProjectSub parkProjectSub = baseMapper.selectById(id);
        if (null == parkProjectSub) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
    }

    /**
     * 校验：新增 / 修改 name 是否重复【多租户版本】
     * 提示：新增时，id请传入为 null，
     * 修改时，id传入相应值，以排除自身数据
     */
    private void checkNameUnity(ParkProjectSubDTO parkProjectSubDTO) {
        // 使用 .ne() 排除自身重复的情况
        LambdaQueryWrapper<ParkProjectSub> queryWrapper =
                Wrappers.<ParkProjectSub>lambdaQuery()
                        // .eq(null != ParkProjectSubDTO.getTenantId(), ParkProjectSub::getTenantId, ParkProjectSubDTO.getTenantId())
                        .eq(StringUtils.isNotEmpty(parkProjectSubDTO.getName()), ParkProjectSub::getName, parkProjectSubDTO.getName())
                        .ne(null != parkProjectSubDTO.getId(), ParkProjectSub::getId, parkProjectSubDTO.getId());
        List<ParkProjectSub> parkProjectSubList = baseMapper.selectList(queryWrapper);
        if (null != parkProjectSubList && !parkProjectSubList.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

}
