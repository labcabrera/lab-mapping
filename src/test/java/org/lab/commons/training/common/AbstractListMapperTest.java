package org.lab.commons.training.common;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.lab.commons.mapper.BeanMapper;
import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.domain.Person;
import org.springframework.context.annotation.Bean;

public abstract class AbstractListMapperTest {

	@Inject
	private BeanMapper beanMapper;

	@Bean
	public TestUtils testUtils() {
		return new TestUtils();
	}

	@Test
	public void test_mapping_list() {
		List<Customer> customers = Arrays.asList( //
				testUtils().createCustomer("John", "Doe", "Gaia Boulevard"), //
				testUtils().createCustomer("Mike", "Doe", "Spring Boulevard"));
		List<Person> persons = beanMapper.mapAsList(customers, Person.class);
		assertThat(2, equalTo(persons.size()));
		assertThat(customers.iterator().next().getFirstName(), equalTo(persons.iterator().next().getFirstName()));
	}
}
