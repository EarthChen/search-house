package com.earthchen.spring.boot.searchhouse.config.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里云短信参数配置
 *
 * @author: EarthChen
 * @date: 2018/04/02
 */
@Component
@Data
@ConfigurationProperties(prefix = "aliyun.sms")
public class SmsProperties {

    private String accessKey;

    private String secretKey;

    private String templateCode;
}
