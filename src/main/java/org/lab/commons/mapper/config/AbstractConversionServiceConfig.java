package org.lab.commons.mapper.config;

import javax.inject.Inject;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

/**
 * Provides basic functionality to conversion service configurations. All those
 * components must expose {@code ConversionService} bean.
 */
abstract class AbstractConversionServiceConfig {

	@Inject
	protected ApplicationContext applicationContext;

	/**
	 * Exposes ConversionService API.
	 * 
	 * @return
	 */
	@Bean
	public abstract ConversionService conversionService();

	/**
	 * Lookup for a bean of given type. If the bean is not present register it
	 * into the application bean registry.
	 * 
	 * @param requiredType
	 * @return
	 */
	protected <T> T findOrCreateBean(Class<T> requiredType) {
		try {
			return applicationContext.getBean(requiredType);
		} catch (NoSuchBeanDefinitionException ex) {
			return applicationContext.getAutowireCapableBeanFactory().createBean(requiredType);
		}
	}

}
