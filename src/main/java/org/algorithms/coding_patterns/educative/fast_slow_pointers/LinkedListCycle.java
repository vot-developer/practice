package org.algorithms.coding_patterns.educative.fast_slow_pointers;

/*
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 */
public class LinkedListCycle {
    //time - O(n), space - O(1)
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true; // found the cycle
        }
        return false;
    }
}
