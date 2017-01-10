package org.lab.commons.mapper.config;

import java.util.Map;

import javax.inject.Inject;

import org.lab.commons.mapper.EnableCustomConversionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.type.AnnotationMetadata;

@Configuration
public class CustomBeanMapperConfig implements ImportAware {

	@Inject
	private ApplicationContext applicationContext;

	private ConversionService conversionService;

	@Override
	@SuppressWarnings("unchecked")
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		Map<String, Object> data = importMetadata.getAnnotationAttributes(EnableCustomConversionService.class.getName());
		Class<ConversionService> clazz = (Class<ConversionService>) data.get(EnableCustomConversionService.SERVICE);
		conversionService = applicationContext.getBean(clazz);
	}

	@Bean
	public ConversionService beanMapper() {
		return conversionService;
	}

}
