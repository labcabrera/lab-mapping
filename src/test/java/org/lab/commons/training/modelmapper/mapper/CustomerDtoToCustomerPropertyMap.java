package org.lab.commons.training.modelmapper.mapper;

import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.dto.CustomerDto;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoToCustomerPropertyMap extends PropertyMap<CustomerDto, Customer> {

	protected void configure() {
		map(source.getName(), destination.getFirstName());
		map(source.getFirstSurname(), destination.getLastName());
	}
}
