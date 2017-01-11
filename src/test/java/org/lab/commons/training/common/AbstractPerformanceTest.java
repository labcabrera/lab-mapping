package org.lab.commons.training.common;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.lab.commons.training.common.domain.Customer;
import org.lab.commons.training.common.domain.HugeBean;
import org.lab.commons.training.common.domain.HugeBeanCopy;
import org.lab.commons.training.common.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractPerformanceTest {

	@Autowired
	private ConversionService conversionService;

	@Bean
	public TestUtils testUtils() {
		return new TestUtils();
	}

	@Test
	public void test_basic_bean() {
		doBasicTestBean(10000);
	}

	@Test
	public void test_huge_bean() {
		doHugeTestBean(10000, 1000);
	}

	protected void doBasicTestBean(int count) {
		Customer customer = testUtils().createCustomer("John", "Doe", "Gaia Boulevard");
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			conversionService.convert(customer, Person.class);
		}
		long t = System.currentTimeMillis() - t0;
		log.debug("Cycles: {}, ms: {}", count, t);

	}

	protected void doHugeTestBean(int count, int stringSize) {
		long t0 = System.currentTimeMillis();
		HugeBean bean = initializeBean(stringSize);
		for (int i = 0; i < count; i++) {
			conversionService.convert(bean, HugeBeanCopy.class);
		}
		long t = System.currentTimeMillis() - t0;
		log.debug("Cycles: {}, ms: {}", count, t);
	}

	private HugeBean initializeBean(int stringSize) {
		HugeBean bean = new HugeBean();
		try {
			for (Field i : bean.getClass().getFields()) {
				if (i.getType() == Integer.class) {
					i.set(bean, 1);
				} else if (i.getType().equals(String.class)) {
					i.set(bean, StringUtils.repeat("x", stringSize));
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return bean;
	}
}
