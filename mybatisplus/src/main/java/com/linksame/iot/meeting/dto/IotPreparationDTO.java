package com.linksame.iot.meeting.dto;


import com.linksame.iot.meeting.entity.IotPreparation;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 会议准备(IotPreparation)表传输对象
 *
 * @author menghuan
 * @since 2021-03-20 16:29:59
 */
@Data
@ApiModel(value = "会议准备传输对象")
@EqualsAndHashCode(callSuper = true)
public class IotPreparationDTO extends IotPreparation implements Serializable {

    private static final long serialVersionUID = 1L;

}