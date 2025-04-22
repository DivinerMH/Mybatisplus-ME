package com.cateyes.dis.micro.oper.bean.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 企业用工(DisEnterpriseWorker)ReqUpdateDto
 *
 * @author CatEyes
 * @since 2024-02-01 19:30:34
 */
@Data
@ApiModel(value = "企业用工ReqUpdateDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqEnterpriseWorkerUpdateDto {

    @NotNull(message = "主键ID不可为NULL")
    @ApiModelProperty(value = "主键ID", required = true)
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

}
