package com.linksame.iot.external.structure.vo;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.iot.external.structure.entity.ParkProjectSub;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 资源管理-项目分期表(ParkProjectSub)表展示对象
 *
 * @author menghuan
 * @since 2022-03-11 15:39:02
 */
@Data
@ApiModel(value = "资源管理-项目分期表展示对象")
public class ParkProjectSubVO extends ParkProjectSub implements Serializable {

    private static final long serialVersionUID = 1L;

}
