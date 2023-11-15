package com.cateyes.base.dto;

import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReqIdDto {

    @NotNull(message = "id不能为空")
    private Integer id;

}
