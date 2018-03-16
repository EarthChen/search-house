package com.earthchen.spring.boot.searchhouse.web.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: EarthChen
 * @date: 2018/03/15
 */
@Data
public class HouseDTO implements Serializable {

    private static final long serialVersionUID = 8918735582286008182L;

    private Long id;

    private String title;

    private Integer price;

    private Integer area;

    private Integer direction;

    private Integer room;

    private Integer parlour;

    private Integer bathroom;

    private Integer floor;

    private Long adminId;

    private String district;

    private Integer totalFloor;

    private Integer watchTimes;

    private Integer buildYear;

    private Integer status;

    private Date createTime;

    private Date lastUpdateTime;

    private String cityEnName;

    private String regionEnName;

    private String street;

    private String cover;

    private Integer distanceToSubway;

    private HouseDetailDTO houseDetail;

    private List<String> tags;

    private List<HousePictureDTO> pictures;

    private Integer subscribeStatus;
}
