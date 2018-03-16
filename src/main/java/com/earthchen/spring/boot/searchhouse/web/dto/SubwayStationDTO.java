package com.earthchen.spring.boot.searchhouse.web.dto;

import lombok.Data;

/**
 * @author: EarthChen
 * @date: 2018/03/16
 */
@Data
public class SubwayStationDTO {
    private Long id;
    private Long subwayId;
    private String name;
}
