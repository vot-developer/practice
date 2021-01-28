package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSumSubarraySizeKTest {

    @Test
    void findMaxSumSubArray() {
        assertEquals(9, MaximumSumSubarraySizeK.findMaxSumSubArray(new int[]{2, 1, 5, 1, 3, 2}, 3));
        assertEquals(7, MaximumSumSubarraySizeK.findMaxSumSubArray(new int[]{2, 3, 4, 1, 5}, 2));
    }
}