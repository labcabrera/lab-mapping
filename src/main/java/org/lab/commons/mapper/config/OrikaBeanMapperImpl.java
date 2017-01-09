package org.lab.commons.mapper.config;

import java.util.List;

import javax.inject.Inject;

import org.lab.commons.mapper.BeanMapper;

import ma.glasnost.orika.MapperFacade;

class OrikaBeanMapperImpl implements BeanMapper {

	@Inject
	private MapperFacade mapperFacade;

	@Override
	public <S, D> D map(S sourceObject, Class<D> destinationClass) {
		return mapperFacade.map(sourceObject, destinationClass);
	}

	@Override
	public <S, D> void map(S sourceObject, D destinationObject) {
		mapperFacade.map(sourceObject, destinationObject);
	}

	@Override
	public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
		return mapperFacade.mapAsList(source, destinationClass);
	}
}
