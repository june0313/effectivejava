package com.wayne.rule12_compare;

/**
 * Created by wayne on 2015. 12. 13..
 */
public final class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;

	// 초기화 지연 기법을 사용한 해시코드 캐싱
	private volatile int hashCode;

	public PhoneNumber(short areaCode, short prefix, short lineNumber) {
		rangeCheck(areaCode, 999, "area code");
		rangeCheck(prefix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "line number");

		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}

	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		this((short) areaCode, (short) prefix, (short) lineNumber);
	}

	private void rangeCheck(short arg, int max, String name) {
		if (arg < 0 || arg > max) {
			throw new IllegalArgumentException(name + ": " + arg);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PhoneNumber)) {
			return false;
		}
		PhoneNumber pn = (PhoneNumber) obj;
		return pn.lineNumber == this.lineNumber &&
			pn.areaCode == this.areaCode &&
			pn.prefix == this.prefix;
	}

	@Override
	public int hashCode() {
		int result = this.hashCode;
		if (result == 0) {
			result = 17;
			result = 31 * result + this.areaCode;
			result = 31 * result + this.prefix;
			result = 31 * result + this.lineNumber;
			this.hashCode = result;
		}
		return result;
	}

	/**
	 * 전화번호를 문자열로 변환해서 반환한다
	 * 문자열은 "(XXX) YYY-ZZZZ" 형식으로, 14개 문자로 구성된다.
	 * XXX는 지역번호, YYY는 국번, ZZZZ는 회선번호다.
	 * 각 문자 (X, Y, Z)는 하나의 숫자다.
	 * <p>
	 * 전화번호의 각 필드가 주어진 자리를 다 채우지 못 할 경우 필드 앞에는 0이 붙는다.
	 * 예를들어, 회선번호가 123일 경우, 마지막 필드에 채워지는 문자열은 "0123"이 된다.
	 * <p>
	 * 지역번호를 닫는 괄호와 국번 사이에는 공백이 온다는 것에 주의하자.
	 *
	 * @return 문자열로 변환된 전화번호
	 */
	@Override
	public String toString() {
		return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
	}

	@Override
	public PhoneNumber clone() {
		try {
			return (PhoneNumber) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(); // 수행될 리 없음
		}
	}

	@Override
	public int compareTo(PhoneNumber other) {
		// 지역번호 비교
		if (this.areaCode < other.areaCode) {
			return -1;
		}

		if (this.areaCode > other.areaCode) {
			return 1;
		}

		// 지역번호가 같으므로 국번을 비교한다
		if (this.prefix < other.prefix) {
			return -1;
		}

		if (this.prefix > other.prefix) {
			return 1;
		}

		// 지역번호와 국번이 같으므로 회선 번호 비교
		if (this.lineNumber < other.lineNumber) {
			return -1;
		}

		if (this.lineNumber > other.lineNumber) {
			return 1;
		}

		// 모든 필드가 일치함
		return 0;
	}
}
