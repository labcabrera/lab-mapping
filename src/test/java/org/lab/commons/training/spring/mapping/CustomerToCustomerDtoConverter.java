package org.lab.commons.training.spring.mapping;

import org.lab.commons.training.common.domain.Address;
import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.dto.CustomerDto;
import org.springframework.core.convert.converter.Converter;

public class CustomerToCustomerDtoConverter implements Converter<Customer, CustomerDto> {

	@Override
	public CustomerDto convert(Customer source) {
		CustomerDto dto = new CustomerDto();
		dto.setName(source.getFirstName());
		dto.setFirstSurname(source.getLastName());
		if (source.getAddress() != null) {
			dto.setAddress(new Address());
			dto.getAddress().setRoad(source.getAddress().getRoad());
		}
		return dto;
	}

}
