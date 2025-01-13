package com.example.OCR.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: menghuan
 * @Date: 2025/1/6 14:50
 */
@Data
@Component
@ConfigurationProperties(prefix = "ocr")
public class AccessConfig {

    private String accessKey;
    private String accessKeySecret;

}
