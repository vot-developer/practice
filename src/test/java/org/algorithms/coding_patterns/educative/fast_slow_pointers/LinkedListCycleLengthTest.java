package org.algorithms.coding_patterns.educative.fast_slow_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleLengthTest {
    private ListNode head;

    @BeforeEach
    void setUp() {
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
    }

    @Test
    void hasNotCycle() {
        assertEquals(0, LinkedListCycleLength.findCycleLength(head));
    }

    @Test
    void hasCycle1() {
        head.next.next.next.next.next.next = head.next.next;
        assertEquals(4, LinkedListCycleLength.findCycleLength(head));
    }

    @Test
    void hasCycle2() {
        head.next.next.next.next.next.next = head.next.next.next;
        assertEquals(3, LinkedListCycleLength.findCycleLength(head));
    }
}