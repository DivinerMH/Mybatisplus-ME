package com.linksame.iot.external.structure.vo;


import com.linksame.iot.external.structure.entity.Building;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 资源管理-楼宇表(Building)表展示对象
 *
 * @author menghuan
 * @since 2022-03-11 15:50:14
 */
@Data
@ApiModel(value = "资源管理-楼宇表展示对象")
public class BuildingVO extends Building implements Serializable {

    private static final long serialVersionUID = 1L;

}
