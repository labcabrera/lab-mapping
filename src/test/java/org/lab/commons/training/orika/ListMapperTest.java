package org.lab.commons.training.orika;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.commons.mapper.BeanMapper;
import org.lab.commons.training.common.TestUtils;
import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.orika.config.OrikaTrainingConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrikaTrainingConfig.class)
public class ListMapperTest {

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
