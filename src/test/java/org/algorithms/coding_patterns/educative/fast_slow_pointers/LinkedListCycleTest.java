package org.algorithms.coding_patterns.educative.fast_slow_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {
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
    void hasNotCycle() {
        assertFalse(LinkedListCycle.hasCycle(head));
    }

    @Test
    void hasCycle1() {
        head.next.next.next.next.next.next = head.next.next;
        assertTrue(LinkedListCycle.hasCycle(head));
    }

    @Test
    void hasCycle2() {
        head.next.next.next.next.next.next = head.next.next.next;
        assertTrue(LinkedListCycle.hasCycle(head));
    }
}