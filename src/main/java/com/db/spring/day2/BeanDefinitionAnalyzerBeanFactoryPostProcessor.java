package com.db.spring.day2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

public class BeanDefinitionAnalyzerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] definitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) configurableListableBeanFactory.getBeanDefinition(definitionName);
            String destroyMethodName = beanDefinition.getDestroyMethodName();
            if (destroyMethodName != null && beanDefinition.isPrototype()) {
                throw new IllegalStateException("Не надо так");
            }
        }
    }
}
