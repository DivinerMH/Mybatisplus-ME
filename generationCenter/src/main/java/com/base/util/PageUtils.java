package com.base.util;

import java.util.List;

public class PageUtils {

    public static <T> PageInfo<T> build(Integer pageNo, Integer pageSize, List<T> list, Integer total) {
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setList(list);
        pageInfo.setTotal(total);
        pageInfo.setPages(0 == total ? 0 : (total - 1) / pageSize + 1);
        return pageInfo;
    }

    public static <T> PageInfo<T> build(Integer pageNo, Integer pageSize, List<T> list, Long total) {
        return build(pageNo, pageSize, list, total.intValue());
    }

}
