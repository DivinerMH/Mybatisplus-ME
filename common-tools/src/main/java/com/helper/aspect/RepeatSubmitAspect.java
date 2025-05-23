package com.helper.aspect;

import static com.helper.constant.CacheConstants.SUBMIT_DETAILS;

import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.baomidou.mybatisplus.extension.api.R;
import com.helper.annotation.NoRepeatSubmit;
import com.helper.constant.enums.BusinessEnum;
import com.helper.redis.IRedisService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * 重复提交
 *
 * @author bjx
 * @date 2020-07-23
 */
@Slf4j
@Aspect
// @AllArgsConstructor
@Component
public class RepeatSubmitAspect {

    @Resource
    private IRedisService iRedisService;

    /*@Resource
    private RedisTemplate redisTemplate;*/

    @SneakyThrows
    @Around("@annotation(noRepeatSubmit)")
    public Object around(ProceedingJoinPoint point, NoRepeatSubmit noRepeatSubmit) {
        HttpServletRequest request =
            ((ServletRequestAttributes)Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();

        // 拿到ip地址、请求路径、token
        String path = request.getServletPath();
        String token = request.getHeader(HttpHeaders.AUTHORIZATION).split(" ")[1];
        String key = getKey(token, path);

        // boolean isSuccess = iRedisService.lock(key, noRepeatSubmit.value());
        String lock = iRedisService.tryLock(key, String.valueOf(noRepeatSubmit.value()));
        if (lock != null) {
            // 第一次操作
            log.info("tryLock success, key = [{}]", key);
            // 获取锁成功, 执行进程
            Object proceed = null;
            try {
                proceed = point.proceed();
                log.info("releaseLock success, key = [{}]", key);
                return proceed;
            } finally {
                // 解锁
                iRedisService.unlock(key, lock);
            }
        } else {
            // 获取锁失败判断重复提交
            log.warn("tryLock fail, key = [{}]", key);
            return R.failed(String.valueOf(BusinessEnum.SUBMIT_REPEAT));
        }
    }

    /**
     * 生成key
     *
     * @param token token
     * @param url url
     * @return key
     */
    private String getKey(String token, String url) {
        return SUBMIT_DETAILS + ":" + token + ":" + url;
    }

}
