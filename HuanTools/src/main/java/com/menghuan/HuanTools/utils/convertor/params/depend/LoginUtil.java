package com.menghuan.HuanTools.utils.convertor.params.depend;

import org.apache.shiro.SecurityUtils;

/**
 * @author zhouTengYu
 * @date 2025/1/3
 * @description TODO
 */
public class LoginUtil {

    /**
     * 东风卓联汽车服务有限公司id
     */
    private static String DFZL_ID = "101446";

    public static LoginUser getCurrentUser() {
        if (SecurityUtils.getSubject().getPrincipal() != null) {
            LoginUser loginUser = (LoginUser)SecurityUtils.getSubject().getPrincipal();
            return loginUser;
        }
        return null;
    }

    public static String getLoginStore() {
        if (getCurrentUser() != null) {
            String entityStore = getCurrentUser().getEntityStore();
            if (DFZL_ID.equals(entityStore)) {
                return null;
            } else {
                return entityStore;
            }
        }
        return "";
    }

    public static String getLoginStoreName() {
        if (getCurrentUser() != null) {
            return getCurrentUser().getEntityName();
        }
        return "";
    }

    public static String getUsername() {
        if (getCurrentUser() != null) {
            return getCurrentUser().getUsername();
        }
        return "";
    }

    public static String getUserRealName() {
        if (getCurrentUser() != null) {
            return getCurrentUser().getRealname();
        }
        return "";
    }

}
