package org.lab.commons.training.spring.mapping;

import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.PersonDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDtoConverter implements Converter<Person, PersonDto> {

	@Override
	public PersonDto convert(Person source) {
		PersonDto dto = new PersonDto();
		dto.setName(source.getFirstName());
		dto.setRoad(source.getAddress() != null ? source.getAddress().getRoad() : null);
		return dto;
	}
}
