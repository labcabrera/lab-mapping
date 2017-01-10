package org.lab.commons.training.spring.config;

import org.lab.commons.mapper.EnableSpringConversionService;
import org.lab.commons.training.spring.mapping.CustomerToCustomerDtoConverter;
import org.lab.commons.training.spring.mapping.CustomerToPersonConverter;
import org.lab.commons.training.spring.mapping.HugeBeanConverter;
import org.lab.commons.training.spring.mapping.PersonToCustomerConverter;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan(basePackages = { "org.lab.commons.training.spring.mapping" })
@EnableSpringConversionService(autoScan = false, //
		converters = { PersonToCustomerConverter.class, //
				CustomerToCustomerDtoConverter.class, //
				CustomerToPersonConverter.class, //
				HugeBeanConverter.class })
public class SpringTrainingConfig {

}
