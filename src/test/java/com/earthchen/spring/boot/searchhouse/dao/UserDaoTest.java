package com.earthchen.spring.boot.searchhouse.dao;

import com.earthchen.spring.boot.searchhouse.ApplicationTests;
import com.earthchen.spring.boot.searchhouse.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: EarthChen
 * @date: 2018/03/12
 */
public class UserDaoTest extends ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindOne() {
        User user = userDao.findOne(1L);
        assertEquals("wali", user.getName());

    }

}