package com.earthchen.spring.boot.searchhouse.web.vo;

import com.earthchen.spring.boot.searchhouse.enums.ResultEnum;
import lombok.Data;

/**
 * 结果api
 *
 * @author: EarthChen
 * @date: 2018/03/12
 */
@Data
public class ResultVO {

    /**
     * 状态吗
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;

    /**
     * 是否还有更多
     */
    private Boolean more;



    public ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public static ResultVO ofMessage(int code, String message) {
        return new ResultVO(code, message, null);
    }

    public static ResultVO ofSuccess(Object data) {
        return new ResultVO(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static ResultVO ofStatus(ResultEnum resultEnum) {
        return new ResultVO(resultEnum.getCode(), resultEnum.getMessage(), null);
    }
}
