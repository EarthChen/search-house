package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.SupportAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 房源信息dao
 *
 * @author: EarthChen
 * @date: 2018/03/15
 */
public interface SupportAddressDao extends JpaRepository<SupportAddress, Long> {

    /**
     * 获取所有对应行政级别的信息
     *
     * @return
     */
    List<SupportAddress> findAllByLevel(String level);

    /**
     * 根据城市名和行政级别查找
     *
     * @param enName
     * @param level
     * @return
     */
    SupportAddress findByEnNameAndLevel(String enName, String level);

    /**
     * 根据城市名和属于的城市
     *
     * @param enName
     * @param belongTo
     * @return
     */
    SupportAddress findByEnNameAndBelongTo(String enName, String belongTo);


    /**
     * 根据行政等级和属于查询房源列表
     *
     * @param level
     * @param belongTo
     * @return
     */
    List<SupportAddress> findAllByLevelAndBelongTo(String level, String belongTo);
}
