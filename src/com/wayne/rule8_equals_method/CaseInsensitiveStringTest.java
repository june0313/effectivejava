package com.wayne.rule8_equals_method;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wayne on 2015. 12. 13..
 */
public class CaseInsensitiveStringTest {
	private CaseInsensitiveString cis;
	private String str;

	@Before
	public void setUp() {
		this.cis = new CaseInsensitiveString("Polish");
		this.str = "Polish";
	}

	@Test
	public void should_return_true() {
		boolean result = cis.equals(str);
		assertTrue(result);
	}

	@Test
	public void should_return_false() throws Exception {
		// 위의 테스트와 대칭성이 깨진다
		boolean result = str.equals(cis);
		assertFalse(result);
	}

	@Test
	public void test_collection_contains() throws Exception {
		List<CaseInsensitiveString> list = new ArrayList<>();
		list.add(cis);

		assertEquals(list.contains(str), false);
	}
}