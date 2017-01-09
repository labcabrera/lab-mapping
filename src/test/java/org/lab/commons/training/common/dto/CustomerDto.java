package org.lab.commons.training.common.dto;

import java.io.Serializable;

import org.lab.commons.training.common.domain.Address;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class CustomerDto implements Serializable {

	private String name;

	private String firstSurname;

	private String secondSurname;

	private Address address;

}
