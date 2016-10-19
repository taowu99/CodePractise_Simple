package org.tao.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Tao Wu 10/19/2016.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeSolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root==null)
            return result;

        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        boolean fromLeft=false;
        while (queue.peek()!=null) {
            List<Integer> subresult = new ArrayList();
            ArrayDeque<TreeNode> subqueue = new ArrayDeque();
            final int size = queue.size();
            for (int i=0; i<size; ++i) {
                TreeNode node = queue.poll();
                subresult.add(node.val);
                if (fromLeft) {
                    if (node.right!=null)
                        subqueue.addFirst(node.right);
                    if (node.left!=null)
                        subqueue.addFirst(node.left);
                }
                else {
                    if (node.left!=null)
                        subqueue.addFirst(node.left);
                    if (node.right!=null)
                        subqueue.addFirst(node.right);
                }

            }

            result.add(subresult);
            queue.addAll(subqueue);
            fromLeft = !fromLeft;
        }

        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root==null)
            return res;

        Stack<TreeNode> cache = new Stack();
        cache.add(root);
        while (!cache.empty()) {
            TreeNode node = cache.pop();
            res.add(node.val);
            if (node.right!=null)
                cache.push(node.right);
            if (node.left!=null)
                cache.push(node.left);
        }

        return res;
    }
}
