package org.lab.commons.training.modelmapper;

import org.junit.runner.RunWith;
import org.lab.commons.training.common.AbstractCustomTest;
import org.lab.commons.training.modelmapper.config.ModelMapperTrainingConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ModelMapperTrainingConfig.class)
public class ModelMapperCustomTest extends AbstractCustomTest {

}
