package org.algorithms.coding_patterns.educative.deep_first_search;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathWithGivenSequenceTest {
    private static TreeNode root;

    @BeforeAll
    static void setUp(){
        root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
    }

    @Test
    void findPath() {
        assertTrue(PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
        assertTrue(PathWithGivenSequence.findPathDP(root, new int[] { 1, 1, 6 }));
    }

    @Test
    void notFindPath() {
        assertFalse(PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        assertFalse(PathWithGivenSequence.findPathDP(root, new int[] { 1, 0, 7 }));
    }
}