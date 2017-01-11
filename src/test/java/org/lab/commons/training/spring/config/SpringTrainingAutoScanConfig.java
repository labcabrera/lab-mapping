package org.lab.commons.training.spring.config;

import org.lab.commons.mapper.EnableSpringConversionService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.lab.commons.training.spring.mapping" })
@EnableSpringConversionService(autoScan = true)
public class SpringTrainingAutoScanConfig {

}
