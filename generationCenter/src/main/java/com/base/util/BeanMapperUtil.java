package org.jeecg.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import com.alibaba.fastjson.JSONObject;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/**
 * Description: Bean属性copy工具类，spring自带的工具类存在性能问题，不考虑，同时apache的工具类存在安全问题，故考虑使用dozer
 *
 * @author: menghuan
 * @date: 2025/1/09 14:41
 */
public class BeanMapperUtil {

    private static Mapper MAPPER = DozerBeanMapperBuilder.buildDefault();

    /**
     * Description: bean copy
     *
     * @param source
     * @param destinationClass
     * @return T
     * @throws
     * @author CatEyes
     * @date 2023/3/29 14:43
     **/
    public static <T> T map(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        }
        return MAPPER.map(source, destinationClass);
    }

    /**
     * Description: bean copy
     *
     * @param source
     * @param destination
     * @return
     * @throws
     * @author CatEyes
     * @date 2023/3/29 14:44
     **/
    public static void map(Object source, Object destination) {
        MAPPER.map(source, destination);
    }

    /**
     * Description: collection copy
     *
     * @param sourceList
     * @param destinationClass
     * @return List<T>
     * @throws
     * @author CatEyes
     * @date 2023/3/29 14:44
     **/
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            destinationList.add(MAPPER.map(sourceObject, destinationClass));
        }
        return destinationList;
    }

    public static <T> void toJson(JSONObject json, T t) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(t);
        combineJson(json, jsonObject);
    }

    public static void combineJson(JSONObject json1, JSONObject json2) {
        if (Objects.isNull(json1) || Objects.isNull(json2)) {
            return;
        }
        json2.forEach((k, v) -> {
            json1.put(k, v);
        });
    }
}
