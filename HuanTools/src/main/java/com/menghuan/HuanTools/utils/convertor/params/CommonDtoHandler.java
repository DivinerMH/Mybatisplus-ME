package com.menghuan.HuanTools.utils.convertor.params;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

import com.menghuan.HuanTools.exception.ServerException;
import com.menghuan.HuanTools.utils.convertor.params.depend.LoginUser;
import com.menghuan.HuanTools.utils.convertor.params.depend.LoginUtil;

/**
 * @Author: menghuan
 * @Date: 2025-05-14 10:26
 */
public class CommonDtoHandler {

    // 字段映射配置（可通过配置文件扩展）
    private static final Map<String, Function<LoginUser, Object>> USER_FIELD_MAPPING = new HashMap<>();

    /**
     * 字段映射配置 MAP 过滤：MybatisInterceptor 在新增时，已自动回填
     */
    static {
        // USER_FIELD_MAPPING.put("orgCode", LoginUser::getOrgCode);
        USER_FIELD_MAPPING.put("applicant", LoginUser::getRealname);
        USER_FIELD_MAPPING.put("applicantDeptId", LoginUser::getOrgCode);
        // 内部原因导致错位取值
        // USER_FIELD_MAPPING.put("entityCode", LoginUser::getEntityStore);
        USER_FIELD_MAPPING.put("entityName", LoginUser::getEntityName);
        USER_FIELD_MAPPING.put("applyTime", user -> new Date());
    }

    /**
     * 通用字段处理方法 （策略） 字段值为 null 覆盖 字段值为空字符串 ("") 覆盖 字段值为 0 (int) 覆盖（如果配置为数值类型） 字段值为 false 覆盖 字段值为自定义默认值 保留
     * 
     * @param dto 任意DTO对象
     * @param currentUser 当前登录用户
     */
    public static <T> void handleCommonFields(T dto, LoginUser currentUser) {
        if (currentUser == null) {
            return;
        }
        Class<?> clazz = dto.getClass();
        USER_FIELD_MAPPING.forEach((fieldName, valueSupplier) -> {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                Object currentValue = field.get(dto);
                Object defaultValue = valueSupplier.apply(currentUser);

                if (shouldSetValue(field, currentValue)) {
                    field.set(dto, defaultValue);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // 忽略不存在字段的异常
            }
        });
    }

    /**
     * 判断是否应该为某个字段设置默认值
     * 
     * @param field 字段
     * @param currentValue 当前值
     * @return
     */
    private static boolean shouldSetValue(Field field, Object currentValue) {
        // 获取字段的 Class 类型
        Class<?> type = field.getType();
        // 判断字段类型是否为 CharSequence 及其子类（如String）
        if (CharSequence.class.isAssignableFrom(type)) {
            return StringUtils.isBlank((CharSequence)currentValue);
        }
        // 非字符串类型：仅检查是否为 null
        return currentValue == null;
    }

    /**
     * 带登录校验的增强处理
     */
    public static <T> void handleWithAuthCheck(T dto) {
        LoginUser currentUser = LoginUtil.getCurrentUser();
        if (currentUser == null) {
            throw new ServerException("REQUIRE_LOGIN 需要登录后操作");
        }
        handleCommonFields(dto, currentUser);
    }

}
