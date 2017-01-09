package org.lab.commons.mapper.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.lab.commons.mapper.BeanMapper;
import org.lab.commons.mapper.EnableDozerBeanMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DozerBeanMapperConfig implements ImportAware {

	@Inject
	private ApplicationContext applicationContext;

	private DozerBeanMapperFactoryBean factory;
	private Mapper mapper;

	@Override
	@SuppressWarnings("unchecked")
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		log.debug("Reading Dozer mapping configuration");
		factory = new DozerBeanMapperFactoryBean();
		Map<String, Object> data = importMetadata.getAnnotationAttributes(EnableDozerBeanMapper.class.getName());

		// Mapping files configuration
		String[] mappingFiles = (String[]) data.get(EnableDozerBeanMapper.MAPPING_FILES);
		Resource[] resources = new Resource[mappingFiles.length];
		for (int i = 0; i < resources.length; i++) {
			resources[i] = applicationContext.getResource(mappingFiles[i]);
		}
		factory.setMappingFiles(resources);

		// factory.setMappingFiles(mappingFiles);
		// Custom converters configuration
		Class<CustomConverter>[] converterClases = (Class<CustomConverter>[]) data.get("converters");
		if (converterClases != null) {
			List<CustomConverter> converterInstances = new ArrayList<>();
			for (Class<CustomConverter> converterClass : converterClases) {
				converterInstances.add(applicationContext.getBean(converterClass));
			}
			factory.setCustomConverters(converterInstances);
		}
		// TODO define all factory properties
		try {
			mapper = factory.getObject();
		} catch (Exception ex) {
			throw new RuntimeException("Dozer configuration error", ex);
		}
		mapper = (mapper != null ? mapper : new DozerBeanMapper());
	}

	@Bean
	public Mapper mapper() {
		return mapper;
	}

	@Bean
	public BeanMapper beanMapper() {
		return new DozerBeanMapperImpl();
	}

}
