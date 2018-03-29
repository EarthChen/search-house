package com.earthchen.spring.boot.searchhouse.web.dto;

import lombok.Data;


/**
 * @author: EarthChen
 * @date: 2018/03/27
 */
@Data
public class HouseBucketDTO {

    /**
     * 聚合bucket的key
     */
    private String key;

    /**
     * 聚合结果值
     */
    private long count;

    public HouseBucketDTO(String key, long count) {
        this.key = key;
        this.count = count;
    }
}
