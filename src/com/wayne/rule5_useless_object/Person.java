package com.wayne.rule5_useless_object;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by wayne on 2015. 11. 29..
 */
public class Person {
	private final Date birthDate;

	/**
	 * 베이비붐 시대의 시작과 끝
	 */
	private static final Date BOOM_START;
	private static final Date BOOM_END;

	/**
	 * 이렇게 개선된 클래스는 클래스가 초기화 될 때 한번만 만든다
	 */
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		gmtCal.set(Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();

		gmtCal.set(Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}

	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * 이렇게 하면 안된다
	 * 메소드가 호출될 때 마다 Calendar, TimeZone, Date 객체 두개 총 4개의 객체가 쓸데없이 만들어진다
	 * @return
	 */
	public boolean isBabyBoomer() {
		// 생성 비용이 높은 객체를 쓸데없이 생성한다.
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();

		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = gmtCal.getTime();

		return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
	}

	/**
	 *
	 * @return
	 */
	public boolean isBabyBoomer2() {
		return birthDate.compareTo(BOOM_START) >= 0 &&
				birthDate.compareTo(BOOM_END) < 0;
	}
}
