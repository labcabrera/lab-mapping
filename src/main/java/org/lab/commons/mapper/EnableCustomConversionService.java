package org.lab.commons.mapper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.lab.commons.mapper.config.CustomConversionServiceConfig;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

/**
 * @see CustomConversionServiceConfig
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(CustomConversionServiceConfig.class)
public @interface EnableCustomConversionService {

	public static final String SERVICE = "service";

	Class<ConversionService> service();
}
