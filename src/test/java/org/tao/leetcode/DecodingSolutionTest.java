package org.tao.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class DecodingSolutionTest {
	@Test
	public void testNumDecodings1() {
		DecodingSolution solution = new DecodingSolution();
		Assert.assertEquals(0,solution.numDecodings(""));
		Assert.assertEquals(0,solution.numDecodings("01234"));
		Assert.assertEquals(3,solution.numDecodings("101234"));
		Assert.assertEquals(1,solution.numDecodings("10"));
	}
	
	@Test
	public void testNumWithStarDecodings1() {
		DecodingSolution solution = new DecodingSolution();
//		Assert.assertEquals(0,solution.numWithStarDecodings(""));
//		Assert.assertEquals(0,solution.numWithStarDecodings("01234"));
//		Assert.assertEquals(3,solution.numWithStarDecodings("101234"));
//		Assert.assertEquals(1,solution.numWithStarDecodings("10"));
//		Assert.assertEquals(9,solution.numWithStarDecodings("*"));
		Assert.assertEquals(11,solution.numWithStarDecodings("*1"));
		Assert.assertEquals(10,solution.numWithStarDecodings("*9"));
		Assert.assertEquals(10,solution.numWithStarDecodings("1*"));
	}
}
