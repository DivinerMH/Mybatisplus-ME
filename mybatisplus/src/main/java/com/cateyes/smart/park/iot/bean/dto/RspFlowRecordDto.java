package com.cateyes.smart.park.iot.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 人流管理-人流记录(SpIotFlowRecord)RspDto
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspFlowRecordDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "门禁设备ID")
    private Integer deviceId;

    @ApiModelProperty(value = "人员ID")
    private Integer personId;

    @ApiModelProperty(value = "人员名称")
    private String personName;

    @ApiModelProperty(value = "人员身份证")
    private String personIdentity;

    @ApiModelProperty(value = "人员类型：0-员工 1-访客")
    private Integer personType;

    @ApiModelProperty(value = "是否黑名单：0-否 1-是")
    private Boolean isBlacklist;

    @ApiModelProperty(value = "是否入园：0-否 1-是")
    private Boolean isEnter;

    @ApiModelProperty(value = "通过时间")
    private Date passTime;

    @ApiModelProperty(value = "最新同步时间")
    private Date lastSyncTime;

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
