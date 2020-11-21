package com.joolun.cloud.mall.common.util;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Wong
 * @ClassName: KeyUtil
 * @Date: 2020/11/12 11:38
 * @Description:
 * @Version: V1.0
 **/
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface  ExcelField {

	//导出字段在excel中的名字
	String title();

}
