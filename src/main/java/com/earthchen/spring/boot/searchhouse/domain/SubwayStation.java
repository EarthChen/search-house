package com.earthchen.spring.boot.searchhouse.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 地铁站
 *
 * @author: EarthChen
 * @date: 2018/03/16
 */
@Entity
@Data
public class SubwayStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subway_id")
    private Long subwayId;

    private String name;
}
