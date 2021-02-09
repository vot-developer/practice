package org.algorithms.coding_patterns.educative.reversal_linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    void reverse() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        ListNode reverse = ReverseLinkedList.reverse(head);
        assertEquals(10, reverse.value);
        assertEquals(8, reverse.next.value);
        assertEquals(6, reverse.next.next.value);
        assertEquals(4, reverse.next.next.next.value);
        assertEquals(2, reverse.next.next.next.next.value);
    }
}