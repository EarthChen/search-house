package com.earthchen.spring.boot.searchhouse.web.controller.house;

import com.earthchen.spring.boot.searchhouse.enums.ResultEnum;
import com.earthchen.spring.boot.searchhouse.service.IUserService;
import com.earthchen.spring.boot.searchhouse.service.ServiceMultiResult;
import com.earthchen.spring.boot.searchhouse.service.house.IAddressService;
import com.earthchen.spring.boot.searchhouse.web.dto.SubwayDTO;
import com.earthchen.spring.boot.searchhouse.web.dto.SubwayStationDTO;
import com.earthchen.spring.boot.searchhouse.web.dto.SupportAddressDTO;
import com.earthchen.spring.boot.searchhouse.web.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author: EarthChen
 * @date: 2018/03/15
 */
@Controller
public class HouseController {

    @Autowired
    private IAddressService addressService;

    /**
     * 获取支持城市列表
     *
     * @return
     */
    @GetMapping("address/support/cities")
    @ResponseBody
    public ResultVO getSupportCities() {
        ServiceMultiResult<SupportAddressDTO> result = addressService.findAllCities();
        if (result.getResultSize() == 0) {
            return ResultVO.ofStatus(ResultEnum.NOT_FOUND);
        }
        return ResultVO.ofSuccess(result.getResult());
    }

    /**
     * 获取对应城市支持区域列表
     *
     * @param cityEnName
     * @return
     */
    @GetMapping("address/support/regions")
    @ResponseBody
    public ResultVO getSupportRegions(@RequestParam(name = "city_name") String cityEnName) {
        ServiceMultiResult addressResult = addressService.findAllRegionsByCityName(cityEnName);
        if (addressResult.getResult() == null || addressResult.getTotal() < 1) {
            return ResultVO.ofStatus(ResultEnum.NOT_FOUND);
        }
        return ResultVO.ofSuccess(addressResult.getResult());
    }

    /**
     * 获取具体城市所支持的地铁线路
     *
     * @param cityEnName
     * @return
     */
    @GetMapping("address/support/subway/line")
    @ResponseBody
    public ResultVO getSupportSubwayLine(@RequestParam(name = "city_name") String cityEnName) {
        List<SubwayDTO> subways = addressService.findAllSubwayByCity(cityEnName);
        if (subways.isEmpty()) {
            return ResultVO.ofStatus(ResultEnum.NOT_FOUND);
        }

        return ResultVO.ofSuccess(subways);
    }

    /**
     * 获取对应地铁线路所支持的地铁站点
     *
     * @param subwayId
     * @return
     */
    @GetMapping("address/support/subway/station")
    @ResponseBody
    public ResultVO getSupportSubwayStation(@RequestParam(name = "subway_id") Long subwayId) {
        List<SubwayStationDTO> stationDTOS = addressService.findAllStationBySubway(subwayId);
        if (stationDTOS.isEmpty()) {
            return ResultVO.ofStatus(ResultEnum.NOT_FOUND);
        }

        return ResultVO.ofSuccess(stationDTOS);
    }


}
