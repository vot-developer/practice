package org.algorithms.coding_patterns.educative.deep_first_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreePathSumTest {
    private TreeNode root;

    @BeforeEach
    void setUp(){
        root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
    }

    @Test
    void hasPath() {
        assertTrue(TreePathSum.hasPath(root, 23));
    }

    @Test
    void hasNotPath() {
        assertFalse(TreePathSum.hasPath(root, 16));
    }
}