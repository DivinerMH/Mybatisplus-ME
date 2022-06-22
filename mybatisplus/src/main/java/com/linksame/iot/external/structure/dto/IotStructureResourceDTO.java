package com.linksame.iot.external.structure.dto;


import com.linksame.iot.external.structure.entity.IotStructureResource;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 资产结构与资源关系（深宝园-手动维护）(IotStructureResource)表传输对象
 *
 * @author menghuan
 * @since 2022-03-11 16:14:07
 */
@Data
@ApiModel(value = "资产结构与资源关系（深宝园-手动维护）传输对象")
@EqualsAndHashCode(callSuper = true)
public class IotStructureResourceDTO extends IotStructureResource implements Serializable {

    private static final long serialVersionUID = 1L;

}
