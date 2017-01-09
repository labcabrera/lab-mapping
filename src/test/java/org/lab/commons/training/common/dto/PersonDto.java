package org.lab.commons.training.common.dto;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class PersonDto implements Serializable {

	private String name;

	private String road;

}
