package com.earthchen.spring.boot.searchhouse.service.search;

import com.earthchen.spring.boot.searchhouse.service.ServiceMultiResult;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import com.earthchen.spring.boot.searchhouse.web.form.RentSearchForm;

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

    /**
     * 删除索引
     *
     * @param houseId
     */
    void remove(Long houseId);

    ServiceMultiResult<Long> query(RentSearchForm rentSearch);

    ServiceResult<Long> aggregateDistrictHouse(String enName, String enName1, String district);
}
