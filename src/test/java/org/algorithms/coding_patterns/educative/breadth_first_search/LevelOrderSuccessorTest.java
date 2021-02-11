package org.algorithms.coding_patterns.educative.breadth_first_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelOrderSuccessorTest {

    @Test
    void findSuccessor() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        assertEquals(7, LevelOrderSuccessor.findSuccessor(root, 12).val);
        assertEquals(9, LevelOrderSuccessor.findSuccessor(root, 1).val);
        assertEquals(10, LevelOrderSuccessor.findSuccessor(root, 9).val);
    }
}