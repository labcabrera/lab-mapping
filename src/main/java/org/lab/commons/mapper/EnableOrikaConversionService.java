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
 * @see org.lab.commons.mapper.config.OrikaConversionServiceConfig
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(OrikaConversionServiceConfig.class)
public @interface EnableOrikaConversionService {

	public static final String MAPPER_CLASS = "mapperClass";

	Class<? extends ConfigurableMapper> mapperClass() default ConfigurableMapper.class;

}
