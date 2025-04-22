package com.menghuan.async;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: menghuan
 * @Date: 2021/11/18 14:47
 */
@Component
public class AsyncMethod {

    /**
     * 加入@Lazy注解，再添加一层代理，这里将注入代理对象的代理对象
     */
    @Lazy
    @Resource
    private AsyncMethod asyncMethod;

    @Async("taskExecutor")
    public void log() {
        System.out.println("-----log：" + Thread.currentThread().getName());
    }

    @Async("threadPoolTaskExecutor1")
    public void log2() {
        System.out.println("-----log2：" + Thread.currentThread().getName());
        // 期望通过引入的代理对象调用log3()方法，这样就能保证同一个类中的AOP增强生效
        asyncMethod.log3();
    }

    @Async("threadPoolTaskExecutor2")
    public void log3() {
        System.out.println("-----log3：" + Thread.currentThread().getName());
    }

}
