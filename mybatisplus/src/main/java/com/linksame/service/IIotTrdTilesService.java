package com.linksame.service;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linksame.entity.IotTrdTiles;
import com.linksame.vo.IotTrdTilesVO;
import com.linksame.dto.IotTrdTilesDTO;

import java.util.List;

/**
 * 3d-tiles �ļ����ݱ�(IotTrdTiles)�����ӿ�
 *
 * @author menghuan
 * @since 2022-08-26 10:47:25
 */
public interface IIotTrdTilesService extends IService<IotTrdTiles> {

    /**
     * ����3d-tiles �ļ����ݱ�
     *
     * @param iotTrdTilesDTO 3d-tiles �ļ����ݱ�������DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveIotTrdTiles(IotTrdTilesDTO iotTrdTilesDTO);

    /**
     * ����id���߼���ɾ��3d-tiles �ļ����ݱ�
     *
     * @param id 3d-tiles �ļ����ݱ�id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteIotTrdTiles(Integer id);

    /**
     * �޸�3d-tiles �ļ����ݱ�
     *
     * @param iotTrdTilesDTO 3d-tiles �ļ����ݱ�������DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateIotTrdTiles(IotTrdTilesDTO iotTrdTilesDTO);

    /**
     * ����id��ѯ3d-tiles �ļ����ݱ�����(������)
     *
     * @param id 3d-tiles �ļ����ݱ�id
     * @return 3d-tiles �ļ����ݱ�չʾ����
     */
    IotTrdTilesVO queryIotTrdTiles(Integer id);

    /**
     * ����id��ѯ3d-tiles �ļ����ݱ�����(�����)
     *
     * @param id 3d-tiles �ļ����ݱ�id
     * @return 3d-tiles �ļ����ݱ�չʾ����
     */
    IotTrdTilesVO queryIotTrdTilesDetail(Integer id);

    /**
     * �޲β�ѯ3d-tiles �ļ����ݱ��б�
     *
     * @return 3d-tiles �ļ����ݱ�չʾ���󼯺�IotTrdTilesVOList
     */
    List<IotTrdTilesVO> queryIotTrdTilesList();

    /**
     * ������ѯ3d-tiles �ļ����ݱ��б�
     *
     * @param iotTrdTilesDTO 3d-tiles �ļ����ݱ�������DTO
     * @return 3d-tiles �ļ����ݱ�չʾ���󼯺�IotTrdTilesVOList
     */
    List<IotTrdTilesVO> queryListByConditions(IotTrdTilesDTO iotTrdTilesDTO);

    /**
     * ��ҳ������ѯ3d-tiles �ļ����ݱ��б�
     *
     * @param iotTrdTilesDTO 3d-tiles �ļ����ݱ�������DTO
     * @return 3d-tiles �ļ����ݱ�չʾ���󼯺�IotTrdTilesVOList
     */
    IPage<IotTrdTilesVO> queryPageByConditions(Page page, IotTrdTilesDTO iotTrdTilesDTO);

}
