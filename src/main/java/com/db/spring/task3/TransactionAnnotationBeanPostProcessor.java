package com.db.spring.task3;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class TransactionAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    @SneakyThrows
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class<?> type = beanFactory.getType(beanName);
        /*String originalName = bean.getClass().getName().split("\\$\\$")[0];
        Class<?> type = Class.forName(originalName);*/

        boolean methodNeedsTransaction = Arrays.stream(type.getDeclaredMethods()).anyMatch(method -> method.isAnnotationPresent(Transaction.class));

        if (type.isAnnotationPresent(Transaction.class) || methodNeedsTransaction) {
            if (type.getInterfaces().length == 0) {
                return Enhancer.create(type, (org.springframework.cglib.proxy.InvocationHandler) (o, method, args) -> invoke(bean, type, method, args));
            } else {
                return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> invoke(bean, type, method, args));
            }
        }

        return bean;
    }

    private Object invoke(Object t, Class type, Method method, Object[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (classMethod.isAnnotationPresent(Transaction.class)
                || type.isAnnotationPresent(Transaction.class)) {
            System.out.println("********** transaction for method " + method.getName() + " was started ***********");
            long start = System.nanoTime();
            Object retVal = method.invoke(t, args);
            long end = System.nanoTime();
            System.out.println(end - start);
            System.out.println("********** transaction for method " + method.getName() + " was ended ***********");
            return retVal;
        } else {
            return method.invoke(t, args);
        }
    }
}
