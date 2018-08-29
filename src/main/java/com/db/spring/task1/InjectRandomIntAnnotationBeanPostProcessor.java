package com.db.spring.task1;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

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
