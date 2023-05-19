package com.cateyes.smart.park.invest.bean.dto;

    
    






import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 视屏告警事件(SpIotCameraAlarm)ReqDto
 *
 * @author CatEyes
 * @since 2023-05-16 14:22:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspIotCameraAlarmDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;
    
    @ApiModelProperty(value = "园区ID")
    private Integer parkId;
    
    @ApiModelProperty(value = "事件ID")
    private String eventId;
    
    @ApiModelProperty(value = "设备ID")
    private Integer cameraId;
    
    @ApiModelProperty(value = "区域ID")
    private Integer regionId;
    
    @ApiModelProperty(value = "位置ID")
    private Integer positionId;
    
    @ApiModelProperty(value = "事件类型（事件信息）")
    private Integer eventType;
    
    @ApiModelProperty(value = "事件等级：0-I级 1-II级 2-III级")
    private Integer eventLevel;
    
    @ApiModelProperty(value = "设备编号")
    private String deviceNum;
    
    @ApiModelProperty(value = "实时视频")
    private String videoUrl;
    
    @ApiModelProperty(value = "处理人")
    private String handler;
    
    @ApiModelProperty(value = "处理人电话")
    private String handlerTel;
    
    @ApiModelProperty(value = "状态：0-未处理 1-处理中 1-已处理")
    private Integer state;
    
    @ApiModelProperty(value = "创建人")
    private Integer createBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    
    @ApiModelProperty(value = "更新人")
    private Integer updateBy;
    
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    

}
