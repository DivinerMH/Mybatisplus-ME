package com.hzcloud.iot.dto;


import com.hzcloud.iot.entity.DangerNode;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 巡检节点(DangerNode)表传输对象
 *
 * @author MH
 * @since 2020-11-13 15:17:24
 */
@Data
@ApiModel(value = "巡检节点传输对象")
@EqualsAndHashCode(callSuper = true)
public class DangerNodeDTO extends DangerNode implements Serializable {

    private static final long serialVersionUID = 1L;

}