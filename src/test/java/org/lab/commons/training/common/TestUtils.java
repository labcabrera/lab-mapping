package org.lab.commons.training.common;

import org.lab.commons.training.common.domain.Address;
import org.lab.commons.training.common.domain.Customer;

public class TestUtils {

	public Customer createCustomer(String firstName, String lastName, String road) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(new Address());
		customer.getAddress().setRoad(road);
		return customer;
	}

}
