package com.linksame.iot.external.structure.vo;


import com.linksame.iot.external.structure.entity.IotStructureResource;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 资产结构与资源关系（深宝园-手动维护）(IotStructureResource)表展示对象
 *
 * @author menghuan
 * @since 2022-03-11 16:14:07
 */
@Data
@ApiModel(value = "资产结构与资源关系（深宝园-手动维护）展示对象")
public class IotStructureResourceVO extends IotStructureResource implements Serializable {

    private static final long serialVersionUID = 1L;

}
