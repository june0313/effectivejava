package com.wayne.rule16_not_inheritance_but_composition;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by wayne on 2016. 1. 23..
 *
 */

// 상속을 잘못 사용한 사례
// fragile class
public class InstrumentedHashSet<E> extends HashSet<E> {
	//요소를 삽입하려 한 횟수
	private int addCount = 0;

	public InstrumentedHashSet() {

	}

	public InstrumentedHashSet(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount = c.size();
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}
}
