package com.helper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.helper.aspect.RepeatSubmitAspect;
import com.helper.redis.IRedisService;
import com.helper.redis.impl.RedisServiceImpl;

import lombok.AllArgsConstructor;

/**
 * 配置切面
 *
 * @author bjx
 * @date 2020-07-24
 */
@Configuration
@AllArgsConstructor
public class AspectConfig {

    @Order(1)
    @Bean
    public IRedisService iRedisService() {
        return new RedisServiceImpl();
    }

    /**
     * 注入切面
     *
     * @return RepeatSubmitAspect
     */
    @Order(2)
    @Bean
    public RepeatSubmitAspect repeatSubmitAspect() {
        return new RepeatSubmitAspect();
    }
}
