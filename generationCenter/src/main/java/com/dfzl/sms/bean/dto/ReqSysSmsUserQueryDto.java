package com.dfzl.sms.bean.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 短信发送用户表(SysSmsUser)ReqQueryDto
 *
 * @author makejava
 * @since 2025-01-15 15:48:27
 */
@Data
@ApiModel(value = "短信发送用户表ReqQueryDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqSysSmsUserQueryDto extends ReqBaseQueryDto {

    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "短信任务id")
    private String smsTaskId;

    @ApiModelProperty(value = "手机号")
    private String phoneNum;

    @ApiModelProperty(value = "0待发送，1已发送成功，2发送失败")
    private Integer sendStatus;

    @ApiModelProperty(value = "删除标记")
    private Integer delFlag;

    @ApiModelProperty(value = "住址机构")
    private String orgCode;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "公司英文名称")
    private String companyEngName;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    @ApiModelProperty(value = "id集合")
    private List<String> ids;
}
