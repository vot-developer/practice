package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestNumberTest {

    @Test
    void findKthSmallestNumber1() {
        assertEquals(5,
            KthSmallestNumber.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 3));
        assertEquals(5,
            KthSmallestNumber.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 4));
    }

    @Test
    void findKthSmallestNumber2() {
        assertEquals(11,
            KthSmallestNumber.findKthSmallestNumber(new int[]{5, 12, 11, -1, 12}, 3));
    }
}