package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.House;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author: EarthChen
 * @date: 2018/03/16
 */
public interface HouseDao extends PagingAndSortingRepository<House, Long>, JpaSpecificationExecutor<House> {

    /**
     * 根据id和封面更新封面
     *
     * @param id
     * @param cover
     */
    @Modifying
    @Query("update House as house set house.cover = :cover where house.id = :id")
    void updateCover(@Param(value = "id") Long id, @Param(value = "cover") String cover);

    @Modifying
    @Query("update House as house set house.status = :status where house.id = :id")
    void updateStatus(@Param(value = "id") Long id, @Param(value = "status") int status);

    @Modifying
    @Query("update House as house set house.watchTimes = house.watchTimes + 1 where house.id = :id")
    void updateWatchTimes(@Param(value = "id") Long houseId);
}
