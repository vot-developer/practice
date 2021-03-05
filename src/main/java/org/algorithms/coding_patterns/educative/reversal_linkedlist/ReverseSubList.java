package org.algorithms.coding_patterns.educative.reversal_linkedlist;

/*
Given the head of a LinkedList and two positions 'p' and 'q', reverse the LinkedList from position 'p' to 'q'.
 */
public class ReverseSubList {
    //time - O(n), space - O(1)
    public static ListNode reverse(ListNode head, int p, int q) {
        if (head.next == null || p == q)
            return head;

        ListNode current = head;
        ListNode prev = null, next = null;
        for (int i = 1; i < p  && current != null; i++){
            prev = current;
            current = current.next;
        }
        ListNode beforeP = prev;
        ListNode nodeP = current;
        for (int i = 0; i < q - p + 1 && current != null; i++){ //finish on q + 1 node;
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (beforeP != null)
            beforeP.next = prev;
        else
            head = prev;

        nodeP.next = current;
        return head;
    }
}
