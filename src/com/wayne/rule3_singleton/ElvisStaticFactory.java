package com.wayne.rule3_singleton;

/**
 * Created by wayne on 2015. 11. 24..
 */
public class ElvisStaticFactory {
	private static final ElvisStaticFactory INSTANCE = new ElvisStaticFactory();

	private ElvisStaticFactory() {
	}

	public static ElvisStaticFactory getInstance() {
		return INSTANCE;
	}
}
