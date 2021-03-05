package org.algorithms.coding_patterns.educative.k_way_merge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsTest {

    @Test
    void merge() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        assertEquals(1, result.val);
        result = result.next;
        assertEquals(2, result.val);
        result = result.next;
        assertEquals(3, result.val);
        result = result.next;
        assertEquals(3, result.val);
        result = result.next;
        assertEquals(4, result.val);
        result = result.next;
        assertEquals(6, result.val);
        result = result.next;
        assertEquals(6, result.val);
        result = result.next;
        assertEquals(7, result.val);
        result = result.next;
        assertEquals(8, result.val);
    }
}