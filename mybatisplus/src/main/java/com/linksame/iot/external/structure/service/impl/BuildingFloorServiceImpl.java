package com.linksame.iot.external.structure.service.impl;


import java.time.LocalDateTime;

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
import com.linksame.iot.external.structure.entity.BuildingFloor;
import com.linksame.iot.external.structure.vo.BuildingFloorVO;
import com.linksame.iot.external.structure.dto.BuildingFloorDTO;
import com.linksame.iot.external.structure.mapper.BuildingFloorMapper;
import com.linksame.iot.external.structure.service.IBuildingFloorService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 资源管理-楼层表(BuildingFloor)表服务实现类
 *
 * @author menghuan
 * @since 2022-03-11 15:50:30
 */
@AllArgsConstructor
@Service
@Slf4j
public class BuildingFloorServiceImpl extends ServiceImpl<BuildingFloorMapper, BuildingFloor> implements IBuildingFloorService {

    private final BuildingFloorMapper buildingFloorMapper;

    @Override
    public Boolean saveBuildingFloor(BuildingFloorDTO buildingFloorDTO) {
        // 校验：名称是否重复
        checkNameUnity(buildingFloorDTO);
        // 业务逻辑
        BuildingFloor buildingFloor = new BuildingFloor();
        BeanUtils.copyProperties(buildingFloorDTO, buildingFloor);
        buildingFloor.setStatus(CommonConstants.STATUS_NORMAL);
        buildingFloor.setDelFlag(CommonConstants.STATUS_NORMAL);
        buildingFloor.setCreateTime(LocalDateTime.now());
        buildingFloor.setUpdateTime(buildingFloor.getCreateTime());
        baseMapper.insert(buildingFloor);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteBuildingFloor(Integer id) {
        // 校验：资源是否存在
        checkResource(id);
        // 业务逻辑
        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateBuildingFloor(BuildingFloorDTO buildingFloorDTO) {
        // 校验：名称是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(buildingFloorDTO.getName())) {
            checkNameUnity(buildingFloorDTO);
        }
        // 业务逻辑
        BuildingFloor buildingFloor = new BuildingFloor();
        BeanUtils.copyProperties(buildingFloorDTO, buildingFloor);
        buildingFloor.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(buildingFloor);
        return Boolean.TRUE;
    }

    @Override
    public BuildingFloorVO queryBuildingFloor(Integer id) {
        BuildingFloor buildingFloor = buildingFloorMapper.selectById(id);
        if (null == buildingFloor) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        BuildingFloorVO buildingFloorVO = new BuildingFloorVO();
        BeanUtils.copyProperties(buildingFloor, buildingFloorVO);
        return buildingFloorVO;
    }

    @Override
    public BuildingFloorVO queryBuildingFloorDetail(Integer id) {
        BuildingFloorVO buildingFloorVO = buildingFloorMapper.queryBuildingFloorDetail(id);
        if (null == buildingFloorVO) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return buildingFloorVO;
    }

    @Override
    public List<BuildingFloorVO> queryBuildingFloorList() {
        List<BuildingFloorVO> buildingFloorVOS = buildingFloorMapper.queryBuildingFloorList();
        return buildingFloorVOS;
    }

    @Override
    public List<BuildingFloorVO> queryListByConditions(BuildingFloorDTO buildingFloorDTO) {
        List<BuildingFloorVO> buildingFloorVOS = buildingFloorMapper.queryByConditions(buildingFloorDTO);
        return buildingFloorVOS;
    }

    @Override
    public IPage<BuildingFloorVO> queryPageByConditions(Page page, BuildingFloorDTO buildingFloorDTO) {
        IPage<BuildingFloorVO> buildingFloorVOIPage = buildingFloorMapper.queryByConditions(page, buildingFloorDTO);
        return buildingFloorVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        BuildingFloor buildingFloor = baseMapper.selectById(id);
        if (null == buildingFloor) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
    }

    /**
     * 校验：新增 / 修改 name 是否重复【多租户版本】
     * 提示：新增时，id请传入为 null，
     * 修改时，id传入相应值，以排除自身数据
     */
    private void checkNameUnity(BuildingFloorDTO buildingFloorDTO) {
        // 使用 .ne() 排除自身重复的情况
        LambdaQueryWrapper<BuildingFloor> queryWrapper =
                Wrappers.<BuildingFloor>lambdaQuery()
                        // .eq(null != BuildingFloorDTO.getTenantId(), BuildingFloor::getTenantId, BuildingFloorDTO.getTenantId())
                        .eq(StringUtils.isNotEmpty(buildingFloorDTO.getName()), BuildingFloor::getName, buildingFloorDTO.getName())
                        .ne(null != buildingFloorDTO.getId(), BuildingFloor::getId, buildingFloorDTO.getId());
        List<BuildingFloor> buildingFloorList = baseMapper.selectList(queryWrapper);
        if (null != buildingFloorList && !buildingFloorList.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

}
