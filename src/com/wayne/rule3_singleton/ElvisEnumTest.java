package com.wayne.rule3_singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wayne on 2015. 11. 24..
 */
public class ElvisEnumTest {

	@Test
	public void testSingleton() {
		ElvisEnum stub1 = ElvisEnum.INSTANCE;
		ElvisEnum stub2 = ElvisEnum.INSTANCE;

		assertSame(stub1, stub2);
	}
}