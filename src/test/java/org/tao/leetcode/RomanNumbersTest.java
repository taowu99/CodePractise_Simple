package org.tao.leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

public class RomanNumbersTest {
	@Test
	public void testIntegerToRoman() {
		RomanNumbers roman = new RomanNumbers();
		assertEquals("I", roman.intToRoman(1));
		assertEquals("IX", roman.intToRoman(9));
		assertEquals("CMLXXVIII", roman.intToRoman(978));
	}
}
