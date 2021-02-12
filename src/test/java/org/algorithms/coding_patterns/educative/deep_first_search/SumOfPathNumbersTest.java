package org.algorithms.coding_patterns.educative.deep_first_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfPathNumbersTest {

    @Test
    void findSumOfPathNumbers() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        assertEquals(332,  SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}