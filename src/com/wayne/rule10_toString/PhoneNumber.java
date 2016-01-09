package com.wayne.rule10_toString;

/**
 * Created by wayne on 2015. 12. 13..
 *
 */
public final class PhoneNumber {
	private final short areaCode;
	private final short preFix;
	private final short lineNumber;

	// 초기화 지연 기법을 사용한 해시코드 캐싱
	private volatile int hashCode;

	public PhoneNumber(short areaCode, short preFix, short lineNumber) {
		rangeCheck(areaCode, 999, "area code");
		rangeCheck(preFix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "line number");

		this.areaCode = areaCode;
		this.preFix = preFix;
		this.lineNumber = lineNumber;
	}

	public PhoneNumber(int areaCode, int preFix, int lineNumber) {
		this((short) areaCode, (short) preFix, (short) lineNumber);
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
			pn.preFix == this.preFix;
	}

	@Override
	public int hashCode() {
		int result = this.hashCode;
		if(result == 0) {
			result = 17;
			result = 31 * result + this.areaCode;
			result = 31 * result + this.preFix;
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
	 *
	 * 전화번호의 각 필드가 주어진 자리를 다 채우지 못 할 경우 필드 앞에는 0이 붙는다.
	 * 예를들어, 회선번호가 123일 경우, 마지막 필드에 채워지는 문자열은 "0123"이 된다.
	 *
	 * 지역번호를 닫는 괄호와 국번 사이에는 공백이 온다는 것에 주의하자.
	 *
	 * @return 문자열로 변환된 전화번호
	 */
	@Override
	public String toString() {
		return String.format("(%03d) %03d-%04d", areaCode, preFix, lineNumber);
	}
}
