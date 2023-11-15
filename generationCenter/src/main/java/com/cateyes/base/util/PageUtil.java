package com.cateyes.base.util;

import java.util.Collections;
import java.util.List;

public class PageUtil {

    public static <T> PageInfo<T> build(Integer pageNo, Integer pageSize, List<T> list, Integer total) {

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setList(list);
        pageInfo.setTotal(total);
        pageInfo.setPages(0 == total ? 0 : (total - 1) / pageSize + 1);
        // pageInfo.setHasPreviousPage(pageNo > 1);
        // pageInfo.setHasNextPage(pageNo < pageInfo.getPages());
        // pageInfo.setIsFirstPage(pageNo == 1);
        // pageInfo.setIsLastPage(pageNo == pageInfo.getPages() || pageInfo.getPages() == 0);
        // pageInfo.setPrePage((pageNo > 1) ? (pageNo - 1) : pageNo);
        // ageInfo.setNextPage((pageNo < pageInfo.getPages()) ? (pageNo + 1) : pageInfo.getPages());

        return pageInfo;
    }

    public static <T> PageInfo<T> buildEmpty() {
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(10);
        pageInfo.setList(Collections.emptyList());
        pageInfo.setTotal(0);
        pageInfo.setPages(0);
        return pageInfo;
    }

}
