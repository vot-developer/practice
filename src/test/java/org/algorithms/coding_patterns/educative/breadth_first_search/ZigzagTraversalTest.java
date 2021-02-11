package org.algorithms.coding_patterns.educative.breadth_first_search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigzagTraversalTest {

    @Test
    void traverse() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        assertEquals(4, result.size());
        assertArrayEquals(new Integer[]{12}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{1, 7}, result.get(1).toArray());
        assertArrayEquals(new Integer[]{9, 10, 5}, result.get(2).toArray());
        assertArrayEquals(new Integer[]{17, 20}, result.get(3).toArray());
    }
}