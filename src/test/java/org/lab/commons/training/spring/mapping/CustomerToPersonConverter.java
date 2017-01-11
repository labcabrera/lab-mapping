package org.lab.commons.training.spring.mapping;

import org.lab.commons.training.common.domain.Address;
import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.domain.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToPersonConverter implements Converter<Customer, Person> {

	@Override
	public Person convert(Customer source) {
		Person person = new Person();
		person.setFirstName(source.getFirstName());
		person.setLastName(source.getLastName());
		if (source.getAddress() != null) {
			person.setAddress(new Address());
			person.getAddress().setRoad(source.getAddress().getRoad());
		}
		return person;
	}

}
