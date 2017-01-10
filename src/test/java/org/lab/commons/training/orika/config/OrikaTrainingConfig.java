package org.lab.commons.training.orika.config;

import org.lab.commons.mapper.EnableOrikaConversionService;
import org.lab.commons.training.orika.mapper.OrikaTrainingMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableOrikaConversionService(mapperClass = OrikaTrainingMapper.class)
public class OrikaTrainingConfig {

}
