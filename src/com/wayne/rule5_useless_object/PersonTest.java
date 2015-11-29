package com.wayne.rule5_useless_object;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * Created by wayne on 2015. 11. 29..
 */
public class PersonTest {
	private static final int LOOP_CNT = 1000000;

	private Date birthDate;
	private Person person;

	private long startTime;
	private long endTime;

	@Before
	public void setUp() {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.set(1950, Calendar.MARCH, 1, 0, 0, 0);
		birthDate = cal.getTime();
		person = new Person(birthDate);

		startTime = System.currentTimeMillis();
	}

	@After
	public void tearDown() throws Exception {
		endTime = System.currentTimeMillis();
		System.out.println("running time : " + (endTime - startTime) + "ms");
	}

	@Test
	public void testIsBabyBoomer() {
		for (int i = 0; i < LOOP_CNT; i++) {
			person.isBabyBoomer();
		}
	}

	@Test
	public void testIsBabyBoomerImproved() throws Exception {
		for (int i = 0; i < LOOP_CNT; i++) {
			person.isBabyBoomer2();
		}
	}

	@Test
	public void testSumTooSlow() throws Exception {
		Long sum = 0L;
		for(long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println("sum slow : " + sum);
	}

	@Test
	public void testSumFast() throws Exception {
		long sum = 0L;
		for(long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println("sum fast : " + sum);
	}
}