package com.sms.bean.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 短信表(SysSms)ReqQueryDto
 *
 * @author menghuan
 * @since 2025-01-22 09:49:07
 */
@Data
@ApiModel(value = "短信表ReqQueryDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqSysSmsQueryDto extends ReqBaseQueryDto {

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

    @ApiModelProperty(value = "id集合")
    private List<String> ids;
}
