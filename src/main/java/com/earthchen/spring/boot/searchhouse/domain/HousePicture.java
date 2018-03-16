package com.earthchen.spring.boot.searchhouse.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 房间图片实体
 *
 * @author: EarthChen
 * @date: 2018/03/16
 */
@Data
@Entity
public class HousePicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_id")
    private Long houseId;

    private String path;

    @Column(name = "cdn_prefix")
    private String cdnPrefix;

    private int width;

    private int height;

    private String location;
}
