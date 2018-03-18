package com.earthchen.spring.boot.searchhouse.service.search.impl;

import com.earthchen.spring.boot.searchhouse.service.ServiceMultiResult;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import com.earthchen.spring.boot.searchhouse.service.search.ISearchService;
import com.earthchen.spring.boot.searchhouse.web.form.RentSearchForm;
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

    @Override
    public ServiceMultiResult<Long> query(RentSearchForm rentSearch) {
        return null;
    }

    @Override
    public ServiceResult<Long> aggregateDistrictHouse(String enName, String enName1, String district) {
        return null;
    }

    private void index(Long houseId, int retry) {

    }
}