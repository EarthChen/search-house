package com.earthchen.spring.boot.searchhouse.service.search;

/**
 * 检索接口
 *
 * @author: EarthChen
 * @date: 2018/03/17
 */
public interface ISearchService {

    /**
     * 索引目标房源
     *
     * @param houseId
     */
    void index(Long houseId);
}
