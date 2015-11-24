package com.wayne.rule3_singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static junit.framework.TestCase.assertNotSame;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wayne on 2015. 11. 24..
 */
public class ElvisTest {

	@Test
	public void testSameInstance() {
		Elvis elvis1 = Elvis.INSTANCE;
		Elvis elvis2 = Elvis.INSTANCE;

		assertThat(elvis1, is(elvis2));
	}

	@Test
	public void tesInvokeByReflection() throws Exception {
		Elvis elvis1 = Elvis.INSTANCE;

		Constructor<Elvis> constructor = Elvis.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Elvis elvis2 = constructor.newInstance();

		assertNotSame(elvis1, elvis2);
	}
}