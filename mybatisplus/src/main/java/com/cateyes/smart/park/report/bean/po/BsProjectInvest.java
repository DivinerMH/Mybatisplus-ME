package com.cateyes.smart.park.report.bean.po;

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
 * 智慧大屏-系统-工业投资类项目报表(SpBsProjectInvest)Po
 *
 * @author CatEyes
 * @since 2023-06-29 10:51:58
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_bs_project_invest")
public class BsProjectInvest implements Serializable {

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
