package com.wayne.rule16_not_inheritance_but_composition;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wayne on 2016. 1. 23..
 */

// 재사용 가능한 전달 클래스
public class ForwadingSet<E> implements Set<E> {
	private final Set<E> s;

	public ForwadingSet(Set<E> s) {
		this.s = s;
	}

	@Override
	public int size() {
		return s.size();
	}

	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return s.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return s.iterator();
	}

	@Override
	public Object[] toArray() {
		return s.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return s.toArray(a);
	}

	@Override
	public boolean add(E e) {
		return s.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return s.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return s.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return s.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return s.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return s.removeAll(c);
	}

	@Override
	public void clear() {
		s.clear();
	}
}
