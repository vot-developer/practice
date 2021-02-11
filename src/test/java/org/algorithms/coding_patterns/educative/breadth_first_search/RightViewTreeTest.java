package org.algorithms.coding_patterns.educative.breadth_first_search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RightViewTreeTest {

    @Test
    void traverse() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        assertEquals(4, result.size());
        assertEquals(12, result.get(0).val);
        assertEquals(1, result.get(1).val);
        assertEquals(5, result.get(2).val);
        assertEquals(3, result.get(3).val);
    }
}