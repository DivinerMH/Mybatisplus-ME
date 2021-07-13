package com.linksame.iot.visual.dto;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.iot.visual.entity.Component;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 组件(Component)表传输对象
 *
 * @author menghuan
 * @since 2021-07-13 11:24:51
 */
@Data
@ApiModel(value = "组件传输对象")
@EqualsAndHashCode(callSuper = true)
public class ComponentDTO extends Component implements Serializable {

    private static final long serialVersionUID = 1L;

}
