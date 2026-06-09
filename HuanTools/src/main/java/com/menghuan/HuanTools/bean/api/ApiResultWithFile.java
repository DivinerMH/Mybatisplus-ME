package com.menghuan.HuanTools.bean.api;

import java.util.List;

import com.menghuan.HuanTools.bean.result.ApiResult;
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
