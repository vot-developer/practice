package org.algorithms.coding_patterns.educative.deep_first_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeDiameterTest {

    @Test
    void findDiameter1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        assertEquals(5, TreeDiameter.findDiameter(root));
    }

    @Test
    void findDiameter2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        assertEquals(7, TreeDiameter.findDiameter(root));
    }
}