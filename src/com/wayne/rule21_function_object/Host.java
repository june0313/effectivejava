package com.wayne.rule21_function_object;

import java.io.Serializable;

/**
 * Created by wayne on 2016. 1. 30..
 */
public class Host {
	private static class StrLenCmp implements Comparator<String>, Serializable {
		@Override
		public int compare(String t1, String t2) {
			return t1.length() - t2.length();
		}
	}

	// 이 비교자는 직렬화가 가능하다.
	public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();

	// 나머지 생략
}
