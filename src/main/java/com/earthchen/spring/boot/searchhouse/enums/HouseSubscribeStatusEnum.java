package com.earthchen.spring.boot.searchhouse.enums;

/**
 * 预约状态
 *
 * @author: EarthChen
 * @date: 2018/04/02
 */
public enum HouseSubscribeStatusEnum {

    NO_SUBSCRIBE(0), // 未预约
    IN_ORDER_LIST(1), // 已加入待看清单
    IN_ORDER_TIME(2), // 已经预约看房时间
    FINISH(3); // 已完成预约

    private int value;

    HouseSubscribeStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static HouseSubscribeStatusEnum of(int value) {
        for (HouseSubscribeStatusEnum status : HouseSubscribeStatusEnum.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return HouseSubscribeStatusEnum.NO_SUBSCRIBE;
    }
}
