package org.tao.leetcode;

import java.util.Stack;

/**
 * Created by zkdu8y8 on 8/18/2016.
 */
public class CalculatorSolution {
    public int calculate(String s) {
        int result = 0;

        return result;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> cache = new Stack();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    cache.push(cache.pop()+cache.pop());
                    break;
                case "/":
                    cache.push((int)(1.0/cache.pop().floatValue()*cache.pop()));
                    break;
                case "*":
                    cache.push(cache.pop()*cache.pop());
                    break;
                case "-":
                    cache.push(-cache.pop()+cache.pop());
                    break;
                default:
                    cache.push(new Integer(s));
                    break;
            }
        }

        return cache.pop();
    }
}
