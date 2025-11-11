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
 * ReqIdsDto
 *
 * @author menghuan
 * @since 2025-07-23 11:42:40
 */
@Data
@ApiModel(value = "ReqIdsDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqIdsTypeDto {

    @NotEmpty(message = "id集合不可为空")
    @ApiModelProperty(value = "id集合")
    private List<String> ids;

    @ApiModelProperty(value = "类型、状态")
    private String type;

}
