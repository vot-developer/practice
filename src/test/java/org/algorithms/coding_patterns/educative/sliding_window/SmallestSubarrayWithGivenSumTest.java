package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestSubarrayWithGivenSumTest {

    @Test
    void findMinSubArray() {
        assertEquals(2, SmallestSubarrayWithGivenSum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        assertEquals(1, SmallestSubarrayWithGivenSum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        assertEquals(3, SmallestSubarrayWithGivenSum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
    }
}