package org.tao.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	private Comparator des = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return (int) (o2.intValue() - o1.intValue());
		}
	};
	private PriorityQueue<Integer> smallQueue = new PriorityQueue(1, des);
	private PriorityQueue<Integer> largeQueue = new PriorityQueue();
	
	public MedianFinder(){};

	// Adds a number into the data structure.
	public void addNum(int num) {
		if (smallQueue.size() == 0 || num < smallQueue.peek())
			smallQueue.add(num);
		else
			largeQueue.add(num);
		balanceQueue(smallQueue, largeQueue);
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (smallQueue.size() == largeQueue.size()) 
			return (smallQueue.peek() + largeQueue.peek()) / (double)2.0;
		else {
			PriorityQueue<Integer> lg = smallQueue.size() > largeQueue.size() ? smallQueue : largeQueue;
			return lg.peek().doubleValue();
		}
	}

	public static void balanceQueue(PriorityQueue smallQueue, PriorityQueue largeQueue) {
		// System.out.println(smallQueue.size()+" ? "+largeQueue.size());
		if (Math.abs(smallQueue.size() - largeQueue.size()) >= 2) {
			PriorityQueue from = smallQueue.size() > largeQueue.size() ? smallQueue : largeQueue;
			PriorityQueue to = from == largeQueue ? smallQueue : largeQueue;
			while (Math.abs(from.size() - to.size()) >= 2)
				to.add(from.poll());
		}
	}
}
