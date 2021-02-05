package org.algorithms.coding_patterns.educative.fast_slow_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleOfLinkedListTest {
    private ListNode head;

    @BeforeEach
    void setUp() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
    }

    @Test
    void findMiddle() {
        assertEquals(3, MiddleOfLinkedList.findMiddle(head));
        head.next.next.next.next.next = new ListNode(6);
        assertEquals(4, MiddleOfLinkedList.findMiddle(head));
        head.next.next.next.next.next.next = new ListNode(7);
        assertEquals(4, MiddleOfLinkedList.findMiddle(head));
    }


}