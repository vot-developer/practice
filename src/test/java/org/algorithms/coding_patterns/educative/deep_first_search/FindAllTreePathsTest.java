package org.algorithms.coding_patterns.educative.deep_first_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindAllTreePathsTest {
    private TreeNode root;

    @BeforeEach
    void setUp(){
        root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
    }

    @Test
    void findPaths() {
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, 23);
        assertEquals(2, result.size());
        assertArrayEquals(new Integer[]{12, 7, 4}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{12, 1, 10}, result.get(1).toArray());
    }
}