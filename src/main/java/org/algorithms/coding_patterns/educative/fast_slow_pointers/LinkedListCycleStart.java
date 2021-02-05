package org.algorithms.coding_patterns.educative.fast_slow_pointers;

/*
Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 */
public class LinkedListCycleStart {
    //time - O(n), space - O(1)
    public static ListNode findCycleStart(ListNode head) {
        int k = getCycleLength(head);
        if (k == 0)
            return null;

        ListNode pointer1 = head;
        ListNode pointer2 = head;
        for (int i = 0; i < k; i++)
            pointer1 = pointer1.next;

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    private static int getCycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                int count = 0;
                ListNode counter = slow;
                do {
                    counter = counter.next;
                    count++;
                } while (counter != slow);
                return count;
            }
        }
        return 0;
    }
}
