package com.menghuan.HuanTools.bean.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ReqIdDto
 *
 * @author menghuan
 * @since 2025-07-23 11:42:40
 */
@Data
@ApiModel(value = "ReqIdDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqIdDto {

    @NotBlank(message = "id不可为空")
    @ApiModelProperty(value = "id")
    private String id;

}
