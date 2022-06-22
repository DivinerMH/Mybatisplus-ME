package com.linksame.iot.device.bill.dto;


import com.linksame.iot.device.bill.entity.DeviceInformationVirtual;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 虚拟设备台账表(DeviceInformationVirtual)表传输对象
 *
 * @author menghuan
 * @since 2022-04-11 16:24:28
 */
@Data
@ApiModel(value = "虚拟设备台账表传输对象")
@EqualsAndHashCode(callSuper = true)
public class DeviceInformationVirtualDTO extends DeviceInformationVirtual implements Serializable {

    private static final long serialVersionUID = 1L;

}
