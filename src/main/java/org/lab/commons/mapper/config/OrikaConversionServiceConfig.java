package org.lab.commons.mapper.config;

import static org.lab.commons.mapper.EnableOrikaConversionService.MAPPER_CLASS;

import java.util.Map;

import org.lab.commons.mapper.EnableOrikaConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.type.AnnotationMetadata;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * * Exposes those beans:
 * <ul>
 * <li>{@code org.springframework.core.convert.ConversionService}</li>
 * <li>{@code ma.glasnost.orika.impl.ConfigurableMapper}</li>
 * </ul>
 * 
 * @see EnableOrikaConversionService
 */
@Configuration
@Slf4j
public class OrikaConversionServiceConfig extends AbstractConversionServiceConfig implements ImportAware {

	private ConfigurableMapper configurableMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.annotation.ImportAware#setImportMetadata(org.
	 * springframework.core.type.AnnotationMetadata)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		log.debug("Reading Orika mapping configuration");
		Map<String, Object> data = importMetadata.getAnnotationAttributes(EnableOrikaConversionService.class.getName());
		Class<? extends ConfigurableMapper> clazz = (Class<? extends ConfigurableMapper>) data.get(MAPPER_CLASS);
		configurableMapper = findOrCreateBean(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lab.commons.mapper.config.AbstractConversionServiceConfig#
	 * conversionService()
	 */
	@Bean
	public ConversionService conversionService() {
		return new OrikaConversionService();
	}

	@Bean
	public ConfigurableMapper configurableMapper() {
		return configurableMapper;
	}
}
