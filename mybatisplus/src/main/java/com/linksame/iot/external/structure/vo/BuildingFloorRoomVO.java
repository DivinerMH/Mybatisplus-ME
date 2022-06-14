package com.linksame.iot.external.structure.vo;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.iot.external.structure.entity.BuildingFloorRoom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 资源管理-单元(房源)表(BuildingFloorRoom)表展示对象
 *
 * @author menghuan
 * @since 2022-03-11 15:50:51
 */
@Data
@ApiModel(value = "资源管理-单元(房源)表展示对象")
public class BuildingFloorRoomVO extends BuildingFloorRoom implements Serializable {

    private static final long serialVersionUID = 1L;

}
