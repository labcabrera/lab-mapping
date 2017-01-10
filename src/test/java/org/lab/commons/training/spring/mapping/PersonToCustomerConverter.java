package org.lab.commons.training.spring.mapping;

import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.domain.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToCustomerConverter implements Converter<Person, Customer> {

	@Override
	public Customer convert(Person source) {
		// TODO Auto-generated method stub
		return null;
	}

}
