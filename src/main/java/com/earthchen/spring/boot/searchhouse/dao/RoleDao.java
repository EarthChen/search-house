package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 角色dao
 *
 * @author: EarthChen
 * @date: 2018/03/13
 */
public interface RoleDao extends JpaRepository<Role, Long> {

    /**
     * 根据用户id查询角色列表
     *
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(Long userId);
}
