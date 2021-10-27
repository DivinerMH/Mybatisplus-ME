package com.hanchan.reflect;

import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 封装一个共用的数结构组装工具
 *
 * @author kiki
 * @ClassName: TreeUtil
 * @date 2019年8月6日
 * @version: V1.0
 */
public class TreeUtil<T> {

    /**
     * tree 组装树结构
     *
     * @param list        元数据
     * @param parentId    父节点的id值
     * @param t           父节点数据对象(也是通过这个得知实体Type)
     * @param parentField T中的父节点属性名
     * @param idField     T中的关联节点属性名
     * @param listField   存放集合数据的内容
     * @throws Exception  参数 void 返回类型
     */
    public void tree(List<T> list,
                     Object parentId,
                     T t,
                     String parentField,
                     String idField,
                     String listField) throws Exception {
        List<T> resultList = new ArrayList<>();
        for (T item : list) {
            // Object pid = t.getClass().getMethod("getParentId").invoke(item);
            Field f = t.getClass().getDeclaredField(parentField);
            // setAccessible 实体中的属性是用private定义的，需要设置setAccessible 为true，才可以访问到对象
            f.setAccessible(true);
            // 获取属性值
            Object pid = f.get(item);
            System.out.println(pid);

            if (Objects.equals(parentId, pid)) {
                resultList.add(item);
            }
        }
        if (CollectionUtils.isNotEmpty(resultList)) {
            for (T item : resultList) {
                Field f = t.getClass().getDeclaredField(idField);
                f.setAccessible(true);
                Object id = f.get(item);
                tree(list, id, item, parentField, idField, listField);
            }
        }
        // 给属性设置值
        Field f = t.getClass().getDeclaredField(listField);
        f.setAccessible(true);
        f.set(t, resultList);
    }

}

