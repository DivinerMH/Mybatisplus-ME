package com.linksame.iot.external.structure.dto;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.iot.external.structure.entity.BuildingFloor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 资源管理-楼层表(BuildingFloor)表传输对象
 *
 * @author menghuan
 * @since 2022-03-11 15:50:30
 */
@Data
@ApiModel(value = "资源管理-楼层表传输对象")
@EqualsAndHashCode(callSuper = true)
public class BuildingFloorDTO extends BuildingFloor implements Serializable {

    private static final long serialVersionUID = 1L;

}
