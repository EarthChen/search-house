package com.earthchen.spring.boot.searchhouse.service.search;

import com.earthchen.spring.boot.searchhouse.service.ServiceMultiResult;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import com.earthchen.spring.boot.searchhouse.web.dto.HouseBucketDTO;
import com.earthchen.spring.boot.searchhouse.web.form.MapSearchForm;
import com.earthchen.spring.boot.searchhouse.web.form.RentSearchForm;

import java.util.List;

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

    /**
     * 查询房源接口
     *
     * @param rentSearch
     * @return
     */
    ServiceMultiResult<Long> query(RentSearchForm rentSearch);


    /**
     * 聚合特定小区的房间数
     *
     * @param cityEnName
     * @param regionEnName
     * @param district
     * @return
     */
    ServiceResult<Long> aggregateDistrictHouse(String cityEnName, String regionEnName, String district);

    /**
     * 根据前缀获取补全建议关键词
     *
     * @param prefix
     * @return
     */
    ServiceResult<List<String>> suggest(String prefix);

    /**
     * 聚合城市数据
     *
     * @param cityEnName
     * @return
     */
    ServiceMultiResult<HouseBucketDTO> mapAggregate(String cityEnName);

    /**
     * 城市级别查询
     *
     * @param cityEnName
     * @param orderBy
     * @param orderDirection
     * @param start
     * @param size
     * @return
     */
    ServiceMultiResult<Long> mapQuery(String cityEnName,
                                      String orderBy,
                                      String orderDirection,
                                      int start,
                                      int size);

    /**
     * 精确范围数据查询
     *
     * @param mapSearch
     * @return
     */
    ServiceMultiResult<Long> mapQuery(MapSearchForm mapSearch);
}
