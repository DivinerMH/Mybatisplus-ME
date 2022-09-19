package com.linksame.mapper;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.entity.IotTrdTiles;
import com.linksame.vo.IotTrdTilesVO;
import com.linksame.dto.IotTrdTilesDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 3d-tiles �ļ����ݱ�(IotTrdTiles)���ݿ���ʲ�
 *
 * @author menghuan
 * @since 2022-08-26 10:47:24
 */
@Mapper
public interface IotTrdTilesMapper extends BaseMapper<IotTrdTiles> {

    /**
     * ����id��ѯ3d-tiles �ļ����ݱ�����(�����)
     *
     * @param id 3d-tiles �ļ����ݱ�id
     * @return 3d-tiles �ļ����ݱ�չʾ����IotTrdTilesVO
     */
    IotTrdTilesVO queryIotTrdTilesDetail(@Param("id") Integer id);

    /**
     * �޲β�ѯ3d-tiles �ļ����ݱ�List
     *
     * @return 3d-tiles �ļ����ݱ�չʾ���󼯺�IotTrdTilesVOList
     */
    List<IotTrdTilesVO> queryIotTrdTilesList();

    /**
     * ������ѯ3d-tiles �ļ����ݱ�List
     *
     * @param iotTrdTilesDTO 3d-tiles �ļ����ݱ�������DTO
     * @return 3d-tiles �ļ����ݱ�չʾ���󼯺�IotTrdTilesVOList
     */
    List<IotTrdTilesVO> queryByConditions(@Param("iotTrdTilesDTO") IotTrdTilesDTO iotTrdTilesDTO);

    /**
     * ��ҳ������ѯ3d-tiles �ļ����ݱ�Page
     *
     * @param page           ��ҳ����
     * @param iotTrdTilesDTO 3d-tiles �ļ����ݱ�������DTO
     * @return 3d-tiles �ļ����ݱ�չʾ���󼯺�IotTrdTilesVOList
     */
    IPage<IotTrdTilesVO> queryByConditions(@Param("page") Page page, @Param("iotTrdTilesDTO") IotTrdTilesDTO iotTrdTilesDTO);

}
