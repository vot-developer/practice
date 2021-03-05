package org.algorithms.coding_patterns.educative.deep_first_search;

/*
Given a binary tree and a number 'S',
find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals 'S'.
 */
public class TreePathSum {
    //time - O(n), space - O(n)
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.val == sum && root.left == null && root.right == null)
            return true;

        int newSum = sum - root.val;
        return hasPath(root.left, newSum) || hasPath(root.right, newSum);
    }
}
