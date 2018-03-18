package com.earthchen.spring.boot.searchhouse.config.es;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: EarthChen
 * @date: 2018/03/18
 */
@Data
@Component
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticSearchProperties {

    private String esHost = "127.0.0.1";

    private int esPort = 9300;

    private String esClusterName;
}
