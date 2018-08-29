package com.db.spring.day1.task1;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    private static final int getRandomInt(int min, int max) {
        return new Random().nextInt(max - min) + min + 1;
    }

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = declaredField.getAnnotation(InjectRandomInt.class);
                declaredField.setAccessible(true);
                declaredField.setInt(bean, getRandomInt(annotation.min(), annotation.max()));
            }
        }
        return bean;
    }
}
