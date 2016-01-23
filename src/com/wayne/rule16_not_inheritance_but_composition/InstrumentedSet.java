package com.wayne.rule16_not_inheritance_but_composition;

import java.util.Collection;
import java.util.Set;

/**
 * Created by wayne on 2016. 1. 23..
 */

// 상속 대신 구성을 사용하는 wrapper 클래스
public class InstrumentedSet<E> extends ForwadingSet<E>{
	private int addCount = 0;

	public InstrumentedSet(Set<E> s) {
		super(s);
	}

	@Override
	public boolean add(E e) {
		this.addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		this.addCount += c.size();
		return super.addAll(c);
	}
}
