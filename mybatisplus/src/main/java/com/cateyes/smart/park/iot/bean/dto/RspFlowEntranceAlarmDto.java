package com.cateyes.smart.park.iot.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 视屏告警事件(SpIotFlowEntranceAlarm)RspDto
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspFlowEntranceAlarmDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "门禁设备ID")
    private Integer deviceId;

    @ApiModelProperty(value = "区域ID")
    private Integer regionId;

    @ApiModelProperty(value = "位置ID")
    private Integer positionId;

    @ApiModelProperty(value = "事件ID（事件编码）")
    private String eventId;

    @ApiModelProperty(value = "事件类型（关联事件类型编码）")
    private Integer eventType;

    @ApiModelProperty(value = "事件信息")
    private String eventTypeDetail;

    @ApiModelProperty(value = "事件等级：0-其他事件 1-一般事件 2-紧急事件 3-重大事件")
    private Integer eventLevel;

    @ApiModelProperty(value = "实时视频")
    private String videoUrl;

    @ApiModelProperty(value = "实时图片（多文件逗号分割）")
    private String picUrl;

    @ApiModelProperty(value = "处理人")
    private String handler;

    @ApiModelProperty(value = "处理人电话")
    private String handlerTel;

    @ApiModelProperty(value = "状态：0-未处理 1-已处理")
    private Integer state;

    @ApiModelProperty(value = "上报原始数据")
    private String originalData;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /*-----------------------------非数据库属性------------------------------*/

}
