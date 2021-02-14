package org.algorithms.coding_patterns.educative.deep_first_search;

/*
Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.

A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
The path must contain at least one node.
 */
public class MaximumPathSum {
    private static int max;

    //time - O(n), space - O(n)
    public static int findMaximumPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        doFind(root);
        return max;
    }

    private static int doFind(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(doFind(node.left), 0);
        int right = Math.max(doFind(node.right), 0);

        int sum = left + right + node.val;
        max = Math.max(sum, max);

        return Math.max(left, right) + node.val;
    }
}
