package org.algorithms.coding_patterns.educative.deep_first_search;

/*
Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
Find the total sum of all the numbers represented by all paths.
 */
public class SumOfPathNumbers {
    //time - O(n), space - O(n)
    public static int findSumOfPathNumbers(TreeNode root) {
        return doFindSumOfPathNumbers(root, 0);
    }

    private static int doFindSumOfPathNumbers(TreeNode node, int sum) {
        if (node == null)
            return 0;

        sum *= 10;
        sum += node.val;
        if (node.left == null && node.right == null)
            return sum;

        return doFindSumOfPathNumbers(node.left, sum)
                + doFindSumOfPathNumbers(node.right, sum);
    }
}
