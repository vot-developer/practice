package org.algorithms.coding_patterns.educative.fast_slow_pointers;

/*
Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.

Your algorithm should use constant space and the input LinkedList
should be in the original form once the algorithm is finished.
The algorithm should have O(N)O(N) time complexity where 'N' is the number of nodes in the LinkedList.
 */
public class PalindromicLinkedList {
    //time - O(n), space - O(1)
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode checker = head;
        ListNode reverseChecker = makeReverse(slow);
        while (checker != null && reverseChecker != null) {
            if (checker.value != reverseChecker.value)
                return false;
            checker = checker.next;
            reverseChecker = reverseChecker.next;
        }

        return true;
    }

    private static ListNode makeReverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
