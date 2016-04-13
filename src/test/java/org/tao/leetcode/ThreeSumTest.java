package org.tao.leetcode;

import org.junit.Test;

public class ThreeSumTest {
	@Test
	public void testThreeSum() {
		ThreeSum ts = new ThreeSum();
		//System.out.println(ts.threeSum(new int[]{1,-1,-1,0}));
		int res = ts.threeSum(new int[]{-3,-2,-5,3,-4}, -1);
		System.out.println(res);
	}
}
