package com.cateyes.smart.park.safe.bean.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 应急疏散表(SpSfEmergencyEvacuate)Po
 *
 * @author CatEyes
 * @since 2023-06-07 17:27:51
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_sf_emergency_evacuate")
public class EmergencyEvacuate implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "line_data")
    private String lineData;

    @TableField(value = "longitude")
    private Double longitude;

    @TableField(value = "latitude")
    private Double latitude;

    @TableField(value = "enable")
    private Boolean enable;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

}
