package com.dfzl.sms.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 短信表(SysSms)Po
 *
 * @author menghuan
 * @since 2025-01-22 09:49:04
 */
@Data
@ApiModel(value = "短信表Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("SYS_SMS")
public class SysSms extends JeecgEntity {

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

}
