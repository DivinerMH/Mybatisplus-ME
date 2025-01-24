package com.sms.bean.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 短信模版表(SysSmsTemplate)Po
 *
 * @author makejava
 * @since 2025-01-15 15:47:03
 */
@Data
@ApiModel(value = "短信模版表Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("SYS_SMS_TEMPLATE")
public class SysSmsTemplate extends JeecgEntity {

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

    @ApiModelProperty(value = "是否使用中 1是0否")
    private String useStatus;

    @TableLogic
    private Integer delFlag;

    @ApiModelProperty(value = "组织结构")
    private String orgCode;

    @ApiModelProperty(value = "模板分类id")
    private String categoryId;

}
