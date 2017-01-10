package org.lab.commons.mapper.config;

import javax.inject.Inject;

import org.apache.commons.lang3.NotImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

class ModelMapperConversionService implements ConversionService {

	@Inject
	private ModelMapper modelMapper;

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
		return modelMapper.map(source, targetType);
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		throw new NotImplementedException("Not implemented");
	}

}