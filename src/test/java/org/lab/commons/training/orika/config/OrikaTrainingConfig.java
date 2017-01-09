package org.lab.commons.training.orika.config;

import org.lab.commons.mapper.EnableOrikaBeanMapper;
import org.lab.commons.training.orika.mapper.OrikaTrainingMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableOrikaBeanMapper(mapperClass = OrikaTrainingMapper.class)
public class OrikaTrainingConfig {

}
