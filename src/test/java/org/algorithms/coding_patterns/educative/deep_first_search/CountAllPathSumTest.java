package org.algorithms.coding_patterns.educative.deep_first_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountAllPathSumTest {

    @Test
    void countPaths() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        assertEquals(2, CountAllPathSum.countPathsDP(root, 11));
        assertEquals(2, CountAllPathSum.countPaths(root, 11));
    }

    @Test
    void countPaths2() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        assertEquals(3, CountAllPathSum.countPathsDP(root, 8));
        assertEquals(3, CountAllPathSum.countPaths(root, 8));
    }
}