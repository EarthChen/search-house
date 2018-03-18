package com.earthchen.spring.boot.searchhouse.service;

import com.earthchen.spring.boot.searchhouse.domain.User;
import com.earthchen.spring.boot.searchhouse.web.dto.UserDTO;

/**
 * @author: EarthChen
 * @date: 2018/03/13
 */
public interface IUserService {

    User findUserByName(String userName);

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    ServiceResult<UserDTO> findById(Long userId);
}
