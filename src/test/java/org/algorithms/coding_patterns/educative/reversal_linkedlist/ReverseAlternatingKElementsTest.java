package org.algorithms.coding_patterns.educative.reversal_linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAlternatingKElementsTest {

    @Test
    void reverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        ListNode reverse = ReverseAlternatingKElements.reverse(head, 2);
        assertEquals(2, reverse.value);
        assertEquals(1, reverse.next.value);
        assertEquals(3, reverse.next.next.value);
        assertEquals(4, reverse.next.next.next.value);
        assertEquals(6, reverse.next.next.next.next.value);
        assertEquals(5, reverse.next.next.next.next.next.value);
        assertEquals(7, reverse.next.next.next.next.next.next.value);
        assertEquals(8, reverse.next.next.next.next.next.next.next.value);
        assertNull(reverse.next.next.next.next.next.next.next.next);
    }
}