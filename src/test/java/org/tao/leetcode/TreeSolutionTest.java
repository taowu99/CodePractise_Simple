package org.tao.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zkdu8y8 on 10/19/2016.
 */
public class TreeSolutionTest {
    @Test
    public void testNumTrees() {
        TreeSolution solution = new TreeSolution();
        assertEquals(1,solution.numTrees(1));
        assertEquals(2,solution.numTrees(2));
        assertEquals(5,solution.numTrees(3));
        assertEquals(132,solution.numTrees(6));
        assertEquals(16796,solution.numTrees(10));

        assertEquals(1,solution.numTrees2(1));
        assertEquals(2,solution.numTrees2(2));
        assertEquals(5,solution.numTrees2(3));
        assertEquals(132,solution.numTrees2(6));
        assertEquals(16796,solution.numTrees2(10));
    }
}
