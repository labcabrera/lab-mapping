package org.lab.commons.training.spring.mapping;

import org.lab.commons.training.common.domain.HugeBean;
import org.lab.commons.training.common.domain.HugeBeanCopy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HugeBeanConverter implements Converter<HugeBean, HugeBeanCopy> {

	@Override
	public HugeBeanCopy convert(HugeBean source) {
		HugeBeanCopy result = new HugeBeanCopy();
		result.setStr01(source.getStr01());
		result.setStr02(source.getStr02());
		result.setStr03(source.getStr03());
		result.setStr04(source.getStr04());
		result.setStr05(source.getStr05());
		result.setStr06(source.getStr06());
		result.setStr07(source.getStr07());
		result.setStr08(source.getStr08());
		result.setStr09(source.getStr09());
		result.setStr10(source.getStr10());
		return result;
	}
}
