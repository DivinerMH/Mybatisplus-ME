package com.cateyes.smart.park.iot.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 视屏告警事件(SpIotFlowEntranceAlarm)Po
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:39
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_iot_flow_entrance_alarm")
public class FlowEntranceAlarm implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "device_id")
    private Integer deviceId;

    @TableField(value = "region_id")
    private Integer regionId;

    @TableField(value = "position_id")
    private Integer positionId;

    @TableField(value = "event_id")
    private String eventId;

    @TableField(value = "event_type")
    private Integer eventType;

    @TableField(value = "event_type_detail")
    private String eventTypeDetail;

    @TableField(value = "event_level")
    private Integer eventLevel;

    @TableId(value = "video_url", type = IdType.AUTO)
    private String videoUrl;

    @TableField(value = "pic_url")
    private String picUrl;

    @TableField(value = "handler")
    private String handler;

    @TableField(value = "handler_tel")
    private String handlerTel;

    @TableField(value = "state")
    private Integer state;

    @TableField(value = "original_data")
    private String originalData;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
