package org.tao.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PermutationTest {
	@Test
	public void testNextPermutation() {
		Permutation pm = new Permutation();

		int[] data = new int[]{1,2,3,4,5};
		pm.nextPermutation(data);
		assertEquals(4, data[4]);
		
		data = new int[]{3,2,5,4,1};
		pm.nextPermutation(data);
		assertEquals(4, data[1]);
		assertEquals(5, data[4]);		
	}
}
