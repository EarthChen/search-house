package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.SubwayStation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 地铁站dao
 *
 * @author: EarthChen
 * @date: 2018/03/16
 */
public interface SubwayStationDao extends CrudRepository<SubwayStation, Long> {

    /**
     * 根据地铁id查询地铁站列表
     *
     * @param subwayId
     * @return
     */
    List<SubwayStation> findAllBySubwayId(Long subwayId);
}

