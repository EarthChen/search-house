package com.earthchen.spring.boot.searchhouse.web.form;

import lombok.Data;

/**
 * @author: EarthChen
 * @date: 2018/03/27
 */
@Data
public class MapSearchForm {

    private String cityEnName;

    /**
     * 地图缩放级别
     */
    private int level = 12;
    private String orderBy = "lastUpdateTime";
    private String orderDirection = "desc";
    /**
     * 左上角
     */
    private Double leftLongitude;
    private Double leftLatitude;

    /**
     * 右下角
     */
    private Double rightLongitude;
    private Double rightLatitude;

    private int start = 0;
    private int size = 5;

    public int getSize() {
        return size > 100 ? 100 : size;
    }

    public int getStart() {
        return start < 0 ? 0 : start;
    }
}
