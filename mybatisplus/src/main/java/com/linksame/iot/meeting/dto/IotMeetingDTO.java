package com.linksame.iot.meeting.dto;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.iot.meeting.entity.IotMeeting;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 会议信息(IotMeeting)表传输对象
 *
 * @author menghuan
 * @since 2021-03-31 17:33:06
 */
@Data
@ApiModel(value = "会议信息传输对象")
@EqualsAndHashCode(callSuper = true)
public class IotMeetingDTO extends IotMeeting implements Serializable {

    private static final long serialVersionUID = 1L;

}
