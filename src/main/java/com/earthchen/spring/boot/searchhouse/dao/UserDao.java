package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * user dao接口
 *
 * @author: EarthChen
 * @date: 2018/03/12
 */
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 根据名字查找用户
     *
     * @param userName
     * @return
     */
    User findByName(String userName);

    /**
     * 根据电话号码查询用户
     *
     * @param telephone
     * @return
     */
    User findUserByPhoneNumber(String telephone);


    /**
     * 根据用户id修改username
     *
     * @param id
     * @param name
     */
    @Modifying
    @Query("update User as user set user.name = :name where id = :id")
    void updateUsername(@Param(value = "id") Long id, @Param(value = "name") String name);

    /**
     * 根据用户id修改email
     *
     * @param id
     * @param email
     */
    @Modifying
    @Query("update User as user set user.email = :email where id = :id")
    void updateEmail(@Param(value = "id") Long id, @Param(value = "email") String email);

    /**
     * 根据用户id修改密码
     *
     * @param id
     * @param password
     */
    @Modifying
    @Query("update User as user set user.password = :password where id = :id")
    void updatePassword(@Param(value = "id") Long id, @Param(value = "password") String password);
}
