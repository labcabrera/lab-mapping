package org.lab.commons.training.spring;

import org.junit.runner.RunWith;
import org.lab.commons.training.common.AbstractPerformanceTest;
import org.lab.commons.training.spring.config.SpringTrainingExplicitConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTrainingExplicitConfig.class)
public class SpringPerformanceTest extends AbstractPerformanceTest {

}
