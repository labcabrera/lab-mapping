package org.lab.commons.mapper.config;

import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.lab.commons.mapper.BeanMapper;

class DozerBeanMapperImpl implements BeanMapper {

	@Inject
	private Mapper mapper;

	@Override
	public <S, D> D map(S sourceObject, Class<D> destinationClass) {
		return mapper.map(sourceObject, destinationClass);
	}

	@Override
	public <S, D> void map(S sourceObject, D destinationObject) {
		mapper.map(sourceObject, destinationObject);
	}

	@Override
	public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
		throw new RuntimeException("Not implemented");
	}

}
