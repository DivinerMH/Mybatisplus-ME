package com.cateyes.dis.micro.oper.bean.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 企业用工(DisEnterpriseWorker)Po
 *
 * @author CatEyes
 * @since 2024-02-01 19:30:34
 */
@Data
@ApiModel(value = "企业用工Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("dis_enterprise_worker")
public class EnterpriseWorker extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
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
