package org.lab.commons.training.orika.mapper;

import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.CustomerDto;
import org.lab.commons.training.common.dto.PersonDto;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class OrikaTrainingMapper extends ConfigurableMapper {

	protected void configure(MapperFactory factory) {

		factory.classMap(Customer.class, CustomerDto.class)//
				.field("firstName", "name")//
				.field("lastName", "firstSurname")//
				.byDefault().register();

		factory.classMap(Person.class, PersonDto.class)//
				.customize(new PersonToPersonDtoMapper())//
				.byDefault() //
				.register();
	}
}