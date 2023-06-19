package com.cateyes.smart.park.safe.bean.po;

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
 * 巡检点(SpSfPatrolPoint)Po
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:14
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_sf_patrol_point")
public class PatrolPoint implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "structure_id")
    private Integer structureId;

    @TableField(value = "point_name")
    private String pointName;

    @TableField(value = "structure_code")
    private String structureCode;

    @TableField(value = "enterprise_id")
    private Integer enterpriseId;

    @TableField(value = "plan_type")
    private Integer planType;

    @TableField(value = "plan_first_time")
    private Date planFirstTime;

    @TableField(value = "executor_ids")
    private String executorIds;

    @TableField(value = "enable")
    private Boolean enable;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "manual_file_ids")
    private String manualFileIds;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
