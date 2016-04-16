package org.tao.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {
	@Test
	public void testLongestPanlindrome() {
		Palindrome palin = new Palindrome();
		assertEquals("aaa", palin.longestPalindrome("aaaba"));
		assertEquals("a", palin.longestPalindrome("a"));
		assertEquals(null, palin.longestPalindrome(""));
		assertEquals("baabbaab", palin.longestPalindrome("uijkadsfbaabbaaba"));
	}
}
