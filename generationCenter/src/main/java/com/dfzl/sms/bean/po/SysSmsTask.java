package com.dfzl.sms.bean.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.bean.JeecgEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 短信发送任务表(SysSmsTask)Po
 *
 * @author makejava
 * @since 2025-01-15 15:46:30
 */
@Data
@ApiModel(value = "短信发送任务表Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("SYS_SMS_TASK")
public class SysSmsTask extends JeecgEntity {

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

    @TableLogic
    private Integer delFlag;

    @ApiModelProperty(value = "操作时间")
    private String operateTime;

}
