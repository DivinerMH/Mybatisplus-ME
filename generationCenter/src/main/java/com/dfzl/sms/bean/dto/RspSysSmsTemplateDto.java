package com.dfzl.sms.bean.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信模版表(SysSmsTemplate)RspDto
 *
 * @author makejava
 * @since 2025-01-15 15:47:03
 */
@Data
@ApiModel(value = "短信模版表RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspSysSmsTemplateDto implements Serializable {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "模板标题")
    private String templateName;

    @ApiModelProperty(value = "模板CODE")
    private String templateCode;

    @ApiModelProperty(value = "模板类型：1短信 2邮件 3微信")
    private String templateType;

    @ApiModelProperty(value = "模板内容")
    private String templateContent;

    @ApiModelProperty(value = "模板测试json")
    private String templateTestJson;

    @ApiModelProperty(value = "创建日期")
    private String createTime;

    @ApiModelProperty(value = "创建人登录名称")
    private String createBy;

    @ApiModelProperty(value = "更新日期")
    private String updateTime;

    @ApiModelProperty(value = "更新人登录名称")
    private String updateBy;

    @ApiModelProperty(value = "是否使用中 1是0否")
    private String useStatus;

    @ApiModelProperty(value = "删除标记")
    private Integer delFlag;

    @ApiModelProperty(value = "组织结构")
    private String orgCode;

    @ApiModelProperty(value = "模板分类id")
    private String categoryId;

    /*-----------------------------非数据库属性------------------------------*/

}
