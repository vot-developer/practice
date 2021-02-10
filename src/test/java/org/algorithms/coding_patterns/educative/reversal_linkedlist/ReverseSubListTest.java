package org.algorithms.coding_patterns.educative.reversal_linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseSubListTest {

    @Test
    void reverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode reverse = ReverseSubList.reverse(head, 2, 4);
        assertEquals(1, reverse.value);
        assertEquals(4, reverse.next.value);
        assertEquals(3, reverse.next.next.value);
        assertEquals(2, reverse.next.next.next.value);
        assertEquals(5, reverse.next.next.next.next.value);
    }

    @Test
    void corner() {
        ListNode head = new ListNode(5);
        ListNode reverse = ReverseSubList.reverse(head, 1, 1);
        assertEquals(5, reverse.value);
    }

    @Test
    void corner1() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        ListNode reverse = ReverseSubList.reverse(head, 1, 1);
        assertEquals(3, reverse.value);
        assertEquals(5, reverse.next.value);
    }
}