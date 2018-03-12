package com.earthchen.spring.boot.searchhouse.enums;

import lombok.Getter;

/**
 * 结果响应枚举类
 *
 * @author: EarthChen
 * @date: 2018/03/12
 */
@Getter
public enum ResultEnum {

    /**
     * 成功请求
     */
    SUCCESS(200, "ok"),

    /**
     * 错误请求
     */
    BAD_REQUEST(400, "Bad Request"),

    /**
     * 没有发现资源
     */
    NOT_FOUND(404, "Not Found"),

    /**
     * 服务器错误
     */
    INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),

    /**
     * 无效的参数
     */
    NOT_VALID_PARAM(40005, "Not valid Params"),

    /**
     * 操作不支持
     */
    NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),

    /**
     * 未登录
     */
    NOT_LOGIN(50000, "Not Login");


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
