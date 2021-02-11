package org.algorithms.coding_patterns.educative.breadth_first_search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelOrderTraversalTest {

    @Test
    void test1() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        assertEquals(3, result.size());
        assertArrayEquals(new Integer[]{12}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{7, 1}, result.get(1).toArray());
        assertArrayEquals(new Integer[]{9, 10, 5}, result.get(2).toArray());
    }
}