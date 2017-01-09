package org.lab.commons.mapper.config;

import org.lab.commons.mapper.BeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanMapperConfig {

	@Bean
	public BeanMapper beanMapper() {
		throw new RuntimeException("Not implemented");
	}

}
