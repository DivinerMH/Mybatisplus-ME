package com.cateyes.smart.park.report.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 智慧大屏-系统-工程项目总览(SpBsProjectOverview)RspDto
 *
 * @author CatEyes
 * @since 2023-06-29 10:41:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspBsProjectOverviewDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "年月")
    private Date date;

    @ApiModelProperty(value = "工程项目总数")
    private Double totalProject;

    @ApiModelProperty(value = "当年累计新增项目数")
    private Double totalProjectYear;

    @ApiModelProperty(value = "在建（动工）项目数")
    private Double totalProjectBuild;

    @ApiModelProperty(value = "投产项目数")
    private Double totalProjectOperation;

    @ApiModelProperty(value = "重点项目数")
    private Double totalProjectKey;

    @ApiModelProperty(value = "计划投资总额（万元）")
    private Double investPlan;

    @ApiModelProperty(value = "累计投资总额（万元）")
    private Double investTotal;

    @ApiModelProperty(value = "项目投资完成率（%）")
    private Double investRate;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间（上报时间）")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /*-----------------------------非数据库属性------------------------------*/

}
