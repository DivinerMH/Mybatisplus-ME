package com.linksame.iot.external.structure.vo;


import com.linksame.iot.external.structure.entity.BuildingFloor;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 资源管理-楼层表(BuildingFloor)表展示对象
 *
 * @author menghuan
 * @since 2022-03-11 15:50:30
 */
@Data
@ApiModel(value = "资源管理-楼层表展示对象")
public class BuildingFloorVO extends BuildingFloor implements Serializable {

    private static final long serialVersionUID = 1L;

}
