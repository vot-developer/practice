package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KLargestNumbersTest {

    @Test
    void findKLargestNumbers1() {
        assertArrayEquals(new Integer[]{5, 12, 11},
            KLargestNumbers.findKLargestNumbers(new int[]{3, 1, 5, 12, 2, 11}, 3).toArray());
    }

    @Test
    void findKLargestNumbers2() {
        assertArrayEquals(new Integer[]{11, 12, 12},
            KLargestNumbers.findKLargestNumbers(new int[]{5, 12, 11, -1, 12}, 3).toArray());
    }
}