package com.helper.util;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 查询参数
 */
public class Query extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    //
    private int offset;
    // 每页条数
    private int limit;

    public Query(Object o) {
        Map<String, Object> params = ClassUtils.entityToMap(o);
        this.putAll(params);
        if (params != null && !params.isEmpty() && params.get("offset") != null && params.get("limit") != null
                && StringUtil.isNotBlank(String.valueOf(params.get("offset")))
                && StringUtil.isNotBlank(String.valueOf(params.get("limit")))) {
            // 分页参数
            this.offset = Integer.parseInt(params.get("offset").toString());
            this.limit = Integer.parseInt(params.get("limit").toString());
            this.put("offset", offset);
            this.put("page", offset / limit + 1);
            this.put("limit", limit);
        }
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.put("offset", offset);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
