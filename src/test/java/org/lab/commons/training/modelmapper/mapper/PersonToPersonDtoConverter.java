package org.lab.commons.training.modelmapper.mapper;

import org.lab.commons.training.common.domain.Address;
import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.PersonDto;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonToPersonDtoConverter implements Converter<PersonDto, Person> {

	@Override
	public Person convert(MappingContext<PersonDto, Person> context) {
		log.debug("Convert {} to Person", context.getSource());
		PersonDto dto = context.getSource();
		Person person = new Person();
		person.setFirstName(dto.getName());
		person.setAddress(new Address());
		person.getAddress().setRoad(dto.getRoad());
		return person;
	}
}
