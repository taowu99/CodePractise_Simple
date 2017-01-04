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

    public int numTrees2(int n) {
        if (n<0)
            return 0;
        int[] res = new int[n+1];
        res[0]=1;
        res[1]=1;
        for (int i=2; i<=n; ++i) {
            res[i]=0;
            for (int k=0; k<i/2; ++k)
                res[i] += res[k]*res[i-k-1]*2;
            if (i%2==1)
                res[i] +=  res[i/2]*res[i/2];
        }
        return res[n];
    }

    public int numTrees(int n) {
        if (n<0)
            return 0;
        int[] res = new int[n+1];
        res[0]=1;
        for (int i=1; i<=n; ++i) {
            res[i]=0;
            for (int k=0; k<i; ++k)
                res[i] += res[k]*res[i-k-1];
        }
        return res[n];
    }
    
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> cache = new Stack();
        TreeNode node = root;
        while (node != null || !cache.empty()) {
            while (node!=null) {
                cache.push(node);
                node = node.left;
            }

            node = cache.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> cache = new Stack();
        TreeNode node = root;
        while (node != null || !cache.empty()) {
            if (node!=null) {
                cache.push(node);
                node = node.left;
            }
            else {
                node = cache.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> cache = new Stack();
        if (root!=null)
            cache.push(root);
        while(!cache.empty()) {
            TreeNode node = cache.pop();
            result.add(0,node.val);
            if (node.left!=null)
                cache.push(node.left);
            if (node.right!=null)
                cache.push(node.right);
        }
        return result;
    }
}
