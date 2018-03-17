package com.earthchen.spring.boot.searchhouse.web.vo;

import com.earthchen.spring.boot.searchhouse.enums.ResultEnum;
import lombok.Data;

/**
 * Datatables响应结构
 *
 * @author: EarthChen
 * @date: 2018/03/17
 */
@Data
public class ApiDataTableVO extends ResultVO {

    private Integer draw;

    /**
     * 总数
     */
    private Long recordsTotal;

    private Long recordsFiltered;

    public ApiDataTableVO(ResultEnum status) {
        this(status.getCode(), status.getMessage(), null);
    }

    public ApiDataTableVO(int code, String message, Object data) {
        super(code, message, data);
    }
}
