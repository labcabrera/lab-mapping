package org.lab.commons.mapper.config;

import javax.inject.Inject;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import ma.glasnost.orika.MapperFacade;

/**
 * {@code ConversionService} implementation using Orika library.
 */
class OrikaConversionService implements ConversionService {

	@Inject
	private MapperFacade mapperFacade;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.convert.ConversionService#canConvert(java.lang.
	 * Class, java.lang.Class)
	 */
	@Override
	public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.convert.ConversionService#canConvert(org.
	 * springframework.core.convert.TypeDescriptor,
	 * org.springframework.core.convert.TypeDescriptor)
	 */
	@Override
	public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.convert.ConversionService#convert(java.lang.
	 * Object, java.lang.Class)
	 */
	@Override
	public <T> T convert(Object source, Class<T> targetType) {
		return mapperFacade.map(source, targetType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.convert.ConversionService#convert(java.lang.
	 * Object, org.springframework.core.convert.TypeDescriptor,
	 * org.springframework.core.convert.TypeDescriptor)
	 */
	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		throw new NotImplementedException("Not implemented");
	}
}
