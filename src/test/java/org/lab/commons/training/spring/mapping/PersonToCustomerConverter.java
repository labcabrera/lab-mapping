package org.lab.commons.training.spring.mapping;

import org.lab.commons.training.common.domain.Address;
import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.domain.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToCustomerConverter implements Converter<Person, Customer> {

	@Override
	public Customer convert(Person source) {
		Customer customer = new Customer();
		customer.setFirstName(source.getFirstName());
		customer.setLastName(source.getLastName());
		if (source.getAddress() != null) {
			customer.setAddress(new Address());
			customer.getAddress().setRoad(source.getAddress().getRoad());
		}
		return customer;
	}

}
