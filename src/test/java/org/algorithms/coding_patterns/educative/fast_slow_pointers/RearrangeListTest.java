package org.algorithms.coding_patterns.educative.fast_slow_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RearrangeListTest {

    @Test
    void reorder() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);

        RearrangeList.reorder(head);
        assertEquals(2, head.value);
        assertEquals(12, head.next.value);
        assertEquals(4, head.next.next.value);
        assertEquals(10, head.next.next.next.value);
        assertEquals(6, head.next.next.next.next.value);
        assertEquals(8, head.next.next.next.next.next.value);
    }

    @Test
    void reorderOdd() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RearrangeList.reorder(head);
        assertEquals(1, head.value);
        assertEquals(5, head.next.value);
        assertEquals(2, head.next.next.value);
        assertEquals(4, head.next.next.next.value);
        assertEquals(3, head.next.next.next.next.value);
    }
}