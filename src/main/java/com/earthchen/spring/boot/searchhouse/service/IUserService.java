package com.earthchen.spring.boot.searchhouse.service;

import com.earthchen.spring.boot.searchhouse.domain.User;

/**
 * @author: EarthChen
 * @date: 2018/03/13
 */
public interface IUserService {

    User findUserByName(String userName);

}
