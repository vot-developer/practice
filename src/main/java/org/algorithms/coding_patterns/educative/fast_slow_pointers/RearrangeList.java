package org.algorithms.coding_patterns.educative.fast_slow_pointers;

/*
Given the head of a Singly LinkedList, write a method to modify the LinkedList such that
the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order.
So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 */
public class RearrangeList {
    //time - O(n), space - O(1)
    public static void reorder(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reverse = makeReverse(slow);
        while (head != null && reverse != null){
            ListNode temp = head.next;
            head.next = reverse;
            head = temp;

            temp = reverse.next;
            reverse.next = head;
            reverse = temp;
        }

        if (head != null)
            head.next = null;
    }

    private static ListNode makeReverse(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
