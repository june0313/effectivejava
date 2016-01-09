package com.wayne.rule9_hashCode;

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
}
