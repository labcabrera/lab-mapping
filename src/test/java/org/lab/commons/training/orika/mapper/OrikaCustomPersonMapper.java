package org.lab.commons.training.orika.mapper;

import org.lab.commons.training.common.domain.Address;
import org.lab.commons.training.common.domain.Person;
import org.lab.commons.training.common.dto.PersonDto;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class OrikaCustomPersonMapper extends CustomMapper<Person, PersonDto> {

	@Override
	public void mapAtoB(Person a, PersonDto b, MappingContext context) {
		b.setName(a.getFirstName());
		b.setRoad(a.getAddress() != null ? a.getAddress().getRoad() : null);
	}

	@Override
	public void mapBtoA(PersonDto b, Person a, MappingContext context) {
		if (a.getAddress() == null) {
			a.setAddress(new Address());
		}
		a.getAddress().setRoad(b.getRoad());
		a.setFirstName(b.getName());
	}
}
