package org.lab.commons.training.spring.mapping;

import org.lab.commons.training.common.domain.Address;
import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.PersonDto;
import org.springframework.core.convert.converter.Converter;

public class PersonDtoToPersonConverter implements Converter<PersonDto, Person> {

	@Override
	public Person convert(PersonDto source) {
		Person person = new Person();
		person.setFirstName(source.getName());
		person.setAddress(new Address());
		person.getAddress().setRoad(source.getRoad());
		return person;
	}
}
