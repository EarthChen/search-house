package com.earthchen.spring.boot.searchhouse.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 房屋标签
 *
 * @author: EarthChen
 * @date: 2018/03/16
 */
@Entity
@Data
public class HouseTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_id")
    private Long houseId;

    private String name;

    public HouseTag() {
    }

    public HouseTag(Long houseId, String name) {
        this.houseId = houseId;
        this.name = name;
    }
}
