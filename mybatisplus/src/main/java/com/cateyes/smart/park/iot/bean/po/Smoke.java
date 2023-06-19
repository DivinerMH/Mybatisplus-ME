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
 * 烟感设备(SpIotSmoke)Po
 *
 * @author CatEyes
 * @since 2023-06-19 16:57:45
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_iot_smoke")
public class Smoke implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "device_type_id")
    private Integer deviceTypeId;

    @TableField(value = "device_type_sub_id")
    private Integer deviceTypeSubId;

    @TableField(value = "device_name")
    private String deviceName;

    @TableField(value = "device_attr")
    private Integer deviceAttr;

    @TableField(value = "device_num")
    private String deviceNum;

    @TableField(value = "region_id")
    private Integer regionId;

    @TableField(value = "position_id")
    private Integer positionId;

    @TableField(value = "longitude")
    private Double longitude;

    @TableField(value = "latitude")
    private Double latitude;

    @TableField(value = "last_sync_time")
    private Date lastSyncTime;

    @TableField(value = "is_disabled")
    private Boolean isDisabled;

    @TableField(value = "status")
    private Boolean status;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
