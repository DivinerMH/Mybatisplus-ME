package com.linksame.iot.external.structure.dto;


import com.linksame.iot.external.structure.entity.Building;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 资源管理-楼宇表(Building)表传输对象
 *
 * @author menghuan
 * @since 2022-03-11 15:50:14
 */
@Data
@ApiModel(value = "资源管理-楼宇表传输对象")
@EqualsAndHashCode(callSuper = true)
public class BuildingDTO extends Building implements Serializable {

    private static final long serialVersionUID = 1L;

}
