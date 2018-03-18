package com.earthchen.spring.boot.searchhouse.domain.es;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 百度位置信息
 *
 * @author: EarthChen
 * @date: 2018/03/18
 */
@Data
public class BaiduMapLocation {

    /**
     * 经度
     */
    @JsonProperty("lon")
    private double longitude;

    /**
     * 纬度
     */
    @JsonProperty("lat")
    private double latitude;
}
