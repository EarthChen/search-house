package com.earthchen.spring.boot.searchhouse.enums;

import lombok.Getter;

/**
 * 房源状态枚举
 *
 * @author: EarthChen
 * @date: 2018/03/17
 */
@Getter
public enum HouseStatusEnum {

    /**
     * 未审核
     */
    NOT_AUDITED(0),

    /**
     * 审核通过
     */
    PASSES(1),

    /**
     * 已出租
     */
    RENTED(2),

    /**
     * 逻辑删除
     */
    DELETED(3);

    private int value;

    HouseStatusEnum(int value) {
        this.value = value;
    }
}
