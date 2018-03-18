package com.earthchen.spring.boot.searchhouse.service.search.impl;

import com.earthchen.spring.boot.searchhouse.ApplicationTests;
import com.earthchen.spring.boot.searchhouse.service.search.ISearchService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: EarthChen
 * @date: 2018/03/18
 */
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
}