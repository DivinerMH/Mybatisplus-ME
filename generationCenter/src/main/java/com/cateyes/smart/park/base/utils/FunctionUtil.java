package com.cateyes.smart.park.base.utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Maps;

/**
 * Description: TODO
 *
 * @author: CatEyes
 * @date: 2023/6/25 15:58
 */
public final class FunctionUtil {

    public static <T, M, N> Map<M, N> collectionToMap(List<T> list, Function<T, M> key, Function<T, N> item) {
        if (CollectionUtils.isEmpty(list)) {
            return Maps.newHashMap();
        }
        return Optional.ofNullable(list.stream().collect(Collectors.toMap(t -> key.apply(t), t -> item.apply(t))))
            .orElse(Maps.newHashMap());
    }

    public static <T, M> Map<M, List<T>> groupCollectionToMap(List<T> list, Function<T, M> key) {
        if (CollectionUtils.isEmpty(list)) {
            return Maps.newHashMap();
        }
        return Optional.ofNullable(list.stream().collect(Collectors.groupingBy(t -> key.apply(t))))
            .orElse(Maps.newHashMap());
    }

    public static <T, K> List<T> getDataWithGroup(List<T> list, Function<? super T, ? extends K> classifier,
        Comparator<? super T> comparator) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        Map<K, List<T>> map = list.stream().collect(Collectors.groupingBy(classifier));
        map.values().stream().forEach(l -> Collections.sort(l, comparator));
        return map.values().stream().flatMap(l -> Stream.of(l.stream().findFirst().get())).collect(Collectors.toList());
    }
}
