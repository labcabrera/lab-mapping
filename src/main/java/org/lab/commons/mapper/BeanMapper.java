package org.lab.commons.mapper;

import java.util.List;

/**
 * @see ma.glasnost.orika.MapperFacade
 * @see org.dozer.Mapper
 */
public interface BeanMapper {

	<S, D> D map(S sourceObject, Class<D> destinationClass);

	<S, D> void map(S sourceObject, D destinationObject);

	<S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass);

}
