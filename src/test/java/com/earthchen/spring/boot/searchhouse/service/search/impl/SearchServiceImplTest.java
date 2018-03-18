package com.earthchen.spring.boot.searchhouse.service.search.impl;

import com.earthchen.spring.boot.searchhouse.ApplicationTests;
import com.earthchen.spring.boot.searchhouse.domain.Role;
import com.earthchen.spring.boot.searchhouse.service.ServiceMultiResult;
import com.earthchen.spring.boot.searchhouse.service.search.ISearchService;
import com.earthchen.spring.boot.searchhouse.web.form.RentSearchForm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: EarthChen
 * @date: 2018/03/18
 */
@Slf4j
public class SearchServiceImplTest extends ApplicationTests {

    @Autowired
    private ISearchService searchService;

    @Test
    public void index() {
        Long targetHouseId = 15L;
        searchService.index(targetHouseId);
    }

    @Test
    public void remove() {
        Long targetHouseId = 15L;
        searchService.remove(targetHouseId);
    }

    @Test
    public void query() {
        RentSearchForm rentSearch = new RentSearchForm();
        rentSearch.setCityEnName("bj");
        rentSearch.setStart(0);
        rentSearch.setSize(10);
        rentSearch.setKeywords("国贸");
        ServiceMultiResult<Long> serviceResult = searchService.query(rentSearch);
        log.info(serviceResult.getResult().toString());
        assertTrue(serviceResult.getTotal() > 0);

    }
}