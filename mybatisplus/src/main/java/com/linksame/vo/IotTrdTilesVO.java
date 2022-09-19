package com.linksame.vo;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.entity.IotTrdTiles;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 3d-tiles 文件数据表(IotTrdTiles)表展示对象
 *
 * @author menghuan
 * @since 2022-08-26 10:47:23
 */
@Data
@ApiModel(value = "3d-tiles 文件数据表展示对象")
public class IotTrdTilesVO extends IotTrdTiles implements Serializable {

    private static final long serialVersionUID = 1L;

}
