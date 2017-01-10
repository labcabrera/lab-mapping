package org.lab.commons.training.orika;

import org.junit.runner.RunWith;
import org.lab.commons.training.common.AbstractPerformanceTest;
import org.lab.commons.training.orika.config.OrikaTrainingConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrikaTrainingConfig.class)
public class OrikaPerformanceTest extends AbstractPerformanceTest {

}
