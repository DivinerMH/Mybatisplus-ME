package com.cateyes.smart.park.iot.bean.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 摄像头(SpIotCamera)Po
 *
 * @author CatEyes
 * @since 2023-06-19 16:30:45
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_iot_camera")
public class Camera implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "device_type_id")
    private Integer deviceTypeId;

    @TableField(value = "device_type_sub_id")
    private Integer deviceTypeSubId;

    @TableField(value = "camera_name")
    private String cameraName;

    @TableField(value = "device_attr")
    private Integer deviceAttr;

    @TableField(value = "device_num")
    private String deviceNum;

    @TableField(value = "camera_status")
    private Integer cameraStatus;

    @TableField(value = "is_disabled")
    private Integer isDisabled;

    @TableField(value = "region_id")
    private Integer regionId;

    @TableField(value = "camera_lon")
    private Double cameraLon;

    @TableField(value = "camera_lat")
    private Double cameraLat;

    @TableField(value = "channel_name")
    private String channelName;

    @TableField(value = "camera_url")
    private String cameraUrl;

    @TableField(value = "last_sync_time")
    private Date lastSyncTime;

    @TableField(value = "create_at")
    private Date createAt;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "update_at")
    private Date updateAt;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

}
