package org.lab.commons.mapper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.lab.commons.mapper.config.SpringConversionServiceConfig;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(SpringConversionServiceConfig.class)
public @interface EnableSpringConversionService {

	public static final String AUTOSCAN = "autoScan";
	public static final String CONVERTERS = "converters";

	boolean autoScan() default false;

	Class<? extends Converter<?, ?>>[] converters() default {};

}
