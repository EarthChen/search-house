package com.earthchen.spring.boot.searchhouse.domain.es;

import lombok.Data;

/**
 * 根据用户输入的参数自动补全
 *
 * @author: EarthChen
 * @date: 2018/03/18
 */
@Data
public class HouseSuggest {

    /**
     * 用户输入的内容
     */
    private String input;

    /**
     * 默认权重
     */
    private int weight = 10;
}
