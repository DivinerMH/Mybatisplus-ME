package com.linksame.dto;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.entity.IotTrdTiles;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 3d-tiles �ļ����ݱ�(IotTrdTiles)�������
 *
 * @author menghuan
 * @since 2022-08-26 10:47:24
 */
@Data
@ApiModel(value = "3d-tiles �ļ����ݱ������")
@EqualsAndHashCode(callSuper = true)
public class IotTrdTilesDTO extends IotTrdTiles implements Serializable {

    private static final long serialVersionUID = 1L;

}
