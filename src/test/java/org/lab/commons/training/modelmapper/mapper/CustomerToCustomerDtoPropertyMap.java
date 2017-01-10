package org.lab.commons.training.modelmapper.mapper;

import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.dto.CustomerDto;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDtoPropertyMap extends PropertyMap<Customer, CustomerDto> {

	protected void configure() {
		map(source.getFirstName(), destination.getName());
		map(source.getLastName(), destination.getFirstSurname());
	}
}
