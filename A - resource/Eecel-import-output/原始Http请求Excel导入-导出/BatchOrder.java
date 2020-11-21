package com.joolun.cloud.mall.common.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.github.crab2died.annotation.ExcelField;
import com.joolun.cloud.common.core.constant.CommonConstants;
import com.joolun.cloud.mall.common.constant.MallConstants;
import com.joolun.cloud.mall.common.enums.OrderInfoEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
