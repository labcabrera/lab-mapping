package org.lab.commons.training.common.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class Customer implements Serializable {

	private String firstName;

	private String lastName;

	private String surName;

	private Date birthDate;

	private Address address;

}
