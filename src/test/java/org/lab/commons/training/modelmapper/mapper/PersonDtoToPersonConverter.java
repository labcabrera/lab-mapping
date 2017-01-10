package org.lab.commons.training.modelmapper.mapper;

import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.PersonDto;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonDtoToPersonConverter implements Converter<Person, PersonDto> {

	@Override
	public PersonDto convert(MappingContext<Person, PersonDto> context) {
		log.debug("Convert {} to PersonDto", context.getSource());
		Person person = context.getSource();
		PersonDto dto = new PersonDto();
		dto.setName(person.getFirstName());
		dto.setRoad(person.getAddress() != null ? person.getAddress().getRoad() : null);
		return dto;
	}
}
