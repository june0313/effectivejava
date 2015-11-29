package com.wayne.rule4_private_constructor;

/**
 * Created by wayne on 2015. 11. 24..
 */
/**
 * 객체를 만들 수 없는 유틸리티 클래스
 */
public class UtilityClass {
	// 객체가 자동 생성되지 못하도록 하여 객체 생성 방지
	private UtilityClass() {
		// 혹시나 클래스 내부에서 실수로 생성자를 호출하면 바로 알 수 있도록 하기 위함
		throw new AssertionError();
	}
}
