package com.linksame.iot.device.bill.dto;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.iot.device.bill.entity.DeviceInformationAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 虚拟设备台账属性表(DeviceInformationAttribute)表传输对象
 *
 * @author menghuan
 * @since 2022-04-11 16:23:59
 */
@Data
@ApiModel(value = "虚拟设备台账属性表传输对象")
@EqualsAndHashCode(callSuper = true)
public class DeviceInformationAttributeDTO extends DeviceInformationAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

}
