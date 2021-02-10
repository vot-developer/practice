package org.algorithms.coding_patterns.educative.reversal_linkedlist;

/*
Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */
public class ReverseEveryKElements {
    //time - O(n), space - O(1)
    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;

        ListNode current = head;
        ListNode next, beforeSublist = null, prev = null;
        while (current != null) {
            ListNode firstInSubList = current;
            for (int i = 0; i < k && current != null; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            firstInSubList.next = current;
            if (beforeSublist == null)
                head = prev;
            else
                beforeSublist.next = prev;
            beforeSublist = firstInSubList;
        }

        return head;
    }
}
