package com.earthchen.spring.boot.searchhouse.web.dto;

import lombok.Data;

/**
 * @author: EarthChen
 * @date: 2018/03/15
 */
@Data
public class HouseDetailDTO {

    private String description;

    private String layoutDesc;

    private String traffic;

    private String roundService;

    private int rentWay;

    private Long adminId;

    private String address;

    private Long subwayLineId;

    private Long subwayStationId;

    private String subwayLineName;

    private String subwayStationName;
}
