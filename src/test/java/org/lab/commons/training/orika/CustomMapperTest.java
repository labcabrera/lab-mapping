package org.lab.commons.training.orika;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.commons.mapper.BeanMapper;
import org.lab.commons.training.common.TestUtils;
import org.lab.commons.training.common.domain.Address;
import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.PersonDto;
import org.lab.commons.training.orika.config.OrikaTrainingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrikaTrainingConfig.class)
public class CustomMapperTest {

	@Autowired
	private BeanMapper beanMapper;

	@Bean
	public TestUtils testUtils() {
		return new TestUtils();
	}

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
