package org.algorithms.coding_patterns.educative.deep_first_search;

/*
Given a binary tree, find the length of its diameter.
The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
The diameter of a tree may or may not pass through the root.

Note: You can always assume that there are at least two leaf nodes in the given tree.
 */
public class TreeDiameter {
    private static int max = 0;
    //time - O(n), space - O(n)
    public static int findDiameter(TreeNode root) {
        max = 0;
        doFind(root);
        return max;
    }

    private static int doFind(TreeNode root) {
        if (root == null)
            return 0;

        int left = doFind(root.left);
        int right = doFind(root.right);
        max = Math.max(left + right + 1, max);
        return Math.max(left, right) + 1;
    }
}
