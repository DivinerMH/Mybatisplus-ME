package com.hzcloud.iot.vo;


import com.hzcloud.iot.entity.DangerNode;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 巡检节点(DangerNode)表展示对象
 *
 * @author MH
 * @since 2020-11-13 15:17:23
 */
@Data
@ApiModel(value = "巡检节点展示对象")
public class DangerNodeVO extends DangerNode implements Serializable {

    private static final long serialVersionUID = 1L;

}