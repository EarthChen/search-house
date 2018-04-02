package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.HouseSubscribe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    /**
     * 根据用户id和状态分页查询
     *
     * @param userId
     * @param status
     * @param pageable
     * @return
     */
    Page<HouseSubscribe> findAllByAdminIdAndStatus(Long userId, int status, Pageable pageable);

    /**
     * 根据房屋id和管理员id查询预约信息
     *
     * @param houseId
     * @param adminId
     * @return
     */
    HouseSubscribe findByHouseIdAndAdminId(Long houseId, Long adminId);

    /**
     * 根据id更新房源状态
     *
     * @param id
     * @param status
     */
    @Modifying
    @Query("update HouseSubscribe as subscribe set subscribe.status = :status where subscribe.id = :id")
    void updateStatus(@Param(value = "id") Long id, @Param(value = "status") int status);

    /**
     * 根据用户id和房源状态分页查询预约信息
     *
     * @param userId
     * @param status
     * @param pageable
     * @return
     */
    Page<HouseSubscribe> findAllByUserIdAndStatus(Long userId, int status, Pageable pageable);
}
