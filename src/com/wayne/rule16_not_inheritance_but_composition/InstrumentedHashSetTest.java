package com.wayne.rule16_not_inheritance_but_composition;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by wayne on 2016. 1. 23..
 */
public class InstrumentedHashSetTest {

	@Test
	public void testGetAddCount() throws Exception {
		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
		s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));


		// 3이 리턴될것이 기대되지만 6이 리턴된다.
		// addAll 메소드는 내부적으로 add메소드를 호출하기 때문
		assertThat(s.getAddCount(), is(3));
	}
}