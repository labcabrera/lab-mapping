package org.lab.commons.training.dozer.mapper;

import org.apache.commons.lang3.StringUtils;
import org.dozer.CustomConverter;
import org.lab.commons.training.common.domain.Address;
import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.PersonDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DozerTrainingPersonMapper implements CustomConverter {

	@Override
	public Object convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {
		log.debug("Convert {}({}) -> {}({})", source, sourceClass.getName(), destination, destinationClass.getName());
		if (source == null) {
			return null;
		}
		if (PersonDto.class.isAssignableFrom(destinationClass) && Person.class.isAssignableFrom(source.getClass())) {
			Person person = (Person) source;
			PersonDto result = new PersonDto();
			personToPersonDto(person, result);
			return result;
		}
		if (Person.class.isAssignableFrom(destinationClass) && PersonDto.class.isAssignableFrom(source.getClass())) {
			PersonDto personDto = (PersonDto) source;
			Person result = new Person();
			personDtoToPerson(personDto, result);
			return result;
		}
		throw new RuntimeException("Invalid person conversion");
	}

	private void personToPersonDto(final Person person, final PersonDto personDto) {
		personDto.setName(person.getFirstName());
		if (person.getAddress() != null) {
			personDto.setRoad(person.getAddress().getRoad());
		}
	}

	private void personDtoToPerson(final PersonDto personDto, final Person person) {
		if (person.getAddress() == null == StringUtils.isNotBlank(personDto.getRoad())) {
			person.setAddress(new Address());
		}
		person.getAddress().setRoad(personDto.getRoad());
		person.setFirstName(personDto.getName());
	}

}
