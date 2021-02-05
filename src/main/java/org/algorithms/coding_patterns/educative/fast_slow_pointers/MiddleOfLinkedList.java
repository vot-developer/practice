package org.algorithms.coding_patterns.educative.fast_slow_pointers;

/*
Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.

If the total number of nodes in the LinkedList is even, return the second middle node.
 */
public class MiddleOfLinkedList {
    //time - O(n), space - O(1)
    public static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
