package com.linksame.iot.external.structure.dto;


import com.linksame.iot.external.structure.entity.BuildingFloorRoom;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 资源管理-单元(房源)表(BuildingFloorRoom)表传输对象
 *
 * @author menghuan
 * @since 2022-03-11 15:50:52
 */
@Data
@ApiModel(value = "资源管理-单元(房源)表传输对象")
@EqualsAndHashCode(callSuper = true)
public class BuildingFloorRoomDTO extends BuildingFloorRoom implements Serializable {

    private static final long serialVersionUID = 1L;

}
