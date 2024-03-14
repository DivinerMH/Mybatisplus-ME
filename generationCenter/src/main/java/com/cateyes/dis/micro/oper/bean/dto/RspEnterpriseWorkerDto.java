package com.cateyes.dis.micro.oper.bean.dto;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 企业用工(DisEnterpriseWorker)RspDto
 *
 * @author CatEyes
 * @since 2024-02-01 19:30:35
 */
@Data
@ApiModel(value = "企业用工RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspEnterpriseWorkerDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "园区企业ID")
    private Integer enterpriseId;

    @ApiModelProperty(value = "年月日期")
    private Date date;

    @ApiModelProperty(value = "状态")
    private String entCondition;

    @ApiModelProperty(value = "用工人数")
    private Integer workerNum;

    @ApiModelProperty(value = "缺口用工人数")
    private Integer lackWorkerNum;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateAt;

    /*-----------------------------非数据库属性------------------------------*/

}
