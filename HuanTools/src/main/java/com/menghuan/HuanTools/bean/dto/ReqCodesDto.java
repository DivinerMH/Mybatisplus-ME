package com.menghuan.HuanTools.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * ReqCodesDto
 *
 * @author menghuan
 * @since 2026-06-06 06:06:06
 */
@Data
@ApiModel(value = "ReqCodesDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqCodesDto {

    @NotEmpty(message = "CODE集合不可为空")
    @ApiModelProperty(value = "CODE集合")
    private List<String> codes;

}
