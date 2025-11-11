package com.dfzl.system.bean.dto;

import java.util.Date;
import java.util.List;

import org.df.order.common.dto.ReqBaseQueryDto;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 系统通告表(SysAnnouncement)ReqQueryDto
 *
 * @author menghuan
 * @since 2025-09-11 15:01:54
 */
@Data
@ApiModel(value = "系统通告表ReqQueryDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqSysAnnouncementQueryDto extends ReqBaseQueryDto {

    @ApiModelProperty(value = "")
    private String id;

    @ApiModelProperty(value = "标题")
    private String titile;

    @ApiModelProperty(value = "内容")
    private String msgContent;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "发布人")
    private String sender;

    @ApiModelProperty(value = "优先级（L低，M中，H高）")
    private String priority;

    @ApiModelProperty(value = "消息类型 1:通知公告 2:审批消息 3-系统通告")
    private String msgCategory;

    @ApiModelProperty(value = "通告对象类型（USER:指定用户，ALL:全体用户）")
    private String msgType;

    @ApiModelProperty(value = "发布状态（0未发布，1已发布，2已撤销）")
    private String sendStatus;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发布时间")
    private Date sendTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "撤销时间")
    private Date cancelTime;

    @ApiModelProperty(value = "业务类型(email:邮件 bpm:流程)")
    private String busType;

    @ApiModelProperty(value = "业务id")
    private String busId;

    @ApiModelProperty(value = "打开方式(组件：component 路由：url)")
    private String openType;

    @ApiModelProperty(value = "组件/路由 地址")
    private String openPage;

    @ApiModelProperty(value = "指定用户")
    private String userIds;

    @ApiModelProperty(value = "摘要")
    private String msgAbstract;

    @ApiModelProperty(value = "钉钉task_id，用于撤回消息")
    private String dtTaskId;

    /*-----------------------------非数据库属性------------------------------*/

    @ApiModelProperty(value = "创建人-名称")
    private String createByName;

    @ApiModelProperty(value = "id集合")
    private List<String> ids;
}
