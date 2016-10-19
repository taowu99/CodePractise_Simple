package org.tao.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraySolutionTest {
	@Test
	public void testMissingNumber() {
		ArraySolution solution = new ArraySolution();
		assertEquals(solution.missingNumber(new int[]{2,0,1,3}),4);
		assertEquals(solution.missingNumber(new int[]{4,0,1,3}),2);
	}
}
