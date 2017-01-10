package org.lab.commons.mapper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.dozer.CustomConverter;
import org.dozer.DozerEventListener;
import org.lab.commons.mapper.config.DozerBeanMapperConfig;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(DozerBeanMapperConfig.class)
public @interface EnableDozerConversionService {

	public static final String MAPPING_FILES = "mappingFiles";
	public static final String CONVERTERS = "converters";
	public static final String LISTENERS = "listeners";

	String[] mappingFiles() default {};

	Class<? extends CustomConverter>[] converters() default {};

	Class<? extends DozerEventListener>[] listeners() default {};

}
