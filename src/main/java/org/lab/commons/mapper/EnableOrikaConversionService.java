package org.lab.commons.mapper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.lab.commons.mapper.config.OrikaConversionServiceConfig;
import org.springframework.context.annotation.Import;

import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * @see OrikaConversionServiceConfig
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(OrikaConversionServiceConfig.class)
public @interface EnableOrikaConversionService {

	public static final String MAPPER_CLASS = "mapperClass";

	/**
	 * Defines the {@code ConfigurableMapper} used to map our entities.
	 * <p>
	 * This class registers our customized transormations in a similar way to:
	 * </p>
	 * 
	 * <pre>
	 * public class MyMapper extends ConfigurableMapper {
	 * 
	 * 	protected void configure(MapperFactory factory) {
	 * 
	 * 		factory.classMap(Customer.class, CustomerDto.class).field("firstName", "name")
	 * 				.field("lastName", "firstSurname").byDefault().register();
	 * 
	 * 		factory.classMap(Person.class, PersonDto.class).customize(new PersonToPersonDtoMapper()).byDefault()
	 * 				.register();
	 * 	}
	 * }
	 * </pre>
	 * 
	 * @return The {@code ConfigurableMapper} implementation class.
	 */
	Class<? extends ConfigurableMapper> mapperClass() default ConfigurableMapper.class;

}
