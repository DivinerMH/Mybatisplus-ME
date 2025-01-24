package com.sms.bean.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信发送任务表(SysSmsTask)RspDto
 *
 * @author makejava
 * @since 2025-01-15 15:46:31
 */
@Data
@ApiModel(value = "短信发送任务表RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspSysSmsTaskDto implements Serializable {

    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "短信内容")
    private String content;

    @ApiModelProperty(value = "发送方式 1及时发送 2定时发送")
    private String sendType;

    @ApiModelProperty(value = "发送状态：0待发送，1已发送，2已取消")
    private String status;

    @ApiModelProperty(value = "发送总条数")
    private Integer sendNum;

    @ApiModelProperty(value = "发送通道：1阿里云")
    private String channel;

    @ApiModelProperty(value = "业务类型")
    private String bizType;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "组织机构")
    private String orgCode;

    @ApiModelProperty(value = "发送时间")
    private String sendTime;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "删除标记")
    private Integer delFlag;

    @ApiModelProperty(value = "操作时间")
    private String operateTime;

    /*-----------------------------非数据库属性------------------------------*/

}
