package org.algorithms.coding_patterns.educative.breadth_first_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectLevelOrderSiblingsTest {

    @Test
    void connect() {
        TreeNodeNext root = new TreeNodeNext(12);
        root.left = new TreeNodeNext(7);
        root.right = new TreeNodeNext(1);
        root.left.left = new TreeNodeNext(9);
        root.right.left = new TreeNodeNext(10);
        root.right.right = new TreeNodeNext(5);
        ConnectLevelOrderSiblings.connect(root);
        assertEquals(10, root.left.left.next.val);
        assertEquals(5, root.left.left.next.next.val);
        assertNull(root.left.left.next.next.next);
    }
}