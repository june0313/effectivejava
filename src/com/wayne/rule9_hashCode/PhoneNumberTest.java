package com.wayne.rule9_hashCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by wayne on 2016. 1. 9..
 *
 */
public class PhoneNumberTest {
	@Test
	public void hashMapTest() {
		Map<PhoneNumber, String> map = new HashMap<>();
		map.put(new PhoneNumber(707, 876, 5309), "Jenny");

		String result = map.get(new PhoneNumber(707, 876, 5309));
		// 적절한 hashCode를 오버라이딩 하지 않으면, Jenny 가 리턴될 것이라 기대되지만 null이 리턴된다.
		assertEquals(result, "Jenny");
	}
}