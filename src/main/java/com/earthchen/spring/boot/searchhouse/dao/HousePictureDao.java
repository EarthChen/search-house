package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.HousePicture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author: EarthChen
 * @date: 2018/03/16
 */
public interface HousePictureDao extends CrudRepository<HousePicture, Long> {

    List<HousePicture> findAllByHouseId(Long id);
}

