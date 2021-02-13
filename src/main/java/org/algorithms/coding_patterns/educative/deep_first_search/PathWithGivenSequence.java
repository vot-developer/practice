package org.algorithms.coding_patterns.educative.deep_first_search;

/*
Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
 */
public class PathWithGivenSequence {
    //time - O(n), space - O(1)
    public static boolean findPath(TreeNode root, int[] sequence) {
        TreeNode node = root;
        int i = 0;
        for (; i < sequence.length - 1; i++){
            if (node == null || node.val != sequence[i])
                return false;

            if (node.left.val == sequence[i + 1])
                node = node.left;
            else
                node = node.right;
        }

        if (node == null)
            return false;

        return node.val == sequence[i] && node.left == null && node.right == null;
    }

    //pattern - dp, time - O(n), space - O(n)
    public static boolean findPathDP(TreeNode root, int[] sequence) {
        return doFind(root, sequence, 0);
    }

    private static boolean doFind(TreeNode node, int[] sequence, int i) {
        if (node == null || i == sequence.length)
            return false;

        if (node.val != sequence[i])
            return false;

        if (i == sequence.length - 1 && node.right == null && node.left == null)
            return true;

        return doFind(node.left, sequence, i + 1) || doFind(node.right, sequence, i + 1);
    }
}
