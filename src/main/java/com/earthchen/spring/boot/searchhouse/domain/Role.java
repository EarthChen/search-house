package com.earthchen.spring.boot.searchhouse.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 角色实体
 *
 * @author: EarthChen
 * @date: 2018/03/13
 */
@Data
@Entity
public class Role {

    /**
     * 角色id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * userId
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 角色名
     */
    private String name;


}

