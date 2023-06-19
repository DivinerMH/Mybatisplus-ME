package com.cateyes.smart.park.iot.bean.dto;

import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 摄像头(SpIotCamera)ReqDto
 *
 * @author CatEyes
 * @since 2023-06-19 16:30:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqCameraDto extends BaseDto {

    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "设备类别（关联）")
    private Integer deviceTypeId;

    @ApiModelProperty(value = "设备细分类别（关联）")
    private Integer deviceTypeSubId;

    @ApiModelProperty(value = "设备名称")
    private String cameraName;

    @ApiModelProperty(value = "设备属性：1-摄像头；2-高空摄像头；")
    private Integer deviceAttr;

    @ApiModelProperty(value = "设备编号")
    private String deviceNum;

    @ApiModelProperty(value = "设备状态：1-在线；2-离线")
    private Integer cameraStatus;

    @ApiModelProperty(value = "是否启用：1-启用；2-禁用；")
    private Integer isDisabled;

    @ApiModelProperty(value = "区域ID")
    private Integer regionId;

    @ApiModelProperty(value = "设备经度")
    private Double cameraLon;

    @ApiModelProperty(value = "设备纬度")
    private Double cameraLat;

    @ApiModelProperty(value = "频道名称")
    private String channelName;

    @ApiModelProperty(value = "视频流地址")
    private String cameraUrl;

    @ApiModelProperty(value = "最新同步时间")
    private Date lastSyncTime;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateAt;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    /*-----------------------------非数据库属性------------------------------*/

}
