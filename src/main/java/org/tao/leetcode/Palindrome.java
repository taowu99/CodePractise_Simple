package org.tao.leetcode;

public class Palindrome {

	public String longestPalindrome(String s) {
		int[] maxPalindrome = new int[] { 0, 0 };
		int i = 0;
		while (i < s.length()) {
			int[] ctrRange = neighborOfSameValueAsMe(s, i);
			int[] palindrome = maxPalindromeCouldExtendTo(s, ctrRange[0] - 1, ctrRange[1] + 1);
			if ((palindrome[1] - palindrome[0]) > (maxPalindrome[1] - maxPalindrome[0]))
				maxPalindrome = palindrome;

			// skip the center range, because we have checked it already
			i = ctrRange[1] + 1;
		}

		return s.substring(maxPalindrome[0], maxPalindrome[1] + 1);
	}

	private int[] neighborOfSameValueAsMe(String s, int idx) {
		//int a = idx - 1;
		int e = idx + 1;
		char me = s.charAt(idx);

		// because we skip the elements of same value at line 10, we don't need
		// to check the element one left. They are definitely not same as me
		// while (a>=0 && s.charAt(a)==me)
		// --a;

		while (e < s.length() && s.charAt(e) == me)
			++e;
		return new int[] { idx, e - 1 };
	}

	private int[] maxPalindromeCouldExtendTo(String s, int a, int e) {
		while (a >= 0 && e < s.length() && s.charAt(a) == s.charAt(e)) {
			--a;
			++e;
		}

		return new int[] { a + 1, e - 1 };
	}

}
