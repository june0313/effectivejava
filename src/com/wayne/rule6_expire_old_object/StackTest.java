package com.wayne.rule6_expire_old_object;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by wayne on 2015. 11. 29..
 */
public class StackTest {
	private Stack stack;

	@Before
	public void setUp() throws Exception {
		stack = new Stack();
		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
	}

	@Test(expected = EmptyStackException.class)
	public void shouldThrowEmptyStackException() {
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
	}
}