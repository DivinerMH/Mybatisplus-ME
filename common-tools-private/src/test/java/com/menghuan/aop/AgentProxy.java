package com.menghuan.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 1、引入依赖
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-aop</artifactId>
 *         </dependency>
 * 2、使用切面注解@Aspect定义一个切面
 *         1、切面：定义当前类是切面类，需要给每一个满足切面条件的类生成不同的代理对象。
 *         2、通知：通知就是定义代理对象的代码要在什么时候生效。
 * @Author: menghuan
 * @Date: 2021/6/24 14:20
 */
@Component
@Aspect // 定义切面
public class AgentProxy {

    // 声明前置通知
    // 切点表达式：可以指定方法，指定包，指定方法可见性等
    @Before("execution(void com.menghuan.proxyPattern.StaticProxyPerson.skill())")
    public void doSkill(){
        System.out.println("我是经纪人，能接代言，接戏，管理粉丝");
    }

}
