package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.HouseDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author: EarthChen
 * @date: 2018/03/16
 */
public interface HouseDetailDao extends CrudRepository<HouseDetail, Long> {

    HouseDetail findByHouseId(Long houseId);

    List<HouseDetail> findAllByHouseIdIn(List<Long> houseIds);
}
