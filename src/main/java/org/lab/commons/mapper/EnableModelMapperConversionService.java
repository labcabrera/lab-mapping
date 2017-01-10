package org.lab.commons.mapper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.lab.commons.mapper.config.ModelMapperConversionServiceConfig;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ModelMapperConversionServiceConfig.class)
public @interface EnableModelMapperConversionService {

	public static final String MAPPINGS = "mappings";
	public static final String CONVERTERS = "converters";

	Class<? extends PropertyMap<?, ?>>[] mappings() default {};

	Class<? extends Converter<?, ?>>[] converters() default {};

}
