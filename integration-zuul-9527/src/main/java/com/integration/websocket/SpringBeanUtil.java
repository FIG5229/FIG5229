package com.integration.websocket;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringBeanUtil {

	public static <T> T registerBean(ConfigurableApplicationContext applicationContext, String name, Class<T> clazz,
			Object... args) {

		if (applicationContext.containsBean(name)) {
			Object bean = applicationContext.getBean(name);
			if (bean.getClass().isAssignableFrom(clazz)) {
				return (T) bean;
			} else {
				throw new RuntimeException("BeanName 重复 " + name);
			}
		}

		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
		for (Object arg : args) {
			beanDefinitionBuilder.addConstructorArgValue(arg);
		}
		BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();

		BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) applicationContext.getBeanFactory();
		beanFactory.registerBeanDefinition(name, beanDefinition);
		return applicationContext.getBean(name, clazz);
	}

	public static void removeBean(ConfigurableApplicationContext applicationContext, Class cls) {
		String name = cls.getSimpleName();
		name = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toLowerCase());
		removeBean(applicationContext, name);
	}

	public static void removeBean(ConfigurableApplicationContext applicationContext, String beanName) {
		BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) applicationContext.getBeanFactory();
		beanFactory.removeBeanDefinition(beanName);
	}
}