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
 * 人流管理-人流记录(SpIotFlowRecord)Po
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:51
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_iot_flow_record")
public class FlowRecord implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "device_id")
    private Integer deviceId;

    @TableField(value = "person_id")
    private Integer personId;

    @TableField(value = "person_name")
    private String personName;

    @TableField(value = "person_identity")
    private String personIdentity;

    @TableField(value = "person_type")
    private Integer personType;

    @TableField(value = "is_blacklist")
    private Boolean isBlacklist;

    @TableField(value = "is_enter")
    private Boolean isEnter;

    @TableField(value = "pass_time")
    private Date passTime;

    @TableField(value = "last_sync_time")
    private Date lastSyncTime;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
