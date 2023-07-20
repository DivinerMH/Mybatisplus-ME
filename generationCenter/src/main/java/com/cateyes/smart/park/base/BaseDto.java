package com.cateyes.smart.park.base;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.cateyes.smart.park.base.valid.PageValid;
import com.cateyes.smart.park.base.valid.TimeValid;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: TODO
 *
 * @author: CatEyes
 * @date: 2023/3/27 17:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto implements Serializable {
    @NotNull(message = "pageNo不能为空", groups = PageValid.class)
    @Min(value = 1, message = "pageNo最小值为1", groups = PageValid.class)
    @ApiModelProperty(value = "当前页数", example = "1",  required = true)
    private Integer pageNo;

    @NotNull(message = "pageSize不能为空", groups = PageValid.class)
    @Min(value = 1, message = "pageSize最小值为1", groups = PageValid.class)
    @Max(value = 100, message = "pageSize最大值为100", groups = PageValid.class)
    @ApiModelProperty(value = "每页个数", example = "10",  required = true)
    private Integer pageSize;

    @NotNull(message = "startTime不能为空", groups = TimeValid.class)
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @NotNull(message = "endTime不能为空", groups = TimeValid.class)
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "开始页号", example = "")
    private Integer startNo;

    private String sort;

    private String dir = "ASC";

    private Integer getStartNo() {
        if (startNo != null) {
            return startNo;
        }
        return (pageNo - 1) * pageSize;
    }
}
