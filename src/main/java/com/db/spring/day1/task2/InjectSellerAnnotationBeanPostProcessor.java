package com.db.spring.day1.task2;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.*;

public class InjectSellerAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Getter
    private static Queue<Seller> sellerQueue;

    static {
        sellerQueue = new LinkedList<>(SellerGenerator.getSellersList());
    }

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(InjectSeller.class)) {
                declaredField.setAccessible(true);
                declaredField.set(bean, getSeller());
            }
        }
        return bean;
    }

    private static Seller getSeller() {
        return sellerQueue.poll();
    }

}
