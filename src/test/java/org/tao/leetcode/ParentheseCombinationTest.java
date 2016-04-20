package org.tao.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParentheseCombinationTest {
	@Test
	public void testGenerate() {
		ParentheseCombination pcmb = new ParentheseCombination();
		assertEquals(14, pcmb.generateParenthesis(4).size());
	}
}
