package com.menghuan.redisplus.seckill;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: menghuan
 * @Date: 2022/7/1 10:24
 */
@Slf4j
public class LogLevelTest {

    @Test
    public void testLog(){
        String logLevel = JudgeCurrentLevel();
        System.out.println(logLevel);

        log.debug("debug");
        log.info("info");
        log.error("error");
        log.warn("warn");
    }


    private String JudgeCurrentLevel(){
        if (log.isDebugEnabled()){
            return "当前日志等级：debug";
        }else if (log.isInfoEnabled()){
            return "当前日志等级：info";
        }
        else if (log.isWarnEnabled()){
            return "当前日志等级：warn";
        }
        else if (log.isErrorEnabled()){
            return "当前日志等级：error";
        }
        return log.getName();
    }

}
