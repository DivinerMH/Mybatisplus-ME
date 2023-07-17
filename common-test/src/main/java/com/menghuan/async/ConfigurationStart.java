package com.menghuan.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: menghuan
 * @Date: 2021/11/18 14:51
 */
@Configuration
@EnableAsync
@ComponentScan
public class ConfigurationStart {

    private final LongAdder longAdder = new LongAdder();

    /**
     * 这里仅仅是配置了一个JDK的ThreadPoolExecutor
     */
    @Bean
    public Executor taskExecutor() {

        return new ThreadPoolExecutor(3, 5, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> {
            longAdder.increment();
            //线程命名
            return new Thread(r, "JDK线程-" + longAdder.longValue());
        });
    }

    /**
     * 这里仅仅是配置了一个Spring的ThreadPoolTaskExecutor
     */
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor1() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(10);
        //配置队列大小
        executor.setQueueCapacity(800);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("threadPoolTaskExecutor1-");
        // rejection-policy：拒绝策略，由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }


    /**
     * 这里仅仅是配置了一个Spring的ThreadPoolTaskExecutor
     */
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(10);
        //配置队列大小
        executor.setQueueCapacity(800);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("threadPoolTaskExecutor2-");
        // rejection-policy：拒绝策略，由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}

