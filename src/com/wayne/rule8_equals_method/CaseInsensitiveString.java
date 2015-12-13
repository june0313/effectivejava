package com.wayne.rule8_equals_method;

/**
 * Created by wayne on 2015. 12. 13..
 */
public final class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		if (s == null) {
			throw new NullPointerException();
		}
		this.s = s;
	}

	// 대칭성 위반!

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CaseInsensitiveString) {
			return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
		}

		return obj instanceof String && s.equalsIgnoreCase((String) obj);

	}
}
