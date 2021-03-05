package org.algorithms.coding_patterns.educative.reversal_linkedlist;

/*
The problem follows the In-place Reversal of a LinkedList pattern and is quite similar to Reverse every K-element Sub-list.
The only difference is that we have to skip 'k' alternating elements.
We can follow a similar approach, and in each iteration after reversing 'k' elements, we will skip the next 'k' elements.
 */
public class ReverseAlternatingKElements {
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

            //skip next k
            for (int i = 0; i < k && current != null; i++) {
                prev = current;
                current = current.next;
            }
            firstInSubList = current;
            beforeSublist = prev;
        }

        return head;
    }
}
