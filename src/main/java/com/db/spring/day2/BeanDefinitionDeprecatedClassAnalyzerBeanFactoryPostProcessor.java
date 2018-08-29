package com.db.spring.day2;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

public class BeanDefinitionDeprecatedClassAnalyzerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            Class<?> type = beanFactory.getType(definitionName);
            DeprecatedClass clazzAnnotation = type.getAnnotation(DeprecatedClass.class);
            if (clazzAnnotation != null) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(definitionName);
                beanDefinition.setBeanClassName(clazzAnnotation.value().getName());
            }
        }
    }
}
