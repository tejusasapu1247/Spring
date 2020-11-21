package com.beanfactoryPP;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
@Component
public class MyBeanPP1 implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
System.out.println("......postProcessBeforeInitialization.......");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(".....postProcessAfterInitialization......");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

	
	
	
}
