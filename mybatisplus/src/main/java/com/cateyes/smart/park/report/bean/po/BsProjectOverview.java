package com.cateyes.smart.park.report.bean.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 智慧大屏-系统-工程项目总览(SpBsProjectOverview)Po
 *
 * @author CatEyes
 * @since 2023-06-29 10:41:05
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_bs_project_overview")
public class BsProjectOverview implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "date")
    private Date date;

    @TableField(value = "total_project")
    private Double totalProject;

    @TableField(value = "total_project_year")
    private Double totalProjectYear;

    @TableField(value = "total_project_build")
    private Double totalProjectBuild;

    @TableField(value = "total_project_operation")
    private Double totalProjectOperation;

    @TableField(value = "total_project_key")
    private Double totalProjectKey;

    @TableField(value = "invest_plan")
    private Double investPlan;

    @TableField(value = "invest_total")
    private Double investTotal;

    @TableField(value = "invest_rate")
    private Double investRate;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
