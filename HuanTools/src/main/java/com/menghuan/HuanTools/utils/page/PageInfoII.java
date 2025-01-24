package com.menghuan.HuanTools.utils.page;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import lombok.Data;

/**
 * 分页PO-II（精简版）
 *
 * @author menghuan
 * @date 2025-01-24
 */
@Data
@SuppressWarnings({"rawtypes", "unchecked"})
public class PageInfoII<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int pageNum;

    private int pageSize;

    private long total;

    // 总页数
    private int pages;

    private List<T> list;

    public PageInfoII() {}

    public static <T> PageInfo<T> empty() {
        return new PageInfo<>(Collections.emptyList(), 1);
    }

    /**
     * 包装Page对象
     *
     * @param list
     */
    public PageInfoII(List<T> list) {
        this(list, 1);
    }

    /**
     * 包装Page对象
     *
     * @param list page结果
     * @param navigatePages 页码数量
     */
    public PageInfoII(List<T> list, int navigatePages) {
        if (list instanceof Page) {
            Page page = (Page)list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.pages = page.getPages();
            this.list = page;
            this.total = page.getTotal();
        } else if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();
            this.pages = this.pageSize > 0 ? 1 : 0;
            this.list = list;
            this.total = list.size();
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }

}
