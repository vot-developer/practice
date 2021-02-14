package org.algorithms.coding_patterns.educative.deep_first_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumPathSumTest {

    @Test
    void findMaximumPathSum1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals(6, MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        assertEquals(31, MaximumPathSum.findMaximumPathSum(root));
    }

    @Test
    void findMaximumPathSum2() {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        assertEquals(-1, MaximumPathSum.findMaximumPathSum(root));
    }
}