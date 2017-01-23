package org.tao.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

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

    @Test
    public void testRebuildBinaryTreeFromPreandInt() {
        TreeSolution solution = new TreeSolution();
        int[] prOrder = new int[] {1,2};
        int[] inOrder = new int[] {2,1};
        TreeNode root =solution.reBuildTreeFromPreAndInOrder(prOrder, inOrder);
        List<Integer> preOrder = solution.preorderTraversal(root);
        for (int i=0; i<prOrder.length; ++i)
            assertEquals(preOrder.get(i).intValue(), prOrder[i]);
        System.out.println(preOrder);

        prOrder = new int[] {1,2,3,4,5};
        inOrder = new int[] {2,1,3,4,5};
        root =solution.reBuildTreeFromPreAndInOrder(prOrder, inOrder);
        preOrder = solution.preorderTraversal(root);
        for (int i=0; i<prOrder.length; ++i)
            assertEquals(preOrder.get(i).intValue(), prOrder[i]);
        System.out.println(preOrder);
    }

    @Test
    public void testRebuildBinaryTreeFromPreandIntOOne() {
        TreeSolution solution = new TreeSolution();
        int[] prOrder = new int[] {1,2};
        int[] inOrder = new int[] {2,1};
        TreeNode root =solution.reBuildTreeFromPreAndInOrder(prOrder, inOrder);
        List<Integer> preOrder = solution.preorderTraversal(root);
        for (int i=0; i<prOrder.length; ++i)
            assertEquals(preOrder.get(i).intValue(), prOrder[i]);
        System.out.println(preOrder);

        prOrder = new int[] {1,2,3,4,5};
        inOrder = new int[] {2,1,3,4,5};
        root =solution.reBuildTreeFromPreAndInOrder(prOrder, inOrder);
        preOrder = solution.preorderTraversal(root);
        for (int i=0; i<prOrder.length; ++i)
            assertEquals(preOrder.get(i).intValue(), prOrder[i]);
        System.out.println(preOrder);
    }

    @Test
    public void testRebuildBinaryTreeFromPostandInt() {
        TreeSolution solution = new TreeSolution();
        int[] poOrder = new int[] {1,2};
        int[] inOrder = new int[] {1,2};
        TreeNode root =solution.reBuildTreeFromPostAndInOrder(poOrder, inOrder);
        List<Integer> pstOrder = solution.postorderTraversal(root);
        for (int i=0; i<poOrder.length; ++i)
            assertEquals(pstOrder.get(i).intValue(), poOrder[i]);
        System.out.println(pstOrder);

        poOrder = new int[] {1,3,2};
        inOrder = new int[] {1,2,3};
        root =solution.reBuildTreeFromPostAndInOrder(poOrder, inOrder);
        pstOrder = solution.postorderTraversal(root);
        for (int i=0; i<poOrder.length; ++i)
            assertEquals(pstOrder.get(i).intValue(), poOrder[i]);
        System.out.println(pstOrder);

        poOrder = new int[] {2,1};
        inOrder = new int[] {1,2};
        root =solution.reBuildTreeFromPostAndInOrder(poOrder, inOrder);
        pstOrder = solution.postorderTraversal(root);
        for (int i=0; i<poOrder.length; ++i)
            assertEquals(pstOrder.get(i).intValue(), poOrder[i]);
        System.out.println(pstOrder);
    }
}
