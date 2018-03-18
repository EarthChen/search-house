package com.earthchen.spring.boot.searchhouse.web.dto;

import lombok.Data;

/**
 * @author: EarthChen
 * @date: 2018/03/18
 */
@Data
public class UserDTO {

    private Long id;
    private String name;
    private String avatar;
    private String phoneNumber;
    private String lastLoginTime;
}
