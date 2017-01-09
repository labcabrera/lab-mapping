package org.lab.commons.training.common;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import javax.inject.Inject;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.lab.commons.mapper.BeanMapper;
import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.CustomerDto;
import org.springframework.context.annotation.Bean;

public abstract class AbstractBasicMapperTest {

	@Inject
	protected BeanMapper beanMapper;

	@Bean
	public TestUtils testUtils() {
		return new TestUtils();
	}

	@Test
	public void test_direct_mapping() {
		Customer customer = testUtils().createCustomer("John", "Doe", "Gaia Boulevard");
		Person person = beanMapper.map(customer, Person.class);
		Customer check = beanMapper.map(person, Customer.class);

		assertThat(person.getFirstName(), equalTo(customer.getFirstName()));
		assertThat(person.getLastName(), equalTo(customer.getLastName()));
		assertThat(person.getAddress(), notNullValue());
		assertThat(person.getAddress().getRoad(), equalTo(customer.getAddress().getRoad()));
		assertThat(check.getFirstName(), equalTo("John"));
	}

	@Test
	public void test_custom_mapping() {
		Customer customer = testUtils().createCustomer("John", "Doe", "Gaia Boulevard");
		CustomerDto customerDto = beanMapper.map(customer, CustomerDto.class);

		assertThat(customerDto.getName(), Matchers.equalTo(customer.getFirstName()));
		assertThat(customerDto.getFirstSurname(), Matchers.equalTo(customer.getLastName()));
		assertThat(customerDto.getAddress(), notNullValue());
		assertThat(customerDto.getAddress().getRoad(), equalTo(customer.getAddress().getRoad()));
	}

}
