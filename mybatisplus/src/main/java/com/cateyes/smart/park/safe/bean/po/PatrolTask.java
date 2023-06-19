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
 * 巡检任务(SpSfPatrolTask)Po
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:47
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_sf_patrol_task")
public class PatrolTask implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "point_id")
    private Integer pointId;

    @TableField(value = "task_name")
    private String taskName;

    @TableField(value = "task_code")
    private String taskCode;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "time_consuming")
    private Integer timeConsuming;

    @TableField(value = "enable")
    private Boolean enable;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
