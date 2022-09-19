package com.linksame.service.impl;


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
import com.linksame.entity.IotTrdTiles;
import com.linksame.vo.IotTrdTilesVO;
import com.linksame.dto.IotTrdTilesDTO;
import com.linksame.mapper.IotTrdTilesMapper;
import com.linksame.service.IIotTrdTilesService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 3d-tiles �ļ����ݱ�(IotTrdTiles)�����ʵ����
 *
 * @author menghuan
 * @since 2022-08-26 10:47:26
 */
@AllArgsConstructor
@Service
@Slf4j
public class IotTrdTilesServiceImpl extends ServiceImpl<IotTrdTilesMapper, IotTrdTiles> implements IIotTrdTilesService {

    private final IotTrdTilesMapper iotTrdTilesMapper;

    @Override
    public Boolean saveIotTrdTiles(IotTrdTilesDTO iotTrdTilesDTO) {
        // У�飺�����Ƿ��ظ�
        checkNameUnity(iotTrdTilesDTO);
        // ҵ���߼�
        IotTrdTiles iotTrdTiles = new IotTrdTiles();
        BeanUtils.copyProperties(iotTrdTilesDTO, iotTrdTiles);
        iotTrdTiles.setStatus(CommonConstants.STATUS_NORMAL);
        iotTrdTiles.setDelFlag(CommonConstants.STATUS_NORMAL);
        iotTrdTiles.setCreateTime(LocalDateTime.now());
        iotTrdTiles.setUpdateTime(iotTrdTiles.getCreateTime());
        baseMapper.insert(iotTrdTiles);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteIotTrdTiles(Integer id) {
        // У�飺��Դ�Ƿ����
        checkResource(id);
        // ҵ���߼�
        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateIotTrdTiles(IotTrdTilesDTO iotTrdTilesDTO) {
        // У�飺�����Ƿ��ظ����޸�ʱ,�ų�����
        if (StringUtils.isNotBlank(iotTrdTilesDTO.getName())) {
            checkNameUnity(iotTrdTilesDTO);
        }
        // ҵ���߼�
        IotTrdTiles iotTrdTiles = new IotTrdTiles();
        BeanUtils.copyProperties(iotTrdTilesDTO, iotTrdTiles);
        iotTrdTiles.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(iotTrdTiles);
        return Boolean.TRUE;
    }

    @Override
    public IotTrdTilesVO queryIotTrdTiles(Integer id) {
        IotTrdTiles iotTrdTiles = iotTrdTilesMapper.selectById(id);
        if (null == iotTrdTiles) {
            throw new IotRepositoryException("��Ӧ��Դ������,���ʵ������");
        }
        IotTrdTilesVO iotTrdTilesVO = new IotTrdTilesVO();
        BeanUtils.copyProperties(iotTrdTiles, iotTrdTilesVO);
        return iotTrdTilesVO;
    }

    @Override
    public IotTrdTilesVO queryIotTrdTilesDetail(Integer id) {
        IotTrdTilesVO iotTrdTilesVO = iotTrdTilesMapper.queryIotTrdTilesDetail(id);
        if (null == iotTrdTilesVO) {
            throw new IotRepositoryException("��Ӧ��Դ������,���ʵ������");
        }
        return iotTrdTilesVO;
    }

    @Override
    public List<IotTrdTilesVO> queryIotTrdTilesList() {
        List<IotTrdTilesVO> iotTrdTilesVOS = iotTrdTilesMapper.queryIotTrdTilesList();
        return iotTrdTilesVOS;
    }

    @Override
    public List<IotTrdTilesVO> queryListByConditions(IotTrdTilesDTO iotTrdTilesDTO) {
        List<IotTrdTilesVO> iotTrdTilesVOS = iotTrdTilesMapper.queryByConditions(iotTrdTilesDTO);
        return iotTrdTilesVOS;
    }

    @Override
    public IPage<IotTrdTilesVO> queryPageByConditions(Page page, IotTrdTilesDTO iotTrdTilesDTO) {
        IPage<IotTrdTilesVO> iotTrdTilesVOIPage = iotTrdTilesMapper.queryByConditions(page, iotTrdTilesDTO);
        return iotTrdTilesVOIPage;
    }


    /* --------------------------------------------�쳣����-----------------------------------------*/

    // У�飺��Դ�Ƿ����
    private IotTrdTiles checkResource(Integer id) {
        IotTrdTiles iotTrdTiles = baseMapper.selectById(id);
        if (null == iotTrdTiles) {
            throw new IotRepositoryException("��Ӧ��Դ������,���ʵ������");
        }
        return iotTrdTiles;
    }

    /**
     * У�飺���� / �޸� name �Ƿ��ظ������⻧�汾��
     * ��ʾ������ʱ��id�봫��Ϊ null��
     * �޸�ʱ��id������Ӧֵ�����ų���������
     */
    private void checkNameUnity(IotTrdTilesDTO iotTrdTilesDTO) {
        // ʹ�� .ne() �ų������ظ������
        LambdaQueryWrapper<IotTrdTiles> queryWrapper =
                Wrappers.<IotTrdTiles>lambdaQuery()
                        // .eq(null != IotTrdTilesDTO.getTenantId(), IotTrdTiles::getTenantId, IotTrdTilesDTO.getTenantId())
                        .eq(StringUtils.isNotEmpty(iotTrdTilesDTO.getName()), IotTrdTiles::getName, iotTrdTilesDTO.getName())
                        .ne(null != iotTrdTilesDTO.getId(), IotTrdTiles::getId, iotTrdTilesDTO.getId());
        List<IotTrdTiles> iotTrdTilesList = baseMapper.selectList(queryWrapper);
        if (null != iotTrdTilesList && !iotTrdTilesList.isEmpty()) {
            throw new IotRepositoryException("�����Ѵ��ڣ����ʵ������");
        }
    }

}
