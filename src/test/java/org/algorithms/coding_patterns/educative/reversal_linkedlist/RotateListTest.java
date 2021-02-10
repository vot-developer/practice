package org.algorithms.coding_patterns.educative.reversal_linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateListTest {
    private ListNode head;

    @BeforeEach
    void setUp(){
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
    }

    @Test
    void rotate() {
        ListNode reverse = RotateList.rotate(head, 3);
        assertEquals(4, reverse.value);
        assertEquals(5, reverse.next.value);
        assertEquals(6, reverse.next.next.value);
        assertEquals(1, reverse.next.next.next.value);
        assertEquals(2, reverse.next.next.next.next.value);
        assertEquals(3, reverse.next.next.next.next.next.value);
        assertNull(reverse.next.next.next.next.next.next);
    }

    @Test
    void rotateOverflow() {
        ListNode reverse = RotateList.rotate(head, 9);
        assertEquals(4, reverse.value);
        assertEquals(5, reverse.next.value);
        assertEquals(6, reverse.next.next.value);
        assertEquals(1, reverse.next.next.next.value);
        assertEquals(2, reverse.next.next.next.next.value);
        assertEquals(3, reverse.next.next.next.next.next.value);
        assertNull(reverse.next.next.next.next.next.next);
    }
}