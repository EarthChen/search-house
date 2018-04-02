package com.earthchen.spring.boot.searchhouse.service.user;

import com.earthchen.spring.boot.searchhouse.domain.User;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
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

    /**
     * 根据电话号码查询用户
     *
     * @param telephone
     * @return
     */
    User findUserByTelephone(String telephone);

    /**
     * 根据手机号添加用户
     *
     * @param telephone
     * @return
     */
    User addUserByPhone(String telephone);

    /**
     * 修改指定属性值
     *
     * @param profile
     * @param value
     * @return
     */
    ServiceResult modifyUserProfile(String profile, String value);
}
