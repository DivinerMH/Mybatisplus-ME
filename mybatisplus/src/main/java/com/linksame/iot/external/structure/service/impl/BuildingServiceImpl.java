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
import com.linksame.iot.external.structure.entity.Building;
import com.linksame.iot.external.structure.vo.BuildingVO;
import com.linksame.iot.external.structure.dto.BuildingDTO;
import com.linksame.iot.external.structure.mapper.BuildingMapper;
import com.linksame.iot.external.structure.service.IBuildingService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 资源管理-楼宇表(Building)表服务实现类
 *
 * @author menghuan
 * @since 2022-03-11 15:50:15
 */
@AllArgsConstructor
@Service
@Slf4j
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements IBuildingService {

    private final BuildingMapper buildingMapper;

    @Override
    public Boolean saveBuilding(BuildingDTO buildingDTO) {
        // 校验：名称是否重复
        checkNameUnity(buildingDTO);
        // 业务逻辑
        Building building = new Building();
        BeanUtils.copyProperties(buildingDTO, building);
        building.setStatus(CommonConstants.STATUS_NORMAL);
        building.setDelFlag(CommonConstants.STATUS_NORMAL);
        building.setCreateTime(LocalDateTime.now());
        building.setUpdateTime(building.getCreateTime());
        baseMapper.insert(building);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteBuilding(Integer id) {
        // 校验：资源是否存在
        checkResource(id);
        // 业务逻辑
        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateBuilding(BuildingDTO buildingDTO) {
        // 校验：名称是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(buildingDTO.getName())) {
            checkNameUnity(buildingDTO);
        }
        // 业务逻辑
        Building building = new Building();
        BeanUtils.copyProperties(buildingDTO, building);
        building.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(building);
        return Boolean.TRUE;
    }

    @Override
    public BuildingVO queryBuilding(Integer id) {
        Building building = buildingMapper.selectById(id);
        if (null == building) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        BuildingVO buildingVO = new BuildingVO();
        BeanUtils.copyProperties(building, buildingVO);
        return buildingVO;
    }

    @Override
    public BuildingVO queryBuildingDetail(Integer id) {
        BuildingVO buildingVO = buildingMapper.queryBuildingDetail(id);
        if (null == buildingVO) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return buildingVO;
    }

    @Override
    public List<BuildingVO> queryBuildingList() {
        List<BuildingVO> buildingVOS = buildingMapper.queryBuildingList();
        return buildingVOS;
    }

    @Override
    public List<BuildingVO> queryListByConditions(BuildingDTO buildingDTO) {
        List<BuildingVO> buildingVOS = buildingMapper.queryByConditions(buildingDTO);
        return buildingVOS;
    }

    @Override
    public IPage<BuildingVO> queryPageByConditions(Page page, BuildingDTO buildingDTO) {
        IPage<BuildingVO> buildingVOIPage = buildingMapper.queryByConditions(page, buildingDTO);
        return buildingVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        Building building = baseMapper.selectById(id);
        if (null == building) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
    }

    /**
     * 校验：新增 / 修改 name 是否重复【多租户版本】
     * 提示：新增时，id请传入为 null，
     * 修改时，id传入相应值，以排除自身数据
     */
    private void checkNameUnity(BuildingDTO buildingDTO) {
        // 使用 .ne() 排除自身重复的情况
        LambdaQueryWrapper<Building> queryWrapper =
                Wrappers.<Building>lambdaQuery()
                        // .eq(null != BuildingDTO.getTenantId(), Building::getTenantId, BuildingDTO.getTenantId())
                        .eq(StringUtils.isNotEmpty(buildingDTO.getName()), Building::getName, buildingDTO.getName())
                        .ne(null != buildingDTO.getId(), Building::getId, buildingDTO.getId());
        List<Building> buildingList = baseMapper.selectList(queryWrapper);
        if (null != buildingList && !buildingList.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

}
