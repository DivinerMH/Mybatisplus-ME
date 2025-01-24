package com.sms.bean.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信表(SysSms)RspDto
 *
 * @author menghuan
 * @since 2025-01-22 09:49:07
 */
@Data
@ApiModel(value = "短信表RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspSysSmsDto implements Serializable {

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "消息标题")
    private String esTitle;

    @ApiModelProperty(value = "发送方式：参考枚举MessageTypeEnum")
    private String esType;

    @ApiModelProperty(value = "接收人")
    private String esReceiver;

    @ApiModelProperty(value = "发送所需参数Json格式")
    private String esParam;

    @ApiModelProperty(value = "推送内容")
    private String esContent;

    @ApiModelProperty(value = "推送时间")
    private Date esSendTime;

    @ApiModelProperty(value = "推送状态 0未推送 1推送成功 2推送失败 -1失败不再发送")
    private String esSendStatus;

    @ApiModelProperty(value = "发送次数 超过5次不再发送")
    private Integer esSendNum;

    @ApiModelProperty(value = "推送失败原因")
    private String esResult;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建人登录名称")
    private String createBy;

    @ApiModelProperty(value = "创建日期")
    private Date createTime;

    @ApiModelProperty(value = "更新人登录名称")
    private String updateBy;

    @ApiModelProperty(value = "更新日期")
    private Date updateTime;

    /*-----------------------------非数据库属性------------------------------*/

}
