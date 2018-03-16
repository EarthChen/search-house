package com.earthchen.spring.boot.searchhouse.service.house;

import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import com.earthchen.spring.boot.searchhouse.web.dto.HouseDTO;
import com.earthchen.spring.boot.searchhouse.web.form.HouseForm;


/**
 * house服务
 *
 * @author: EarthChen
 * @date: 2018/03/16
 */
public interface IHouseService {

    /**
     * 新增
     *
     * @param houseForm
     * @return
     */
    ServiceResult<HouseDTO> save(HouseForm houseForm);









}
