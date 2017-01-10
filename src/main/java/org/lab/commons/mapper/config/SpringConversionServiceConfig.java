package org.lab.commons.mapper.config;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.lab.commons.mapper.EnableSpringConversionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.type.AnnotationMetadata;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SpringConversionServiceConfig implements ImportAware {

	@Inject
	private ApplicationContext applicationContext;

	private ConversionServiceFactoryBean factoryBean;

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setImportMetadata(AnnotationMetadata metadata) {
		log.debug("Reading Spring mapping configuration");
		factoryBean = new ConversionServiceFactoryBean();
		Map<String, Object> data = metadata.getAnnotationAttributes(EnableSpringConversionService.class.getName());
		boolean autoScan = (boolean) data.get(EnableSpringConversionService.AUTOSCAN);
		if (autoScan) {
			Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
			factoryBean.setConverters(converters.entrySet());
		} else {
			Class<? extends Converter<?, ?>>[] clases = (Class<? extends Converter<?, ?>>[]) data
					.get(EnableSpringConversionService.CONVERTERS);
			Set<Converter<?, ?>> converters = new HashSet<>();
			for (Class<? extends Converter<?, ?>> i : clases) {
				try {
					converters.add(i.newInstance());
				} catch (InstantiationException | IllegalAccessException ex) {
					throw new RuntimeException(ex);
				}
			}
			factoryBean.setConverters(converters);
		}

		factoryBean.afterPropertiesSet();
	}

	@Bean
	public ConversionService conversionService() {
		return factoryBean.getObject();
	}
}
