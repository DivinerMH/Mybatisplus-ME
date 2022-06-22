package com.linksame.iot.external.structure.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linksame.iot.external.structure.dto.BuildingFloorRoomDTO;
import com.linksame.iot.external.structure.entity.BuildingFloorRoom;
import com.linksame.iot.external.structure.mapper.BuildingFloorRoomMapper;
import com.linksame.iot.external.structure.service.IBuildingFloorRoomService;
import com.linksame.iot.external.structure.vo.BuildingFloorRoomVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 资源管理-单元(房源)表(BuildingFloorRoom)表服务实现类
 *
 * @author menghuan
 * @since 2022-03-11 15:50:52
 */
@AllArgsConstructor
@Service
@Slf4j
public class BuildingFloorRoomServiceImpl extends ServiceImpl<BuildingFloorRoomMapper, BuildingFloorRoom> implements IBuildingFloorRoomService {

    private final BuildingFloorRoomMapper buildingFloorRoomMapper;

    @Override
    public Boolean saveBuildingFloorRoom(BuildingFloorRoomDTO buildingFloorRoomDTO) {
        // 校验：名称是否重复
        checkNameUnity(buildingFloorRoomDTO);
        // 业务逻辑
        BuildingFloorRoom buildingFloorRoom = new BuildingFloorRoom();
        BeanUtils.copyProperties(buildingFloorRoomDTO, buildingFloorRoom);
        buildingFloorRoom.setStatus(CommonConstants.STATUS_NORMAL);
        buildingFloorRoom.setDelFlag(CommonConstants.STATUS_NORMAL);
        buildingFloorRoom.setCreateTime(LocalDateTime.now());
        buildingFloorRoom.setUpdateTime(buildingFloorRoom.getCreateTime());
        baseMapper.insert(buildingFloorRoom);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteBuildingFloorRoom(Integer id) {
        // 校验：资源是否存在
        checkResource(id);
        // 业务逻辑
        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateBuildingFloorRoom(BuildingFloorRoomDTO buildingFloorRoomDTO) {
        // 校验：名称是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(buildingFloorRoomDTO.getName())) {
            checkNameUnity(buildingFloorRoomDTO);
        }
        // 业务逻辑
        BuildingFloorRoom buildingFloorRoom = new BuildingFloorRoom();
        BeanUtils.copyProperties(buildingFloorRoomDTO, buildingFloorRoom);
        buildingFloorRoom.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(buildingFloorRoom);
        return Boolean.TRUE;
    }

    @Override
    public BuildingFloorRoomVO queryBuildingFloorRoom(Integer id) {
        BuildingFloorRoom buildingFloorRoom = buildingFloorRoomMapper.selectById(id);
        if (null == buildingFloorRoom) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        BuildingFloorRoomVO buildingFloorRoomVO = new BuildingFloorRoomVO();
        BeanUtils.copyProperties(buildingFloorRoom, buildingFloorRoomVO);
        return buildingFloorRoomVO;
    }

    @Override
    public BuildingFloorRoomVO queryBuildingFloorRoomDetail(Integer id) {
        BuildingFloorRoomVO buildingFloorRoomVO = buildingFloorRoomMapper.queryBuildingFloorRoomDetail(id);
        if (null == buildingFloorRoomVO) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return buildingFloorRoomVO;
    }

    @Override
    public List<BuildingFloorRoomVO> queryBuildingFloorRoomList() {
        List<BuildingFloorRoomVO> buildingFloorRoomVOS = buildingFloorRoomMapper.queryBuildingFloorRoomList();
        return buildingFloorRoomVOS;
    }

    @Override
    public List<BuildingFloorRoomVO> queryListByConditions(BuildingFloorRoomDTO buildingFloorRoomDTO) {
        List<BuildingFloorRoomVO> buildingFloorRoomVOS = buildingFloorRoomMapper.queryByConditions(buildingFloorRoomDTO);
        return buildingFloorRoomVOS;
    }

    @Override
    public IPage<BuildingFloorRoomVO> queryPageByConditions(Page page, BuildingFloorRoomDTO buildingFloorRoomDTO) {
        IPage<BuildingFloorRoomVO> buildingFloorRoomVOIPage = buildingFloorRoomMapper.queryByConditions(page, buildingFloorRoomDTO);
        return buildingFloorRoomVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        BuildingFloorRoom buildingFloorRoom = baseMapper.selectById(id);
        if (null == buildingFloorRoom) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
    }

    /**
     * 校验：新增 / 修改 name 是否重复【多租户版本】
     * 提示：新增时，id请传入为 null，
     * 修改时，id传入相应值，以排除自身数据
     */
    private void checkNameUnity(BuildingFloorRoomDTO buildingFloorRoomDTO) {
        // 使用 .ne() 排除自身重复的情况
        LambdaQueryWrapper<BuildingFloorRoom> queryWrapper =
                Wrappers.<BuildingFloorRoom>lambdaQuery()
                        // .eq(null != BuildingFloorRoomDTO.getTenantId(), BuildingFloorRoom::getTenantId, BuildingFloorRoomDTO.getTenantId())
                        .eq(StringUtils.isNotEmpty(buildingFloorRoomDTO.getName()), BuildingFloorRoom::getName, buildingFloorRoomDTO.getName())
                        .ne(null != buildingFloorRoomDTO.getId(), BuildingFloorRoom::getId, buildingFloorRoomDTO.getId());
        List<BuildingFloorRoom> buildingFloorRoomList = baseMapper.selectList(queryWrapper);
        if (null != buildingFloorRoomList && !buildingFloorRoomList.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

}
