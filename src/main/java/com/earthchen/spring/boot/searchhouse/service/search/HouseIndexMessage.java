package com.earthchen.spring.boot.searchhouse.service.search;

import lombok.Data;

/**
 * 房屋索引消息
 * <p>
 * kafka传递信息
 *
 * @author: EarthChen
 * @date: 2018/03/18
 */
@Data
public class HouseIndexMessage {

    public static final String INDEX = "index";
    public static final String REMOVE = "remove";

    public static final int MAX_RETRY = 3;

    /**
     * 房屋id
     */
    private Long houseId;

    /**
     * 操作
     */
    private String operation;

    /**
     * 重试
     */
    private int retry = 0;

    /**
     * 默认构造器 防止jackson序列化失败
     */
    public HouseIndexMessage() {
    }

    public HouseIndexMessage(Long houseId, String operation, int retry) {
        this.houseId = houseId;
        this.operation = operation;
        this.retry = retry;
    }

}
