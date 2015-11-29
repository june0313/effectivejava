package com.wayne.rule3_singleton;

/**
 * Created by wayne on 2015. 11. 24..
 */

/**
 * public final 필드를 이용한 싱글톤
 */
public class Elvis {
	public static final Elvis INSTANCE = new Elvis();

	private Elvis() {
	}

	public void leaveTheBuilding() {
	}
}
