package com.earthchen.spring.boot.searchhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 *
 * @author: EarthChen
 * @date: 2018/03/12
 */
@SpringBootApplication
@EnableTransactionManagement
public class SearchHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchHouseApplication.class, args);
    }
}
