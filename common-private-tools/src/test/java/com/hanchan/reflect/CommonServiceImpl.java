package com.hanchan.reflect;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: menghuan
 * @Date: 2021/7/31 14:10
 */
public class CommonServiceImpl<T> implements CommonService<T> {

    @Resource
    private MyClass myClass;

    @Override
    public void explain(T t) {
        // 通过对象获得Class对象
        Class<?> aClass = t.getClass();
        Field[] fields = aClass.getFields();
        // 获得类中所有的属性
        Field[] declaredField = aClass.getDeclaredFields();
        try{
            // 获取get方法获取属性值 传入属性名称
            PropertyDescriptor nameAttribute = new PropertyDescriptor("name", aClass);
            Method readMethod = nameAttribute.getReadMethod();
            // 这块一定要传入t 而不是 t.getClass().newInstance()
            String invoke = (String) readMethod.invoke(t);

            // 获取属性值
            Field name = t.getClass().getDeclaredField("name");
            name.setAccessible(true);
            // 这块一定要传入t 而不是 t.getClass().newInstance()
            String str = (String) name.get(t);
            System.out.println(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOne(){
        CommonServiceImpl commonService = new CommonServiceImpl();
        MyClass myClass = new MyClass();
        myClass.setName("邻盛");
        commonService.explain(myClass);
    }

}
