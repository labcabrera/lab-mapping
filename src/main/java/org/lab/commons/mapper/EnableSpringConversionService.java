package org.lab.commons.mapper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.lab.commons.mapper.config.SpringConversionServiceConfig;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;

/**
 * Configuration annotation to enable Spring conversion API.
 * 
 * @see SpringConversionServiceConfig
 * @see org.springframework.core.convert.ConversionService
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(SpringConversionServiceConfig.class)
public @interface EnableSpringConversionService {

	public static final String AUTOSCAN = "autoScan";
	public static final String CONVERTERS = "converters";

	/**
	 * When autoScan are enabled all beans of type
	 * {@code org.springframework.core.convert.converter.Converter} availables
	 * are automaticaly registered into the ConversionService.
	 * 
	 * @return
	 */
	boolean autoScan() default false;

	/**
	 * Provides a list of
	 * {@code org.springframework.core.convert.converter.Converter} to be
	 * registered into the ConversionService implementation.
	 * 
	 * @return
	 */
	Class<? extends Converter<?, ?>>[] converters() default {};

}
