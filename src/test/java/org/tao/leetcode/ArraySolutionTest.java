package org.tao.leetcode;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class ArraySolutionTest {
	
    @Test
    public void testRotate() {
        ArraySolution solution = new ArraySolution();
        int[] num1 = new int[]{1,2,3,4,5,6,7};
        int[] num1D = new int[]{4,5,6,7,1,2,3};
        solution.rotate(num1,4);
        IntStream.range(0, num1.length).forEach(idx->assertEquals(num1[idx],num1D[idx]));
        int[] num12 = new int[]{1,2,3,4,5,6,7};
        int[] num12D = new int[]{6,7,1,2,3,4,5};
        solution.rotate(num12,2);
        IntStream.range(0, num12.length).forEach(idx->assertEquals(num12[idx],num12D[idx]));
        int[] num2 = new int[]{1,2,3,4,5,6,7};
        int[] num2D = new int[]{5,6,7,1,2,3,4};
        solution.rotate(num2,3);
        IntStream.range(0, num2.length).forEach(idx->assertEquals(num2[idx],num2D[idx]));
        int[] num3 = new int[]{1};
        int[] num3D = new int[]{1};
        solution.rotate(num3,1);
        IntStream.range(0, num3.length).forEach(idx->assertEquals(num3[idx],num3D[idx]));
    }

    @Test
    public void testJump() {
        ArraySolution solution = new ArraySolution();
        System.out.println(solution.jump(new int[]{3,4,3,2,5,4,3}));
        System.out.println(solution.jump(new int[]{1,0}));
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
    }
	
	@Test
	public void testMissingNumber() {
		ArraySolution solution = new ArraySolution();
		assertEquals(solution.missingNumber(new int[]{2,0,1,3}),4);
		assertEquals(solution.missingNumber(new int[]{4,0,1,3}),2);
	}

    @Test
    public void testSingleNonDuplicate() {
        ArraySolution solution = new ArraySolution();
        Assert.assertEquals(1, solution.singleNonDuplicate(new int[]{1}));
        Assert.assertEquals(2, solution.singleNonDuplicate(new int[]{1,1,2,3,3,4,4}));
        Assert.assertEquals(1, solution.singleNonDuplicate(new int[]{1,2,2,3,3,4,4}));
        Assert.assertEquals(1, solution.singleNonDuplicate(new int[]{1,2,2,3,3,4,4,5,5}));
        Assert.assertEquals(3, solution.singleNonDuplicate(new int[]{1,1,2,2,3,4,4}));
        Assert.assertEquals(5, solution.singleNonDuplicate(new int[]{1,1,2,2,4,4,5}));
        Assert.assertEquals(9, solution.singleNonDuplicate(new int[]{1, 1, 2, 2, 4, 4, 5, 5,9}));
    }
}
