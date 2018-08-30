package com.db.spring;

import org.springframework.context.annotation.*;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.scheduling.annotation.EnableScheduling;

@PropertySource("classpath:props.properties")
@Configuration
@ComponentScans({
//        @ComponentScan(basePackages = "com.db.spring.day1.task1"),
        @ComponentScan(basePackages = "com.db.spring.day3")})
@EnableAspectJAutoProxy
@EnableScheduling
public class DefaultConfig {

    @Bean
    public ConversionService conversionService() {
        return new DefaultConversionService();
    }
}
