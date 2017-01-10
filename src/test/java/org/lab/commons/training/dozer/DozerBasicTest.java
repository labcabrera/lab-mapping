package org.lab.commons.training.dozer;

import org.junit.runner.RunWith;
import org.lab.commons.training.common.AbstractBasicTest;
import org.lab.commons.training.dozer.config.DozerTrainingConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DozerTrainingConfig.class)
public class DozerBasicTest extends AbstractBasicTest {

}
