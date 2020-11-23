package com.joolun.cloud.mall.common.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.github.crab2died.annotation.ExcelField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: Wong
 * @ClassName: BatchOrder
 * @Date: 2020/11/12 11:16
 * @Description: 团体(批量)订单实体
 * @Version: V1.0
 **/
@Data
@TableName("batch_order")
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "团体订单")
public class BatchOrder extends Model<BatchOrder> implements Serializable {

	private static final long serialVersionUID = 1L;

	//用户ID
	@ApiModelProperty(value = "用户ID")
	@ExcelField(title = "用户ID")
	private String userId;

}
