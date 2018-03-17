package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.HouseSubscribe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: EarthChen
 * @date: 2018/03/17
 */
public interface HouseSubscribeDao extends JpaRepository<HouseSubscribe, Long> {

    /**
     * 根据houseid和登录用户id查询预约看房信息
     *
     * @param houseId
     * @param loginUserId
     * @return
     */
    HouseSubscribe findByHouseIdAndUserId(Long houseId, Long loginUserId);
}
