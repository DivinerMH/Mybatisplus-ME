package com.linksame.iot.meeting.vo;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.linksame.iot.meeting.entity.IotMeeting;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 会议信息(IotMeeting)表展示对象
 *
 * @author menghuan
 * @since 2021-03-31 17:33:06
 */
@Data
@ApiModel(value = "会议信息展示对象")
public class IotMeetingVO extends IotMeeting implements Serializable {

    private static final long serialVersionUID = 1L;

}
