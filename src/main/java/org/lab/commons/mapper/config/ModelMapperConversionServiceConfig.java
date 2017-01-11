package org.lab.commons.mapper.config;

import static org.lab.commons.mapper.EnableModelMapperConversionService.CONVERTERS;
import static org.lab.commons.mapper.EnableModelMapperConversionService.MAPPINGS;

import java.util.Map;

import org.lab.commons.mapper.EnableModelMapperConversionService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.type.AnnotationMetadata;

import lombok.extern.slf4j.Slf4j;

/**
 * Exposes those beans:
 * <ul>
 * <li>{@code org.springframework.core.convert.ConversionService}</li>
 * <li>{@code org.modelmapper.ModelMapper}</li>
 * </ul>
 * 
 * @see EnableModelMapperConversionService
 */
@Configuration
@Slf4j
public class ModelMapperConversionServiceConfig extends AbstractConversionServiceConfig implements ImportAware {

	private ModelMapper modelMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.annotation.ImportAware#setImportMetadata(org.
	 * springframework.core.type.AnnotationMetadata)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void setImportMetadata(AnnotationMetadata metadata) {
		log.debug("Reading ModelMapper mapping configuration");
		modelMapper = new ModelMapper();

		// Mappings
		Map<String, Object> data = metadata.getAnnotationAttributes(EnableModelMapperConversionService.class.getName());
		Class<? extends PropertyMap<?, ?>>[] clases = (Class<? extends PropertyMap<?, ?>>[]) data.get(MAPPINGS);
		for (Class<? extends PropertyMap<?, ?>> i : clases) {
			PropertyMap<?, ?> mapping = findOrCreateBean(i);
			modelMapper.addMappings(mapping);
		}

		// Converters
		Class<? extends Converter<?, ?>>[] converters = (Class<? extends Converter<?, ?>>[]) data.get(CONVERTERS);
		for (Class<? extends Converter<?, ?>> i : converters) {
			Converter<?, ?> converter = findOrCreateBean(i);
			modelMapper.addConverter(converter);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lab.commons.mapper.config.AbstractConversionServiceConfig#
	 * conversionService()
	 */
	@Override
	@Bean
	public ConversionService conversionService() {
		return new ModelMapperConversionService();
	}

	@Bean
	public ModelMapper modelMapper() {
		return modelMapper;
	}
}
