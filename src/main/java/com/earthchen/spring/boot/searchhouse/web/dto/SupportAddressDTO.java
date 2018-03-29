package com.earthchen.spring.boot.searchhouse.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: EarthChen
 * @date: 2018/03/15
 */
@Data
public class SupportAddressDTO {

    private Long id;
    @JsonProperty(value = "belong_to")
    private String belongTo;

    @JsonProperty(value = "en_name")
    private String enName;

    @JsonProperty(value = "cn_name")
    private String cnName;

    private String level;

    private Double baiduMapLongitude;

    private Double baiduMapLatitude;
}
