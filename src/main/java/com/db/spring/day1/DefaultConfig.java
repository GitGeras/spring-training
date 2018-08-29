package com.db.spring.day1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:props.properties")
@Configuration
@ComponentScan
public class DefaultConfig {
}
