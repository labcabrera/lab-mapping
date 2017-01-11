package org.lab.commons.mapper.config;

import static org.lab.commons.mapper.EnableSpringConversionService.AUTOSCAN;
import static org.lab.commons.mapper.EnableSpringConversionService.CONVERTERS;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.lab.commons.mapper.EnableSpringConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.type.AnnotationMetadata;

import lombok.extern.slf4j.Slf4j;

/**
 * Exposes Spring API {@code ConversionService} using a given collection of
 * converters ({@code org.springframework.core.convert.converter.Converter}).
 * 
 * @see EnableSpringConversionService
 */
@Configuration
@Slf4j
public class SpringConversionServiceConfig extends AbstractConversionServiceConfig implements ImportAware {

	private ConversionServiceFactoryBean factoryBean;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.annotation.ImportAware#setImportMetadata(org.
	 * springframework.core.type.AnnotationMetadata)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setImportMetadata(AnnotationMetadata metadata) {
		log.debug("Reading Spring mapping configuration");
		factoryBean = new ConversionServiceFactoryBean();
		Map<String, Object> data = metadata.getAnnotationAttributes(EnableSpringConversionService.class.getName());
		boolean autoScan = (boolean) data.get(AUTOSCAN);
		if (autoScan) {
			// TODO not working (instanceof dont work with proxy classes)
			Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
			factoryBean.setConverters(converters.entrySet());
		} else {
			Class<? extends Converter<?, ?>>[] clases = (Class<? extends Converter<?, ?>>[]) data.get(CONVERTERS);
			Set<Converter<?, ?>> converters = new HashSet<>();
			for (Class<? extends Converter<?, ?>> converterClass : clases) {
				converters.add(findOrCreateBean(converterClass));
			}
			factoryBean.setConverters(converters);
		}
		factoryBean.afterPropertiesSet();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lab.commons.mapper.config.AbstractConversionServiceConfig#
	 * conversionService()
	 */
	@Bean
	@Override
	public ConversionService conversionService() {
		return factoryBean.getObject();
	}
}
