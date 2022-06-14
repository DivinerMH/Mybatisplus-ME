package com.linksame.dto;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.entity.IotTrdStructureMachine;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 3D模型组件与资产结构设备关系(IotTrdStructureMachine)表传输对象
 *
 * @author menghuan
 * @since 2022-04-19 14:16:48
 */
@Data
@ApiModel(value = "3D模型组件与资产结构设备关系传输对象")
@EqualsAndHashCode(callSuper = true)
public class IotTrdStructureMachineDTO extends IotTrdStructureMachine implements Serializable {

    private static final long serialVersionUID = 1L;

}
