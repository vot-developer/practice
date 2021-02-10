package org.algorithms.coding_patterns.educative.reversal_linkedlist;

/*
Given the head of a Singly LinkedList, reverse the LinkedList.
Write a function to return the new head of the reversed LinkedList.
 */
public class ReverseLinkedList {
    //time - O(n), space - O(1)
    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
