package com.earthchen.spring.boot.searchhouse.service.user;

import com.earthchen.spring.boot.searchhouse.dao.RoleDao;
import com.earthchen.spring.boot.searchhouse.dao.UserDao;
import com.earthchen.spring.boot.searchhouse.domain.Role;
import com.earthchen.spring.boot.searchhouse.domain.User;
import com.earthchen.spring.boot.searchhouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: EarthChen
 * @date: 2018/03/13
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public User findUserByName(String userName) {
        User user = userDao.findByName(userName);

        if (user == null) {
            return null;
        }

        List<Role> roles = roleDao.findRolesByUserId(user.getId());
        if (roles == null || roles.isEmpty()) {
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        user.setAuthorityList(authorities);
        return user;
    }
}