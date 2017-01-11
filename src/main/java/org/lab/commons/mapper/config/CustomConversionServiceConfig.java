package org.lab.commons.mapper.config;

import static org.lab.commons.mapper.EnableCustomConversionService.SERVICE;

import java.util.Map;

import org.lab.commons.mapper.EnableCustomConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @see EnableCustomConversionService
 */
@Configuration
public class CustomConversionServiceConfig extends AbstractConversionServiceConfig implements ImportAware {

	private ConversionService conversionService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.annotation.ImportAware#setImportMetadata(org.
	 * springframework.core.type.AnnotationMetadata)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void setImportMetadata(AnnotationMetadata metadata) {
		Map<String, Object> data = metadata.getAnnotationAttributes(EnableCustomConversionService.class.getName());
		Class<ConversionService> serviceImplementationClass = (Class<ConversionService>) data.get(SERVICE);
		conversionService = findOrCreateBean(serviceImplementationClass);
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
		return conversionService;
	}
}
