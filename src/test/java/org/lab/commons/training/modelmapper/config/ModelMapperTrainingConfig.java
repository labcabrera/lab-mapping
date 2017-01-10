package org.lab.commons.training.modelmapper.config;

import org.lab.commons.mapper.EnableModelMapperConversionService;
import org.lab.commons.training.modelmapper.mapper.CustomerToCustomerDtoPropertyMap;
import org.lab.commons.training.modelmapper.mapper.PersonDtoToPersonConverter;
import org.lab.commons.training.modelmapper.mapper.PersonToPersonDtoConverter;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableModelMapperConversionService(//
		mappings = { CustomerToCustomerDtoPropertyMap.class }, //
		converters = { PersonToPersonDtoConverter.class, PersonDtoToPersonConverter.class })
public class ModelMapperTrainingConfig {
}
