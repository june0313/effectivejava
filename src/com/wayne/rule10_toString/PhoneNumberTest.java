package com.wayne.rule10_toString;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wayne on 2016. 1. 9..
 */
public class PhoneNumberTest {

	@Test
	public void testToString() throws Exception {
		PhoneNumber pn = new PhoneNumber(131, 987, 356);
		assertEquals("(131) 987-3656", pn.toString());
	}
}