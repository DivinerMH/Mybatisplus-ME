package com.dfzl.sms.bean.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信发送用户表(SysSmsUser)RspDto
 *
 * @author makejava
 * @since 2025-01-15 15:48:28
 */
@Data
@ApiModel(value = "短信发送用户表RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspSysSmsUserDto implements Serializable {

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

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "住址机构")
    private String orgCode;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "公司英文名称")
    private String companyEngName;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    /*-----------------------------非数据库属性------------------------------*/

}
