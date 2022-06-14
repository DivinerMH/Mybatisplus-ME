package com.linksame.iot.device.bill.vo;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.iot.device.bill.entity.DeviceInformationVirtual;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 虚拟设备台账表(DeviceInformationVirtual)表展示对象
 *
 * @author menghuan
 * @since 2022-04-11 16:24:28
 */
@Data
@ApiModel(value = "虚拟设备台账表展示对象")
public class DeviceInformationVirtualVO extends DeviceInformationVirtual implements Serializable {

    private static final long serialVersionUID = 1L;

}
