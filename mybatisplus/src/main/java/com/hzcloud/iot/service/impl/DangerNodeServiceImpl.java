package com.hzcloud.iot.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzcloud.iot.dto.DangerNodeDTO;
import com.hzcloud.iot.entity.DangerNode;
import com.hzcloud.iot.mapper.DangerNodeMapper;
import com.hzcloud.iot.service.IDangerNodeService;
import com.hzcloud.iot.utils.CommonConstants;
import com.hzcloud.iot.vo.DangerNodeVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 巡检节点(DangerNode)表服务实现类
 *
 * @author MH
 * @since 2020-11-13 15:17:26
 */
@AllArgsConstructor
@Service
public class DangerNodeServiceImpl extends ServiceImpl<DangerNodeMapper, DangerNode> implements IDangerNodeService {

    private final DangerNodeMapper dangerNodeMapper;

    @Override
    public Boolean saveDangerNode(DangerNodeDTO dangerNodeDTO) {
        // 校验：name 是否重复
        checkNameUnity(dangerNodeDTO.getName());

        DangerNode dangerNode = new DangerNode();
        BeanUtils.copyProperties(dangerNodeDTO, dangerNode);
        dangerNode.setStatus(CommonConstants.STATUS_NORMAL);
        dangerNode.setDelFlag(CommonConstants.STATUS_NORMAL);
        dangerNode.setCreateTime(LocalDateTime.now());
        dangerNode.setUpdateTime(dangerNode.getCreateTime());
        baseMapper.insert(dangerNode);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteDangerNode(Integer id) {
        // 校验：资源是否存在
        checkResource(id);

        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateDangerNode(DangerNodeDTO dangerNodeDTO) {
        // 校验：name 是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(dangerNodeDTO.getName())) {
            checkNameUnity(dangerNodeDTO);
        }

        DangerNode dangerNode = new DangerNode();
        BeanUtils.copyProperties(dangerNodeDTO, dangerNode);
        dangerNode.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(dangerNode);
        return Boolean.TRUE;
    }

    @Override
    public DangerNodeVO queryDangerNode(Integer id) {
        DangerNode dangerNode = dangerNodeMapper.selectById(id);
        DangerNodeVO dangerNodeVO = new DangerNodeVO();
        BeanUtils.copyProperties(dangerNode, dangerNodeVO);
        return dangerNodeVO;
    }

    @Override
    public DangerNodeVO queryDangerNodeDetail(Integer id) {
        DangerNodeVO dangerNodeVO = dangerNodeMapper.queryDangerNodeDetail(id);
        return dangerNodeVO;
    }

    @Override
    public List<DangerNodeVO> queryDangerNodeList() {
        List<DangerNodeVO> dangerNodeVOS = dangerNodeMapper.queryDangerNodeList();
        return dangerNodeVOS;
    }

    @Override
    public List<DangerNodeVO> queryListByConditions(DangerNodeDTO dangerNodeDTO) {
        List<DangerNodeVO> dangerNodeVOS = dangerNodeMapper.queryByConditions(dangerNodeDTO);
        return dangerNodeVOS;
    }

    @Override
    public IPage<DangerNodeVO> queryPageByConditions(Page page, DangerNodeDTO dangerNodeDTO) {
        IPage<DangerNodeVO> dangerNodeVOIPage = dangerNodeMapper.queryByConditions(page, dangerNodeDTO);
        return dangerNodeVOIPage;
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        DangerNode dangerNode = baseMapper.selectById(id);
        if (null == dangerNode) {
            throw new IotResourceException("应资源不存在,请核实后输入");
        }
    }

    // 校验：name 是否重复
    private void checkNameUnity(String name) {
        LambdaQueryWrapper<DangerNode> queryWrapper =
                Wrappers.<DangerNode>lambdaQuery()
                        .eq(StringUtils.isNotEmpty(name), DangerNode::getName, name);
        List<DangerNode> dangerNodes = baseMapper.selectList(queryWrapper);
        if (null != dangerNodes && !dangerNodes.isEmpty()) {
            throw new IotResourceException("名称已存在，请核实后输入");
        }
    }

    // 校验：name 是否重复（修改时,排除自身重复的情况）
    private void checkNameUnity(DangerNodeDTO dangerNodeDTO) {
        LambdaQueryWrapper<DangerNode> queryWrapper =
                Wrappers.<DangerNode>lambdaQuery()
                        .eq(StringUtils.isNotEmpty(dangerNodeDTO.getName()), DangerNode::getName, dangerNodeDTO.getName());
        List<DangerNode> dangerNodes = baseMapper.selectList(queryWrapper);
        // 排除自身重复的情况
        if (null != dangerNodes && !dangerNodes.isEmpty()) {
            for (DangerNode dangerNode : dangerNodes) {
                // 若非修改自身且名称还存在重复，则抛出异常
                if (!dangerNode.getId().equals(dangerNodeDTO.getId()) && dangerNode.getName().equals(dangerNodeDTO.getName())) {
                    throw new IotResourceException("名称已存在，请核实后输入");
                }
            }
        }
    }


}