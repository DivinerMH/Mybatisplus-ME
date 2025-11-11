package com.menghuan.HuanTools.bean.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ReqCodesDto
 *
 * @author menghuan
 * @since 2025-11-06 11:42:40
 */
@Data
@ApiModel(value = "ReqCodesDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqCodesTypeDto {

    @NotEmpty(message = "CODE集合不可为空")
    @ApiModelProperty(value = "CODE集合")
    private List<String> codes;

    private String type;

}
