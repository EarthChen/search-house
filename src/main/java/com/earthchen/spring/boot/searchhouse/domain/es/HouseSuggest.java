package com.earthchen.spring.boot.searchhouse.domain.es;

import lombok.Data;

/**
 * @author: EarthChen
 * @date: 2018/03/18
 */
@Data
public class HouseSuggest {

    private String input;

    /**
     * 默认权重
     */
    private int weight = 10;
}
