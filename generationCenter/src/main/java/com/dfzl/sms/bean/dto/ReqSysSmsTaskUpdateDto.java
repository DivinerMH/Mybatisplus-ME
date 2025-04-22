package com.dfzl.sms.bean.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信发送任务表(SysSmsTask)ReqUpdateDto
 *
 * @author makejava
 * @since 2025-01-15 15:46:30
 */
@Data
@ApiModel(value = "短信发送任务表ReqUpdateDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqSysSmsTaskUpdateDto {

    @NotBlank(message = "主键ID不可为空")
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

    @ApiModelProperty(value = "删除标记")
    private Integer delFlag;

    @ApiModelProperty(value = "操作时间")
    private String operateTime;

}
