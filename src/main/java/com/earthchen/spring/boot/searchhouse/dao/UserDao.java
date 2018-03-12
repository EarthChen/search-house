package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user dao接口
 *
 * @author: EarthChen
 * @date: 2018/03/12
 */
public interface UserDao extends JpaRepository<User, Long> {
}
