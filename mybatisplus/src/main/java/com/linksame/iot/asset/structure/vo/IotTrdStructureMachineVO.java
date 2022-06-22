package com.linksame.vo;


import com.linksame.entity.IotTrdStructureMachine;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 3D模型组件与资产结构设备关系(IotTrdStructureMachine)表展示对象
 *
 * @author menghuan
 * @since 2022-04-19 14:16:47
 */
@Data
@ApiModel(value = "3D模型组件与资产结构设备关系展示对象")
public class IotTrdStructureMachineVO extends IotTrdStructureMachine implements Serializable {

    private static final long serialVersionUID = 1L;

}
