package org.tao.test.concurrency;

import org.junit.Test;

public class SimpleThreadTest {
	@Test
	public void test1() {
		for (int i=0; i<10; ++i) {
			SimpleThread thread = new SimpleThread(i);
			thread.start();
		}
	}
}
