package org.lab.commons.training.dozer.config;

import org.lab.commons.mapper.EnableDozerBeanMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDozerBeanMapper(mappingFiles = { //
		"classpath:dozer-test-mapping.xml", //
		"classpath:dozer-test-custom-converter.xml" })
public class DozerTrainingConfig {

}
