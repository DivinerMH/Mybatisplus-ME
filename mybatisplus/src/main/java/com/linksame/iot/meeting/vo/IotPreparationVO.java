package com.linksame.iot.meeting.vo;


import com.linksame.iot.meeting.entity.IotPreparation;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 会议准备(IotPreparation)表展示对象
 *
 * @author menghuan
 * @since 2021-03-20 16:29:58
 */
@Data
@ApiModel(value = "会议准备展示对象")
public class IotPreparationVO extends IotPreparation implements Serializable {

    private static final long serialVersionUID = 1L;

}