package org.tao.leetcode;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by zkdu8y8 on 8/18/2016.
 */
public class CalculatorSolutionTest {
    @Test
    public void testBasicCalculator() {
        CalculatorSolution solution = new CalculatorSolution();
        assertEquals(solution.calculate("4+5-(6+1)"),2);
    }

    @Test
    public void testReversePolishNotation() {
        CalculatorSolution solution = new CalculatorSolution();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
