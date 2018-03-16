package com.earthchen.spring.boot.searchhouse.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: EarthChen
 * @date: 2018/03/15
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    /**
     * Bean Util
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
