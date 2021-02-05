package org.algorithms.coding_patterns.educative.fast_slow_pointers;

/*
Given the head of a LinkedList with a cycle, find the length of the cycle.
 */
public class LinkedListCycleLength {
    //time - O(n), space - O(1)
    public static int findCycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        int count = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode counter = slow;
                do {
                    counter = counter.next;
                    count++;
                } while (counter != slow);
                break;
            }
        }
        return count;
    }
}
