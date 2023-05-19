package com.cateyes.smart.park.invest.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 视屏告警事件(SpIotCameraAlarm)Po
 *
 * @author CatEyes
 * @since 2023-05-17 10:03:57
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_iot_camera_alarm")
public class CameraAlarm implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "event_id")
    private String eventId;

    @TableField(value = "camera_id")
    private Integer cameraId;

    @TableField(value = "region_id")
    private Integer regionId;

    @TableField(value = "position_id")
    private Integer positionId;

    @TableField(value = "event_type")
    private Integer eventType;

    @TableField(value = "event_level")
    private Integer eventLevel;

    @TableField(value = "device_num")
    private String deviceNum;

    @TableId(value = "video_url", type = IdType.AUTO)
    private String videoUrl;

    @TableField(value = "handler")
    private String handler;

    @TableField(value = "handler_tel")
    private String handlerTel;

    @TableField(value = "state")
    private Integer state;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.INSERT)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.INSERT)
    private Date updateTime;

}
