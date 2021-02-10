package org.algorithms.coding_patterns.educative.reversal_linkedlist;

/*
Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.
 */
public class RotateList {
    //time - O(n), space - O(1)
    public static ListNode rotate(ListNode head, int k) {
        if (head == null || k < 2)
            return head;

        ListNode current = head;
        ListNode prev = null;
        int i = 0;
        for (; i < k && current != null; i++) {
            prev = current;
            current = current.next;
        }

        if (i != k) {
            k %= i;
            current = head;
            prev = null;
            for (int j = 0; j < k && current != null; j++) {
                prev = current;
                current = current.next;
            }
        }

        if (current == null)
            return head;

        prev.next = null;
        ListNode newHead = current;
        while (current.next != null)
            current = current.next;

        current.next = head;

        return newHead;
    }
}
