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
 * 粉尘监测仪告警(SpIotMonitorDustAlarm)Po
 *
 * @author CatEyes
 * @since 2023-06-25 11:13:04
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_iot_monitor_dust_alarm")
public class MonitorDustAlarm implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "device_id")
    private Integer deviceId;

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
