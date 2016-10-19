package org.tao.test.concurrency;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleThread extends Thread {
	private int id;

	Random rand = new Random();
	
	private static volatile AtomicInteger balance = new AtomicInteger(0);
	
	public SimpleThread(int id) { this.id = id;}
	
	private void changeBalance() {
		int prev = balance.get();
		int delta = (int)(Math.abs(rand.nextInt())%100);
		int aft = balance.addAndGet(delta);
		System.out.println("user "+id+" add "+delta+" to make balance to "+aft+" which is "+prev+" before.");
	}
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			
			changeBalance();
		}
	}
}
