package com.earthchen.spring.boot.searchhouse.web.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: EarthChen
 * @date: 2018/03/17
 */
@Data
public class DatatableSearchForm {

    /**
     * Datatables要求回显字段
     */
    private int draw;

    /**
     * Datatables规定分页字段
     */
    private int start;
    private int length;

    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTimeMin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTimeMax;

    /**
     * 城市
     */
    private String city;

    /**
     * 标题
     */
    private String title;

    /**
     * 排序方式
     */
    private String direction;

    /**
     * 根据哪个字段排序
     */
    private String orderBy;
}
