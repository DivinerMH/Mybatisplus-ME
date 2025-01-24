package com.menghuan.HuanTools.api;

import java.util.List;

import lombok.Data;

/**
 * Description: TODO
 *
 * @author: CatEyes
 * @date: 2023/4/26 20:15
 */
@Data
public class ApiResultWithFile<T> extends ApiResult<T> {

    private List<SpFileInfo> files;

}
