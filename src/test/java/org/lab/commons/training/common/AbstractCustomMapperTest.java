package org.lab.commons.training.common;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.lab.commons.mapper.BeanMapper;
import org.lab.commons.training.common.domain.Address;
import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public abstract class AbstractCustomMapperTest {

	@Autowired
	private BeanMapper beanMapper;

	@Bean
	public TestUtils testUtils() {
		return new TestUtils();
	}

	/**
	 * Performs a mapping using a custom converter class defined in module
	 * configuration.
	 */
	@Test
	public void test_custom_class_mapping() {
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Doe");
		person.setAddress(new Address());
		person.getAddress().setRoad("Gaia Boulevard");
		PersonDto personDto = beanMapper.map(person, PersonDto.class);
		Person check = beanMapper.map(personDto, Person.class);

		assertThat(personDto.getName(), equalTo(person.getFirstName()));
		assertThat(personDto.getRoad(), equalTo(person.getAddress().getRoad()));
		assertThat(check.getAddress().getRoad(), equalTo("Gaia Boulevard"));
	}
}
