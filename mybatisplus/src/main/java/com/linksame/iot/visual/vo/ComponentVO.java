package com.linksame.iot.visual.vo;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.iot.visual.entity.Component;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 组件(Component)表展示对象
 *
 * @author menghuan
 * @since 2021-07-13 11:24:50
 */
@Data
@ApiModel(value = "组件展示对象")
public class ComponentVO extends Component implements Serializable {

    private static final long serialVersionUID = 1L;

}
