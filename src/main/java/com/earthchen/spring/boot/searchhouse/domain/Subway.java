package com.earthchen.spring.boot.searchhouse.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 地铁实体
 *
 * @author: EarthChen
 * @date: 2018/03/16
 */
@Data
@Entity
public class Subway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "city_en_name")
    private String cityEnName;
}
