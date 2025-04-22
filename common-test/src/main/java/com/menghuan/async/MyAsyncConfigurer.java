package com.menghuan.async;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @Author: menghuan
 * @Date: 2021/11/18 15:34
 */
@Component
public class MyAsyncConfigurer implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(5);
        // 配置最大线程数
        executor.setMaxPoolSize(10);
        // 配置队列大小
        executor.setQueueCapacity(800);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("myAsyncConfigurer-");
        // rejection-policy：拒绝策略，由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 注意，这里配置的ThreadPoolTaskExecutor不会被Spring管理，因此需要手动initialize初始化
        executor.initialize();
        return executor;
    }

}
