package com.earthchen.spring.boot.searchhouse.service.house.impl;

import com.earthchen.spring.boot.searchhouse.ApplicationTests;
import com.earthchen.spring.boot.searchhouse.domain.es.BaiduMapLocation;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: EarthChen
 * @date: 2018/03/29
 */
public class AddressServiceImplTest extends ApplicationTests {

    @Autowired
    private AddressServiceImpl addressService;

    @Test
    public void getBaiduMapLocation() {
        String city = "北京";
        String address = "北京市昌平区巩华家园1号楼2单元";
        ServiceResult<BaiduMapLocation> serviceResult = addressService.getBaiduMapLocation(city, address);

        assertTrue(serviceResult.isSuccess());

        assertTrue(serviceResult.getResult().getLongitude() > 0);
        assertTrue(serviceResult.getResult().getLatitude() > 0);
    }
}