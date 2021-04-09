package com.linksame.iot.meeting.service.impl;


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
import com.linksame.iot.meeting.entity.IotMeeting;
import com.linksame.iot.meeting.vo.IotMeetingVO;
import com.linksame.iot.meeting.dto.IotMeetingDTO;
import com.linksame.iot.meeting.mapper.IotMeetingMapper;
import com.linksame.iot.meeting.service.IIotMeetingService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 会议信息(IotMeeting)表服务实现类
 *
 * @author menghuan
 * @since 2021-03-31 17:33:09
 */
@AllArgsConstructor
@Service
@Slf4j
public class IotMeetingServiceImpl extends ServiceImpl<IotMeetingMapper, IotMeeting> implements IIotMeetingService {

    private final IotMeetingMapper iotMeetingMapper;

    @Override
    public Boolean saveIotMeeting(IotMeetingDTO iotMeetingDTO) {
        // 校验：name 是否重复
        checkNameUnity(iotMeetingDTO.getName());

        IotMeeting iotMeeting = new IotMeeting();
        BeanUtils.copyProperties(iotMeetingDTO, iotMeeting);
        iotMeeting.setStatus(CommonConstants.STATUS_NORMAL);
        iotMeeting.setDelFlag(CommonConstants.STATUS_NORMAL);
        iotMeeting.setCreateTime(LocalDateTime.now());
        iotMeeting.setUpdateTime(iotMeeting.getCreateTime());
        baseMapper.insert(iotMeeting);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteIotMeeting(Integer id) {
        // 校验：资源是否存在
        checkResource(id);

        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateIotMeeting(IotMeetingDTO iotMeetingDTO) {
        // 校验：name 是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(iotMeetingDTO.getName())) {
            checkNameUnity(iotMeetingDTO);
        }

        IotMeeting iotMeeting = new IotMeeting();
        BeanUtils.copyProperties(iotMeetingDTO, iotMeeting);
        iotMeeting.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(iotMeeting);
        return Boolean.TRUE;
    }

    @Override
    public IotMeetingVO queryIotMeeting(Integer id) {
        IotMeeting iotMeeting = iotMeetingMapper.selectById(id);
        if (null == iotMeeting) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        IotMeetingVO iotMeetingVO = new IotMeetingVO();
        BeanUtils.copyProperties(iotMeeting, iotMeetingVO);
        return iotMeetingVO;
    }

    @Override
    public IotMeetingVO queryIotMeetingDetail(Integer id) {
        IotMeetingVO iotMeetingVO = iotMeetingMapper.queryIotMeetingDetail(id);
        if (null == iotMeetingVO) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
        return iotMeetingVO;
    }

    @Override
    public List<IotMeetingVO> queryIotMeetingList() {
        List<IotMeetingVO> iotMeetingVOS = iotMeetingMapper.queryIotMeetingList();
        return iotMeetingVOS;
    }

    @Override
    public List<IotMeetingVO> queryListByConditions(IotMeetingDTO iotMeetingDTO) {
        List<IotMeetingVO> iotMeetingVOS = iotMeetingMapper.queryByConditions(iotMeetingDTO);
        return iotMeetingVOS;
    }

    @Override
    public IPage<IotMeetingVO> queryPageByConditions(Page page, IotMeetingDTO iotMeetingDTO) {
        IPage<IotMeetingVO> iotMeetingVOIPage = iotMeetingMapper.queryByConditions(page, iotMeetingDTO);
        return iotMeetingVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        IotMeeting iotMeeting = baseMapper.selectById(id);
        if (null == iotMeeting) {
            throw new IotRepositoryException("对应资源不存在,请核实后输入");
        }
    }

    // 校验：name 是否重复
    private void checkNameUnity(String name) {
        LambdaQueryWrapper<IotMeeting> queryWrapper =
                Wrappers.<IotMeeting>lambdaQuery()
                        .eq(StringUtils.isNotEmpty(name), IotMeeting::getName, name);
        List<IotMeeting> iotMeetings = baseMapper.selectList(queryWrapper);
        if (null != iotMeetings && !iotMeetings.isEmpty()) {
            throw new IotRepositoryException("名称已存在，请核实后输入");
        }
    }

    // 校验：name 是否重复（修改时,排除自身重复的情况）
    private void checkNameUnity(IotMeetingDTO iotMeetingDTO) {
        LambdaQueryWrapper<IotMeeting> queryWrapper =
                Wrappers.<IotMeeting>lambdaQuery()
                        .eq(StringUtils.isNotEmpty(iotMeetingDTO.getName()), IotMeeting::getName, iotMeetingDTO.getName());
        List<IotMeeting> iotMeetingList = baseMapper.selectList(queryWrapper);
        // 排除自身重复的情况
        if (null != iotMeetingList && !iotMeetingList.isEmpty()) {
            for (IotMeeting iotMeeting : iotMeetingList) {
                // 若非修改自身且名称还存在重复，则抛出异常
                if (!iotMeeting.getId().equals(iotMeetingDTO.getId()) && iotMeeting.getName().equals(iotMeetingDTO.getName())) {
                    throw new IotRepositoryException("名称已存在，请核实后输入");
                }
            }
        }
    }


}
