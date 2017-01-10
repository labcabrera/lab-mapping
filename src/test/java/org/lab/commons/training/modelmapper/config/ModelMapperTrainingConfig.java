package org.lab.commons.training.modelmapper.config;

import org.lab.commons.mapper.EnableModelMapperConversionService;
import org.lab.commons.training.modelmapper.mapper.CustomerToCustomerDtoPropertyMap;
import org.lab.commons.training.modelmapper.mapper.PersonToPersonDtoPropertyMap;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableModelMapperConversionService(mappings = { //
		CustomerToCustomerDtoPropertyMap.class, //
		PersonToPersonDtoPropertyMap.class })
public class ModelMapperTrainingConfig {
}
