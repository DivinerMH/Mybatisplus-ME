package com.linksame.iot.external.structure.dto;


import com.linksame.iot.external.structure.entity.ParkProjectSub;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 资源管理-项目分期表(ParkProjectSub)表传输对象
 *
 * @author menghuan
 * @since 2022-03-11 15:39:03
 */
@Data
@ApiModel(value = "资源管理-项目分期表传输对象")
@EqualsAndHashCode(callSuper = true)
public class ParkProjectSubDTO extends ParkProjectSub implements Serializable {

    private static final long serialVersionUID = 1L;

}
