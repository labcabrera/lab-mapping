package org.lab.commons.mapper.config;

import static org.lab.commons.mapper.EnableDozerConversionService.CONVERTERS;
import static org.lab.commons.mapper.EnableDozerConversionService.MAPPING_FILES;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dozer.CustomConverter;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.lab.commons.mapper.EnableDozerConversionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DozerConversionServiceConfig implements ImportAware {

	@Inject
	private ApplicationContext applicationContext;

	private DozerBeanMapperFactoryBean factory;
	private Mapper mapper;

	@Override
	@SuppressWarnings("unchecked")
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		log.debug("Reading Dozer mapping configuration");
		factory = new DozerBeanMapperFactoryBean();
		factory.setApplicationContext(applicationContext);
		Map<String, Object> data = importMetadata.getAnnotationAttributes(EnableDozerConversionService.class.getName());

		// Mapping files configuration
		String[] mappingFiles = (String[]) data.get(MAPPING_FILES);
		Resource[] resources = new Resource[mappingFiles.length];
		for (int i = 0; i < resources.length; i++) {
			resources[i] = applicationContext.getResource(mappingFiles[i]);
		}
		factory.setMappingFiles(resources);

		// Custom converters configuration
		Class<CustomConverter>[] converters = (Class<CustomConverter>[]) data.get(CONVERTERS);
		if (converters != null) {
			List<CustomConverter> converterInstances = new ArrayList<>();
			for (Class<CustomConverter> converterClass : converters) {
				converterInstances.add(applicationContext.getBean(converterClass));
			}
			factory.setCustomConverters(converterInstances);
		}
		// TODO define all factory properties
		try {
			factory.afterPropertiesSet();
			mapper = factory.getObject();
			Assert.notNull(mapper, "Dozer mapper cant be null");
		} catch (Exception ex) {
			throw new RuntimeException("Dozer configuration error", ex);
		}
	}

	@Bean
	public Mapper mapper() {
		return mapper;
	}

	@Bean
	public ConversionService conversionService() {
		return new DozerConversionService();
	}

}
