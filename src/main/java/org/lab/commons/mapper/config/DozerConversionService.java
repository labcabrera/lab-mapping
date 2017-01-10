package org.lab.commons.mapper.config;

import javax.inject.Inject;

import org.apache.commons.lang3.NotImplementedException;
import org.dozer.Mapper;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

class DozerConversionService implements ConversionService {

	@Inject
	private Mapper mapper;

	// @Override
	// public <S, D> D map(S sourceObject, Class<D> destinationClass) {
	// return mapper.map(sourceObject, destinationClass);
	// }
	//
	// @Override
	// public <S, D> void map(S sourceObject, D destinationObject) {
	// mapper.map(sourceObject, destinationObject);
	// }
	//
	// @Override
	// public <S, D> List<D> mapAsList(Iterable<S> source, Class<D>
	// destinationClass) {
	// throw new RuntimeException("Not implemented");
	// }

	@Override
	public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
		return true;
	}

	@Override
	public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return true;
	}

	@Override
	public <T> T convert(Object source, Class<T> targetType) {
		return mapper.map(source, targetType);
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		throw new NotImplementedException("Not implemented");
	}

}
