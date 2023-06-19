package com.cateyes.smart.park.safe.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 巡检任务工单(SpSfPatrolTaskWork)RspDto
 *
 * @author CatEyes
 * @since 2023-06-12 16:27:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspPatrolTaskWorkDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "任务ID")
    private Integer taskId;

    @ApiModelProperty(value = "执行人ID")
    private Integer executorId;

    @ApiModelProperty(value = "巡检开始时间")
    private Date startTime;

    @ApiModelProperty(value = "巡检结束时间")
    private Date endTime;

    @ApiModelProperty(value = "上次巡检时间")
    private Date lastTime;

    @ApiModelProperty(value = "计划时间")
    private Date planTime;

    @ApiModelProperty(value = "巡检记录")
    private String record;

    @ApiModelProperty(value = "状态：0-待巡检 1-已完成 2-漏检")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /*-----------------------------非数据库属性------------------------------*/

}
