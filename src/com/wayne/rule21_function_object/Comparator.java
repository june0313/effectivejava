package com.wayne.rule21_function_object;

/**
 * Created by wayne on 2016. 1. 30..
 */
// 전략 인터페이스
public interface Comparator<T> {
	public int compare(T t1, T t2);
}
