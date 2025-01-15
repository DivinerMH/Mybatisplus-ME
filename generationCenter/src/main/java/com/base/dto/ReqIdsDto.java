package com.base.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReqIdsDto {

    @NotNull(message = "ids不能为空")
    private List<Integer> ids;

}
