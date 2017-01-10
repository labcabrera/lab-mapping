package org.lab.commons.training.modelmapper.mapper;

import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.PersonDto;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDtoPropertyMap extends PropertyMap<Person, PersonDto> {

	protected void configure() {
		map(source.getFirstName(), destination.getName());
		map().setRoad(source.getAddress().getRoad());
	}
}
