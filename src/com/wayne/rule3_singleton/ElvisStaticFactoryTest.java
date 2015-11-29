package com.wayne.rule3_singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wayne on 2015. 11. 24..
 */
public class ElvisStaticFactoryTest {

	@Test
	public void testGetInstance() {
		ElvisStaticFactory stub1 = ElvisStaticFactory.getInstance();
		ElvisStaticFactory stub2 = ElvisStaticFactory.getInstance();

		assertSame(stub1, stub2);
	}

}