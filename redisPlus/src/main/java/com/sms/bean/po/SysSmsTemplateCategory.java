package com.sms.bean.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 短信模板分类(SysSmsTemplateCategory)Po
 *
 * @author makejava
 * @since 2025-01-15 15:47:27
 */
@Data
@ApiModel(value = "短信模板分类Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("SYS_SMS_TEMPLATE_CATEGORY")
public class SysSmsTemplateCategory extends JeecgEntity {

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableLogic
    private Integer delFlag;

    @ApiModelProperty(value = "组织机构")
    private String orgCode;

}
