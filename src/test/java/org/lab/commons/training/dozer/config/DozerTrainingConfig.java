package org.lab.commons.training.dozer.config;

import org.lab.commons.mapper.EnableDozerConversionService;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDozerConversionService(mappingFiles = { //
		"classpath:dozer-test-mapping.xml", //
		"classpath:dozer-test-custom-converter.xml" })
public class DozerTrainingConfig {

}
