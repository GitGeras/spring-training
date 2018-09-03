package com.db.spring;

import com.db.spring.day3.custom_scope.TwoSecondsBean;
import com.db.spring.day3.custom_scope.TwoSecondsBeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@PropertySource("classpath:props.properties")
@Configuration
@ComponentScans({
//        @ComponentScan(basePackages = "com.db.spring.day1.task1"),
        @ComponentScan(basePackages = "com.db.spring.day3")})
@EnableAspectJAutoProxy
@EnableScheduling
@EnableRetry
public class DefaultConfig {

    @Bean
    public ConversionService conversionService() {
        return new DefaultConversionService();
    }

    @Scope(scopeName = "twoSeconds", proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Bean
    public TwoSecondsBean foo() {
        return new TwoSecondsBean("foo");
    }

    @Scope(scopeName = "twoSeconds")
    @Bean
    public TwoSecondsBean bar() {
        return new TwoSecondsBean("bar");
    }
}
