package org.lab.commons.training.spring;

import org.junit.runner.RunWith;
import org.lab.commons.training.common.AbstractBasicTest;
import org.lab.commons.training.spring.config.SpringTrainingConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTrainingConfig.class)
public class SpringBasicTest extends AbstractBasicTest {

}
