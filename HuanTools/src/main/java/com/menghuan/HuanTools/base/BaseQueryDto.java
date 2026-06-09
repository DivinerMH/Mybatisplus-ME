package com.menghuan.HuanTools.base;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * BaseQueryDto
 */
public class BaseQueryDto implements Serializable {

    // @NotNull(message = "pageNo不能为空")
    @Min(value = 1, message = "pageNo最小值为1")
    @ApiModelProperty(value = "当前页数", required = false, example = "1")
    private Integer pageNo = 1;

    // @NotNull(message = "pageSize不能为空")
    @Min(value = 1, message = "pageSize最小值为10")
    @Max(value = 100, message = "pageSize最大值为100")
    @ApiModelProperty(value = "每页个数", required = false, example = "10")
    private Integer pageSize = 10;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
