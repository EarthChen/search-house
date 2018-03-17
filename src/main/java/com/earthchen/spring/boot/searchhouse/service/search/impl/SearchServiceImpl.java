package com.earthchen.spring.boot.searchhouse.service.search.impl;

import com.earthchen.spring.boot.searchhouse.service.search.ISearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: EarthChen
 * @date: 2018/03/17
 */
@Service
@Slf4j
public class SearchServiceImpl implements ISearchService {


    @Override
    public void index(Long houseId) {
        this.index(houseId, 0);
    }

    @Override
    public void remove(Long houseId) {

    }

    private void index(Long houseId, int retry) {

    }
}