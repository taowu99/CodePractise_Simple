package org.tao.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedianFinderTest {
	@Test
	public void testFindMedia() {
		MedianFinder median = new MedianFinder();
		median.addNum(2);
		assert(2==median.findMedian());
		median.addNum(3);
		assert(2.5==median.findMedian());
	}
}
