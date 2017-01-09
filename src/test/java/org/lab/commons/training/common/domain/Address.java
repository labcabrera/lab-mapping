package org.lab.commons.training.common.domain;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class Address implements Serializable {

	private String road;

	private String zipCode;

	private String state;

	private String city;

}
