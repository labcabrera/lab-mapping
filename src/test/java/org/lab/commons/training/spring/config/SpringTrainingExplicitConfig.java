package org.lab.commons.training.spring.config;

import org.lab.commons.mapper.EnableSpringConversionService;
import org.lab.commons.training.spring.mapping.CustomerToCustomerDtoConverter;
import org.lab.commons.training.spring.mapping.CustomerToPersonConverter;
import org.lab.commons.training.spring.mapping.HugeBeanConverter;
import org.lab.commons.training.spring.mapping.PersonDtoToPersonConverter;
import org.lab.commons.training.spring.mapping.PersonToCustomerConverter;
import org.lab.commons.training.spring.mapping.PersonToPersonDtoConverter;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSpringConversionService(autoScan = false, //
		converters = { PersonToCustomerConverter.class, //
				CustomerToCustomerDtoConverter.class, //
				CustomerToPersonConverter.class, //
				HugeBeanConverter.class, //
				PersonToPersonDtoConverter.class, //
				PersonDtoToPersonConverter.class })
public class SpringTrainingExplicitConfig {

}
