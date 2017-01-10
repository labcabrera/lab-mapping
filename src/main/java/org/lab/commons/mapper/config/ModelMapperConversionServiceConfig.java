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
 * See
 * 
 * @author lab
 *
 */
@Configuration
@Slf4j
public class ModelMapperConversionServiceConfig implements ImportAware {

	private ModelMapper modelMapper;

	@Override
	@SuppressWarnings("unchecked")
	public void setImportMetadata(AnnotationMetadata metadata) {
		log.debug("Reading ModelMapper mapping configuration");
		modelMapper = new ModelMapper();
		// Mappings
		Map<String, Object> data = metadata.getAnnotationAttributes(EnableModelMapperConversionService.class.getName());
		Class<? extends PropertyMap<?, ?>>[] clases = (Class<? extends PropertyMap<?, ?>>[]) data.get(MAPPINGS);
		for (Class<? extends PropertyMap<?, ?>> i : clases) {
			try {
				PropertyMap<?, ?> instance = i.newInstance();
				modelMapper.addMappings(instance);
			} catch (InstantiationException | IllegalAccessException ex) {
				throw new RuntimeException(ex);
			}
		}
		// Converters
		Class<? extends Converter<?, ?>>[] converters = (Class<? extends Converter<?, ?>>[]) data.get(CONVERTERS);
		for (Class<? extends Converter<?, ?>> i : converters) {
			try {
				Converter<?, ?> instance = i.newInstance();
				modelMapper.addConverter(instance);
			} catch (InstantiationException | IllegalAccessException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	@Bean
	public ModelMapper modelMapper() {
		return modelMapper;
	}

	@Bean
	public ConversionService conversionService() {
		return new ModelMapperConversionService();
	}

}
