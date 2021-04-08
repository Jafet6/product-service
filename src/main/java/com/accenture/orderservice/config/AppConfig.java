package com.accenture.orderservice.config;

import com.accenture.orderservice.mappers.ProductMapper;
import com.accenture.orderservice.utils.date.DateUTC;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper(new ModelMapper());
    }

    @Bean
    public DateUTC dateUTC() {
        return new DateUTC();
    }
}


