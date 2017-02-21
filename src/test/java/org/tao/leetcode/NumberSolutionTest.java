package org.tao.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zkdu8y8 on 2/15/2017.
 */
public class NumberSolutionTest {
    @Test
    public void testFractionToDecimal() {
        NumberSolution solution = new NumberSolution();
        System.out.println(solution.fractionToDecimal(1, 5));
        System.out.println(solution.fractionToDecimal(-1, -2147483648));
        System.out.println(solution.fractionToDecimal(-2,151));

        Assert.assertEquals("0.(6)",solution.fractionToDecimal(2,3));
        Assert.assertEquals("2",solution.fractionToDecimal(2,1));
        Assert.assertEquals("-0.1(6)", solution.fractionToDecimal(-1,6));
        Assert.assertEquals("0.(01)", solution.fractionToDecimal(1,99));
    }

    @Test
    public void testMySqrt() {
        NumberSolution solution = new NumberSolution();
        System.out.println("sqrt("+2147483647+")="+solution.mySqrt(2147483647));
        System.out.println("sqrt("+2147395599+")="+solution.mySqrt(2147395599));
        for (int i=0; i<10; ++i)
            System.out.println("sqrt("+i+")="+solution.mySqrt(i));
    }
}
