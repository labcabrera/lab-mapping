package org.lab.commons.mapper.config;

import java.util.Map;

import org.lab.commons.mapper.BeanMapper;
import org.lab.commons.mapper.EnableOrikaBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * @see EnableOrikaBeanMapper
 */
@Configuration
@Slf4j
public class OrikaBeanMapperConfig implements ImportAware {

	private ConfigurableMapper configurableMapper;

	@Override
	@SuppressWarnings("unchecked")
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		log.debug("Reading Orika mapping configuration");
		Map<String, Object> data = importMetadata.getAnnotationAttributes(EnableOrikaBeanMapper.class.getName());
		Class<? extends ConfigurableMapper> clazz = (Class<? extends ConfigurableMapper>) data.get("mapperClass");
		try {
			configurableMapper = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Bean
	public BeanMapper beanMapper() {
		return new OrikaBeanMapperImpl();
	}

	@Bean
	public ConfigurableMapper configurableMapper() {
		return configurableMapper;
	}
}
