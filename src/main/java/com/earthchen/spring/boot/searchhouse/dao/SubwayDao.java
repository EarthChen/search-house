package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.Subway;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 地铁dao
 *
 * @author: EarthChen
 * @date: 2018/03/16
 */
public interface SubwayDao extends CrudRepository<Subway, Long> {

    /**
     * 根据城市名查找所有地铁列表
     *
     * @param cityEnName
     * @return
     */
    List<Subway> findAllByCityEnName(String cityEnName);
}
