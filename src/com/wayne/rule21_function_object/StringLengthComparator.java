package com.wayne.rule21_function_object;

/**
 * Created by wayne on 2016. 1. 30..
 */

// 싱글턴 패턴을 이용해 불필요한 객체 생성을 피한다
public class StringLengthComparator implements Comparator<String> {
	private StringLengthComparator() {}

	public static final StringLengthComparator INSTANCE = new StringLengthComparator();

	@Override
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}
