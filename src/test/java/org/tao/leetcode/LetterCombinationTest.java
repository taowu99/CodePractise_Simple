package org.tao.leetcode;

import java.util.List;

import org.junit.Test;

public class LetterCombinationTest {
	@Test
	public void testLetterCombination() {
		LetterCombination lc = new LetterCombination();
		List rs = lc.letterCombinations("5961");
		System.out.println(rs);
	}
}
