package com.menghuan.aop;

import java.lang.annotation.*;

/**
 * @Author: menghuan
 * @Date: 2022/8/24 11:21
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface AgentProxyAnnotation {

}
