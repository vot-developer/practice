package org.algorithms.coding_patterns.educative.fast_slow_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicLinkedListTest {
    private ListNode head;

    @BeforeEach
    void setUp() {
        head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
    }

    @Test
    void isPalindrome() {
        assertTrue(PalindromicLinkedList.isPalindrome(head));
    }

    @Test
    void isNotPalindrome() {
        head.next.next.next.next.next = new ListNode(2);
        assertFalse(PalindromicLinkedList.isPalindrome(head));
    }

    @Test
    void cornerCase1() {
        head = new ListNode(0);
        assertTrue(PalindromicLinkedList.isPalindrome(head));
    }

    @Test
    void cornerCase2() {
        head = new ListNode(0);
        head.next = new ListNode(0);
        assertTrue(PalindromicLinkedList.isPalindrome(head));
    }
}