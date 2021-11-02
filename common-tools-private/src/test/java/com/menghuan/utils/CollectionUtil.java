package com.menghuan.utils;

import java.util.Collection;

/**
 * @Avoid 反复地编写类似“if (tasks != null && tasks.size() > 0)”或者“if (name != null && (!name.isEmpty()))”的代码
 * @Author: menghuan
 * @Date: 2021/6/25 16:08
 */
public class CollectionUtil {

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

}
